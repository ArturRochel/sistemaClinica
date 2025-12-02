package app.model;

public class Usuario {
    private String cpf;
    private String nome;
    private int idade;

    public Usuario(String novoCpf, String novoNome, int novaIdade) {
        cpf = novoCpf;
        nome = novoNome;
        idade = novaIdade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
