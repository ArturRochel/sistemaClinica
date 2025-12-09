package app.model;
// import app.excecoes.NegocioException;

import app.interfaces.Identificavel;

public class Procedimento implements Identificavel {
    private String nome;
    private String descricao;
    private double valor;

    private static int proximoId = 1;

    private final String codigoProcedimento;

    public Procedimento(String nomeProcedimento, double valorProcedimento) {
        if (nomeProcedimento == null || nomeProcedimento.isBlank()) {
            // throw new NegocioException("O nome do procedimento não pode ser vazio");
        }
        if (valorProcedimento < 0) {
            //throw new NegocioException("O valor do procedimento não pode ser negativo");
        }
        nome = nomeProcedimento;
        valor = valorProcedimento;
        this.codigoProcedimento = "PROC" + String.format("%02d", proximoId);
        proximoId++;
    }

    @Override
    public String getId() {
        return this.codigoProcedimento;
    }

    public String getCodigoProcedimento() {
        return codigoProcedimento;
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

    @Override
    public String toString() {
        return "Procedimento: " + nome + " / Valor: R$" + valor + "\n";
    }
}
