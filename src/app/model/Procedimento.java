package app.model;
 // import app.excecoes.NegocioException;

public class Procedimento {
    private String nome;
    private String descricao;
    private double valor;

    public Procedimento(String nomeProcedimento, double valorProcedimento) {
        if(nomeProcedimento == null) {
            // throw new NegocioException("O nome do procedimento não pode ser vazio");
        } 
        if(valorProcedimento < 0) {
             //throw new NegocioException("O valor do procedimento não pode ser negativo");
        }
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
