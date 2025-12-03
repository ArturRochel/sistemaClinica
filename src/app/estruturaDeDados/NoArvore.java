package app.estruturaDeDados;

import app.interfaces.Identificavel;

class NoArvore<T extends Identificavel> {
    private T valor;
    private String id;
    private NoArvore<T> noEsquerda; // Pela lógica da ABB o nó da esquerda é sempre o menor
    private NoArvore<T> noDireita; // Já o nó da direita é sempre o maior

    public NoArvore(T valorDoNo) {
        valor = valorDoNo;
        id = valorDoNo.getId();
        noEsquerda = null;
        noDireita = null;
    }

    public void setEsquerda(NoArvore<T> noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public void setDireita(NoArvore<T> noDireita) {
        this.noDireita = noDireita;
    }

    public T getValor() {
        return valor;
    }

    public NoArvore<T> getNoEsquerda() {
        return noEsquerda;
    }

    public NoArvore<T> getNoDireita() {
        return noDireita;
    }

    public String getId() {
        return this.id;
    }
}
