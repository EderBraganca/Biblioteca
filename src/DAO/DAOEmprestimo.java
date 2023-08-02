package DAO;

import Modelo.Emprestimo;
import java.util.List;


public class DAOEmprestimo implements DAOInterface<Emprestimo>{
    private List<Emprestimo> listaEmprestimos;

    public DAOEmprestimo(List<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }
    
    @Override
    public void cadastrar(Emprestimo objeto) {
        listaEmprestimos.add(objeto);
    }

    @Override
    public List<Emprestimo> listar() {
        return listaEmprestimos;
    }

    @Override
    public void atualizar(Emprestimo objeto) {
        for(Emprestimo x : listaEmprestimos){
            if(x.getId() == objeto.getId()){
                x.setDataEmprestimo(objeto.getDataEmprestimo());
                x.setFuncionarioEmp(objeto.getFuncionarioEmp());
                x.setLivroEmp(objeto.getLivroEmp());
                x.setUsuarioEmp(objeto.getUsuarioEmp());
                break;
            }
        }
    }

    @Override
    public void remover(Emprestimo objeto) {
        listaEmprestimos.remove(objeto);
    }

    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(List<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }
    
}