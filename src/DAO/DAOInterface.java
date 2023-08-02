package DAO;

import java.util.List;

public interface DAOInterface<T> {
    void cadastrar(T objeto);
    List<T> listar();
    void atualizar(T objeto);
    void remover(T objeto);
}
