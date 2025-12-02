package app.model;

public class Profissional extends Usuario{
    private String formacao;
    private String matricula;
    
    public Profissional(String cpf, String nome, int idade, String novaFormacao, String novaMatricula) {
        super(cpf, nome, idade);
        formacao = novaFormacao;
        matricula = novaMatricula;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String attFormacao) {
        formacao = attFormacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String attMatricula) {
        matricula = attMatricula;
    }
}
