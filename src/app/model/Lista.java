package app.model;

import app.annotations.InfoAutor;
import app.estruturaDeDados.ArvoreBinaria;
import app.excecoes.NegocioException;
import app.interfaces.Crud;
import app.interfaces.Identificavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

@InfoAutor(nome = "Artur Rochel", data = "2025-12-09")
public class Lista<T extends Identificavel> implements Crud<T> {

    private final ArvoreBinaria<T> estruturaDeDados;
    private final String nomeLista;

    public Lista(String nome) {
        this.nomeLista = nome;
        this.estruturaDeDados = new ArvoreBinaria<>();
    }

    public String getNome() {
        return this.nomeLista;
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
    public void removerPorId(String idRemocao) throws NegocioException {
        estruturaDeDados.removerId(idRemocao);
    }

    @Override
    public T buscarPorId(String idBuscado) throws NegocioException {
        return estruturaDeDados.buscarId(idBuscado);
    }

    @Override
    public List<T> listarTodos(Comparator<T> comparador) {
        // Pacientes são ordenados por nome
        // Profissionais são ordenados por nome
        // Procedimentos são ordenados por valor
        // Serviços são ordenados por datas
        List<T> lista = estruturaDeDados.listarTodos();
        return mergeSort(lista, comparador);
    }

    private List<T> mergeSort(List<T> listaDesordenada, Comparator<T> comparador) {
        // Caso base da recursão quando a lista tem um único item e encontra-se ordenada
        if (listaDesordenada.size() <= 1) return listaDesordenada;

        // Divide a lista pela metade
        int meio = listaDesordenada.size() / 2;
        List<T> esquerda = new ArrayList<>();
        List<T> direita = new ArrayList<>();

        // Preenche a primeira metade
        for (int i = 0; i < meio; i++) {
            esquerda.add(listaDesordenada.get(i));
        }

        // Preenche a segunda metade
        for (int i = meio; i < listaDesordenada.size(); i++) {
            direita.add(listaDesordenada.get(i));
        }

        // Chama a recursão para organizar as duas metades
        esquerda = mergeSort(esquerda, comparador);
        direita = mergeSort(direita, comparador);

        return merge(esquerda, direita, comparador);
    }

    private List<T> merge(List<T> esquerda, List<T> direita, Comparator<T> comparador) {
        List<T> listaTemporaria = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < esquerda.size() && j < direita.size()) {
            if (comparador.compare(esquerda.get(i), direita.get(j)) < 0) {
                listaTemporaria.add(esquerda.get(i));
                i += 1;
            } else {
                listaTemporaria.add(direita.get(j));
                j += 1;
            }
        }

        while (i < esquerda.size()) {
            listaTemporaria.add(esquerda.get(i));
            i += 1;
        }

        while (j < direita.size()) {
            listaTemporaria.add(direita.get(j));
            j += 1;
        }

        return listaTemporaria;
    }
}
