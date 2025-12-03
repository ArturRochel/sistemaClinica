package app.model;
 // import app.excecoes.NegocioException;

public class Procedimento {
    private String nome;
    private String descricao;
    private double valor;

    private static int proximoId = 1;

    private final String codigoProcedimento;

    public Procedimento(String nomeProcedimento, double valorProcedimento) {
        if(nomeProcedimento == null) {
            // throw new NegocioException("O nome do procedimento não pode ser vazio");
        } 
        if(valorProcedimento < 0) {
             //throw new NegocioException("O valor do procedimento não pode ser negativo");
        }
        nome = nomeProcedimento;
        valor = valorProcedimento;
        //codigoProcedimento = "PRO" + String.format(, null)
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
