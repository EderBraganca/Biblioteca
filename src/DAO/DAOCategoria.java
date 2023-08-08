package DAO;

import Dados.Dados;
import Modelo.Categoria;
import java.util.List;

//Classe DAO responsavel por Categoria e suas funções basicas, aqui sao tratadas as operações dos dados
public class DAOCategoria implements DAOInterface<Categoria>{
    private Dados dados = Dados.getDados();

    public DAOCategoria(Dados dados) {
        this.dados = dados;
    }
    
    @Override
    public void cadastrar(Categoria objeto) {
        dados.listaCategorias.add(objeto);
    }
    
    public void cadastrar(int id, String titulo){
        Categoria objeto = new Categoria(id, titulo);
        cadastrar(objeto);
    }

    @Override
    public List<Categoria> listar() {
        return dados.listaCategorias;
    }

    @Override
    public void atualizar(Categoria objeto) {        
        for(Categoria x : dados.listaCategorias){
            if(x.getId() == objeto.getId()){
                x.setTitulo(objeto.getTitulo());
                break;
            }
        }
    }

    @Override
    public void remover(Categoria objeto) {
        dados.listaCategorias.remove(objeto);
    }
}