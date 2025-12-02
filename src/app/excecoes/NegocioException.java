package app.excecoes;

public class NegocioException extends Exception {
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
