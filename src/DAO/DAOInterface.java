package DAO;

import java.util.List;

//Classe criada para padronizar a criação das classes DAOS
public interface DAOInterface<T> {
    void cadastrar(T objeto);
    List<T> listar();
    void atualizar(T objeto);
    void remover(T objeto);
}
