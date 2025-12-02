package app.estruturaDeDados;

import java.util.function.Consumer;

public class ArvoreBinaria<T extends Comparable<T>> {
    private NoArvore<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserirDado(T novoDado) {
        if (raiz == null) {
            raiz = new NoArvore<>(novoDado);
        } else {
            raiz = verificarInserir(raiz, novoDado);
        }
    }

    private NoArvore<T> verificarInserir(NoArvore<T> raizAtual, T novoDado) {
        if (raizAtual == null) {
            return new NoArvore<>(novoDado);
        } else if (novoDado.compareTo(raizAtual.getValor()) < 0) {
            raizAtual.setEsquerda(verificarInserir(raizAtual.getNoEsquerda(), novoDado));
        } else if (novoDado.compareTo(raizAtual.getValor()) > 0) {
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
