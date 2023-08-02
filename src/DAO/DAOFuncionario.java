package DAO;

import Modelo.Funcionario;
import java.util.List;


public class DAOFuncionario implements DAOInterface<Funcionario>{
    private List<Funcionario> listaFuncionarios;

    public DAOFuncionario(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    @Override
    public void cadastrar(Funcionario objeto) {     
        listaFuncionarios.add(objeto);
    }

    @Override
    public List<Funcionario> listar() {
        return listaFuncionarios;
    }

    @Override
    public void atualizar(Funcionario objeto) {   
        for(Funcionario x : listaFuncionarios){
            if(x.getId() == objeto.getId()){
                x.setMatricula(objeto.getMatricula());
                x.setNome(objeto.getNome());
                x.setSobreNome(objeto.getSobreNome());
                break;
            }
        } 
    }

    @Override
    public void remover(Funcionario objeto) {
        listaFuncionarios.remove(objeto);
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
}