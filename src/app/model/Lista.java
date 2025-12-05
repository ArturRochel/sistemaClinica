package app.model;

import app.estruturaDeDados.ArvoreBinaria;
import app.excecoes.NegocioException;
import app.interfaces.Crud;
import app.interfaces.Identificavel;
import java.util.List;

// Uma classe que vai receber uma classe que tem a interface Identificavel e vai implementar a interface Crud
public class Lista<T extends Identificavel> implements Crud<T> {
    // Eu preciso implementar os métodos da interface
    // Utilizar a estrutura de dados da árvore de busca binária
    // Utilizar o NoArvore para inserir dados

    private ArvoreBinaria<T> estruturaDeDados;
    private String nomeLista;

    public Lista(String nome) {
        nomeLista = nome;
        this.estruturaDeDados = new ArvoreBinaria<>();
    }

    @Override // Para inserir eu vou chamar a prórpia estrutura e 
    public boolean adicionar(T elemento) throws NegocioException {
        try {
            this.estruturaDeDados.inserirDado(elemento);
            return true;
        } catch (NegocioException e) {
            return false;
        }
    }

    @Override
    public boolean removerPorId(String idRemocao) throws NegocioException {
        return estruturaDeDados.removerId(idRemocao);
    }

    @Override
    public T buscarPorId(String idBuscado) throws NegocioException {
        return estruturaDeDados.buscarId(idBuscado);
    }

    @Override
    public List<T> listarTodos() {
        // Tratar exceção
    }
}
