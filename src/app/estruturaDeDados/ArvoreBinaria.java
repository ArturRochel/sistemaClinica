package app.estruturaDeDados;

import java.util.function.Consumer;

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
        return buscaRecursiva(this.raiz, idBuscado);
    }

    private T buscaRecursiva(NoArvore<T> noAtual, String idBuscado) throws NegocioException {
        if(noAtual == null) {
            throw new NegocioException("ID não encontrado na arvore");
        }

        int comparador = idBuscado.compareTo(noAtual.getId());
        if(comparador == 0) {
            return noAtual.getValor();
        } else if(comparador < 0) {
            return buscaRecursiva(noAtual.getNoEsquerda(), idBuscado);
        } else {
            return buscaRecursiva(noAtual.getNoDireita(), idBuscado);
        }
    }

    public boolean removerId(String idRemocao) throws NegocioException {
        this.raiz = remocaoRecursiva(this.raiz, idRemocao);
        return true;
    }

    private NoArvore<T> remocaoRecursiva(NoArvore<T> noAtual, String idRemocao) throws NegocioException {
        if(noAtual == null) {
            throw new NegocioException("No atual z");
        }

        int comparador = idRemocao.compareTo(noAtual.getId());

        if(comparador < 0) {
            return remocaoRecursiva(noAtual.getNoDireita(), idRemocao);
        } else if(comparador > 0) {
            return remocaoRecursiva(noAtual.getNoDireita(), idRemocao);
        } else {
            if(noAtual.getNoDireita() == null && noAtual.getNoDireita() == null) {
                return null;
            }
        }
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
}
