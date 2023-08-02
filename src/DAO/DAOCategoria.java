package DAO;

import Modelo.Categoria;
import java.util.List;


public class DAOCategoria implements DAOInterface<Categoria>{
    private List<Categoria> listaCategorias;

    public DAOCategoria(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    @Override
    public void cadastrar(Categoria objeto) {
        listaCategorias.add(objeto);
    }
    
    public void cadastrar(int id, String titulo){
        Categoria objeto = new Categoria(id, titulo);
        cadastrar(objeto);
    }

    @Override
    public List<Categoria> listar() {
        return listaCategorias;
    }

    @Override
    public void atualizar(Categoria objeto) {        
        for(Categoria x : listaCategorias){
            if(x.getId() == objeto.getId()){
                x.setTitulo(objeto.getTitulo());
                break;
            }
        }
    }

    @Override
    public void remover(Categoria objeto) {
        listaCategorias.remove(objeto);
    }
    
    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
}
