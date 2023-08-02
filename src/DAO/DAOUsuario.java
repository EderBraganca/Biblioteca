package DAO;

import Modelo.Usuario;
import java.util.List;


public class DAOUsuario implements DAOInterface<Usuario>{
    private List<Usuario> listaUsuarios;

    public DAOUsuario(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public void cadastrar(Usuario objeto) {
        listaUsuarios.add(objeto);
    }

    @Override
    public List<Usuario> listar() {
        return listaUsuarios;
    }

    @Override
    public void atualizar(Usuario objeto) {
        for(Usuario x : listaUsuarios){
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
        listaUsuarios.remove(objeto);
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}