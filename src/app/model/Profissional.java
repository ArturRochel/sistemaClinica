package app.model;

import app.interfaces.Identificavel;

public class Profissional extends Usuario implements Identificavel {
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

    public void setMatricula(String attMatricula) {
        matricula = attMatricula;
    }

    public String getId() {
        return this.matricula;
    }

    @Override
    public String toString() {
        return "Profissional: " + getNome() + " / Formação: " + formacao + "\n";
    }
}
