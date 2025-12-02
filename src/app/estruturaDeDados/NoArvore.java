package app.estruturaDeDados;

class NoArvore<T extends Comparable<T>> {
    private T valor;
    private NoArvore<T> noEsquerda; // Pela lógica da ABB o nó da esquerda é sempre o menor
    private NoArvore<T> noDireita; // Já o nó da direita é sempre o maior

    public NoArvore(T valorDoNo) {
        valor = valorDoNo;
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
}
