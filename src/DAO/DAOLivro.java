package DAO;

import Modelo.Livro;
import java.util.List;


public class DAOLivro implements DAOInterface<Livro>{
    private List<Livro> listaLivros;

    public DAOLivro(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
    
    @Override
    public void cadastrar(Livro objeto) {
        listaLivros.add(objeto);
    }

    @Override
    public List<Livro> listar() {
        return listaLivros;
    }

    @Override
    public void atualizar(Livro objeto) {
        for(Livro x : listaLivros){
            if(x.getId() == objeto.getId()){
                x.setAutores(objeto.getAutores());
                x.setCategorias(objeto.getCategorias());
                x.setTitulo(objeto.getTitulo());
                break;
            }
        } 
    }

    @Override
    public void remover(Livro objeto) {
        listaLivros.remove(objeto);
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
}