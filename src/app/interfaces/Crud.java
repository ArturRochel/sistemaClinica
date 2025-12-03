package app.interfaces;

import app.excecoes.NegocioException;
import java.util.List;

public interface Crud<T> {
    void adicionar(T elemento) throws NegocioException;
    void remover(String id) throws NegocioException;
    T buscarPorId(String id) throws NegocioException;
    List<T> listarTodos();
}
