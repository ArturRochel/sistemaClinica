package app.interfaces;

import app.excecoes.NegocioException;
import java.util.List;

public interface Crud<T> {
    boolean adicionar(T elemento) throws NegocioException;
    void removerPorId(String id) throws NegocioException;
    //void editarNo(String id) throws NegocioException;
    T buscarPorId(String id) throws NegocioException;
    List<T> listarTodos();
}
