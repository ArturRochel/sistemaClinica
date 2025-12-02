package app.model;

public class Paciente extends Usuario {
    private String convenio;
    
    public Paciente(String cpf, String nome, int idade, String novoConvencio) {
        super(cpf, nome, idade);
        convenio = novoConvencio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String attConvenio) {
        convenio = attConvenio;
    }
}
