package app.model;

public class Procedimento {
    private String nome;
    private String descricao;
    private double valor;

    public Procedimento(String nomeProcedimento, double valorProcedimento) {
        nome = nomeProcedimento;
        valor = valorProcedimento;
    }

    public void setDescricao(String addDescricao) {
        descricao = addDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        nome = nomeProcedimento;
    }

    public String getNomeProcedimento() {
        return nome;
    }

    public void setValor(double addValor) {
        valor = addValor;
    }

    public double getValor() {
        return valor;
    }
}
