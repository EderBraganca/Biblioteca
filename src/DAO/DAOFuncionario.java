package DAO;

import Dados.Dados;
import Modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;


public class DAOFuncionario implements DAOInterface<Funcionario>{
    private Dados dados = Dados.getDados();

    @Override
    public void cadastrar(Funcionario objeto) {     
        dados.listaFuncionarios.add(objeto);
    }

    @Override
    public List<Funcionario> listar() {
        return dados.listaFuncionarios;
    }

    @Override
    public void atualizar(Funcionario objeto) {   
        for(Funcionario x : dados.listaFuncionarios){
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
        dados.listaFuncionarios.remove(objeto);
    }    
}