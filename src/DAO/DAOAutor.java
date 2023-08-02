package DAO;

import Modelo.Autor;
import java.util.List;


public class DAOAutor implements DAOInterface<Autor>{
    private List<Autor> listaAutores;

    public DAOAutor(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    
    @Override
    public void cadastrar(Autor objeto) {
        listaAutores.add(objeto);
    }

    @Override
    public List<Autor> listar() {
        return listaAutores;
    }

    @Override
    public void atualizar(Autor objeto) {
        for(Autor x : listaAutores){
            if(x.getId() == objeto.getId()){
                x.setNome(objeto.getNome());
                x.setSobreNome(objeto.getSobreNome());
                x.setBiografia(objeto.getBiografia());
                break;
            }
        }
    }

    @Override
    public void remover(Autor objeto) {
        listaAutores.remove(objeto);
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    
}
