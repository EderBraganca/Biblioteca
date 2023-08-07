package DAO;

import Dados.Dados;
import Modelo.Autor;
import java.util.List;


public class DAOAutor implements DAOInterface<Autor>{
    private Dados dados = Dados.getDados();

    @Override
    public void cadastrar(Autor objeto) {
        dados.listaAutores.add(objeto);
    }
    
    public void cadastrar(int id, String nome, String sobreNome, String biografia) {
        Autor objeto = new Autor(biografia, id, nome, sobreNome);
        cadastrar(objeto);
    }

    @Override
    public List<Autor> listar() {
        return dados.listaAutores;
    }

    @Override
    public void atualizar(Autor objeto) {
        for(Autor x : dados.listaAutores){
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
        dados.listaAutores.remove(objeto);
    }
}