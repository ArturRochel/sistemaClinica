package app.model;

import app.annotations.InfoAutor;
import app.interfaces.Identificavel;

@InfoAutor(nome = "Artur Rochel", data = "2025-12-09")
public class Paciente extends Usuario implements Identificavel {
    private String convenio;


    public Paciente(String cpf, String nome, int idade, String novoConvencio) {
        super(cpf, nome, idade);
        convenio = novoConvencio; // Hapvidade, Unimed e afins
    }

    @Override
    public String getId() {
        return this.getCpf();
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String attConvenio) {
        convenio = attConvenio;
    }

    @Override
    public String toString() {
        return "Paciente: " + getNome() + " / CPF: " + getCpf() + "\n";
    }
}
