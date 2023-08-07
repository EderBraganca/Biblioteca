package DAO;

import Dados.Dados;
import Modelo.Livro;
import java.util.List;


public class DAOLivro implements DAOInterface<Livro>{
    private Dados dados = Dados.getDados();
    
    @Override
    public void cadastrar(Livro objeto) {
        dados.listaLivros.add(objeto);
    }
    
    public void cadastrar(int id, String titulo, List<Integer> categoria, List<Integer> autor) {
        Livro objeto = new Livro(id, titulo, categoria, autor);
        cadastrar(objeto);
    }

    @Override
    public List<Livro> listar() {
        return dados.listaLivros;
    }

    @Override
    public void atualizar(Livro objeto) {
        for(Livro x : dados.listaLivros){
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
        dados.listaLivros.remove(objeto);
    }
}