package app.estruturaDeDados;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.List;
import app.excecoes.NegocioException;
import app.interfaces.Identificavel;


public class ArvoreBinaria<T extends Identificavel> {
    private NoArvore<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserirDado(T novoDado) throws NegocioException {
        if (raiz == null) {
            raiz = new NoArvore<>(novoDado);
        } else {
            raiz = verificarInserir(raiz, novoDado);
        }
    }

    private NoArvore<T> verificarInserir(NoArvore<T> raizAtual, T novoDado) throws NegocioException{
        if (raizAtual == null) {
            return new NoArvore<>(novoDado);
        } else if(novoDado.getId().compareTo(raizAtual.getId()) == 0) {
            throw new NegocioException("Um dado com este ID já está cadastrado");
        } else if (novoDado.getId().compareTo(raizAtual.getId()) < 0) {
            raizAtual.setEsquerda(verificarInserir(raizAtual.getNoEsquerda(), novoDado));
        } else if (novoDado.getId().compareTo(raizAtual.getId()) > 0) {
            raizAtual.setDireita(verificarInserir(raizAtual.getNoDireita(), novoDado));
        }
        return raizAtual;
    }

    public T max() {
        if (raiz == null) return null;
        return maximoRecursivo(raiz);
    }

    private T maximoRecursivo(NoArvore<T> raizAtual) {
        if (raizAtual.getNoDireita() == null) {
            return raizAtual.getValor();
        }
        return maximoRecursivo(raizAtual.getNoDireita());
    }

    public T min() {
        if (raiz == null) return null;
        return minimoRecursivo(raiz);
    }

    private T minimoRecursivo(NoArvore<T> raizAtual) {
        if (raizAtual.getNoEsquerda() == null) {
            return raizAtual.getValor();
        }
        return minimoRecursivo(raizAtual.getNoEsquerda());
    }

    public T buscarId(String idBuscado) throws NegocioException {
        return buscaRecursiva(this.raiz, idBuscado).getValor();
    }

    private NoArvore<T> buscaRecursiva(NoArvore<T> noAtual, String idBuscado) throws NegocioException {
        if(noAtual == null) {
            throw new NegocioException("ID não encontrado na arvore");
        }

        int comparador = idBuscado.compareTo(noAtual.getId());
        if(comparador == 0) {
            return noAtual;
        } else if(comparador < 0) {
            return buscaRecursiva(noAtual.getNoEsquerda(), idBuscado);
        } else {
            return buscaRecursiva(noAtual.getNoDireita(), idBuscado);
        }
    }

    public void removerId(String idRemocao) throws NegocioException {
        raiz = remocaoRecursiva(this.raiz, idRemocao);
    }

    private NoArvore<T> remocaoRecursiva(NoArvore<T> noAtual, String idRemocao) throws NegocioException {
        if(noAtual == null) {
            throw new NegocioException("ID não encontrado na árvore");
        }

        int comparador = idRemocao.compareTo(noAtual.getId());
        if(comparador < 0) {
            noAtual.setEsquerda(remocaoRecursiva(noAtual.getNoEsquerda(), idRemocao));
            return noAtual;
        } else if(comparador > 0) {
            noAtual.setDireita(remocaoRecursiva(noAtual.getNoDireita(), idRemocao));
            return noAtual;
        } else {
            if(noAtual.getNoEsquerda() == null && noAtual.getNoDireita() == null) {
                return null;
            } else if(noAtual.getNoEsquerda() != null && noAtual.getNoDireita() == null) {
                return noAtual.getNoEsquerda();
            } else if(noAtual.getNoEsquerda() == null && noAtual.getNoDireita() != null) {
                return noAtual.getNoDireita();
            } else {
                // Essa lógica subtitutitui a raiz pelo menor da direita
                // então volta para tornar null o menor
                NoArvore<T> menorNoDireita = minDireita(noAtual.getNoDireita());
                noAtual.setValor(menorNoDireita.getValor());
                noAtual.setId(menorNoDireita.getId());
                noAtual.setDireita(remocaoRecursiva(noAtual.getNoDireita(), menorNoDireita.getId()));
                return noAtual;
            }
        }
    }

    private NoArvore<T> minDireita(NoArvore<T> raizAtual) {
        if(raizAtual.getNoEsquerda() == null) {
            return raizAtual;
        }
        return minDireita(raizAtual.getNoEsquerda());
    }

    public void percorrerInOrder(Consumer<T> acao) {
        percorrerInOrderRec(raiz, acao);
    }

    private void percorrerInOrderRec(NoArvore<T> no, Consumer<T> acao) {
        if (no == null) return;
        percorrerInOrderRec(no.getNoEsquerda(), acao);
        acao.accept(no.getValor());
        percorrerInOrderRec(no.getNoDireita(), acao);
    }

    public List<T> listarTodos() {
        List<T> listaTemporaria = new ArrayList<>();
        listarRecursivamente(this.raiz, listaTemporaria);
        return listaTemporaria;
    }

    private void listarRecursivamente(NoArvore<T> noAtual, List<T> lista) {
        if(noAtual == null) return;
        listarRecursivamente(noAtual.getNoEsquerda(), lista);
        lista.add(noAtual.getValor());
        listarRecursivamente((noAtual.getNoDireita()), lista);
    }
}
