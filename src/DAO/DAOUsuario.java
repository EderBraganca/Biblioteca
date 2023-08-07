package DAO;

import Dados.Dados;
import Modelo.Usuario;
import java.util.List;


public class DAOUsuario implements DAOInterface<Usuario>{
    private Dados dados = Dados.getDados();
    
    @Override
    public void cadastrar(Usuario objeto) {
        dados.listaUsuarios.add(objeto);
    }
   
    public void cadastrar(int id, String nome, String sobreNome, int registroAcademico) {
        Usuario objeto = new Usuario(registroAcademico, id, nome, sobreNome);
        cadastrar(objeto);
    }

    @Override
    public List<Usuario> listar() {
        return dados.listaUsuarios;
    }

    @Override
    public void atualizar(Usuario objeto) {
        for(Usuario x : dados.listaUsuarios){
            if(x.getId() == objeto.getId()){
                x.setNome(objeto.getNome());
                x.setSobreNome(objeto.getSobreNome());
                x.setRegistroAcademico(objeto.getRegistroAcademico());
                break;
            }
        } 
    }

    @Override
    public void remover(Usuario objeto) {
        dados.listaUsuarios.remove(objeto);
    }
}