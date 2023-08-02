package DAO;

import Modelo.Emprestimo;
import java.util.Date;
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
    
    public void cadastrar(int id, int idFuncionario, int idUsuario, int idLivro, Date dataEmprestimo){
        Emprestimo objeto = new Emprestimo(id, dataEmprestimo, idFuncionario, idUsuario, idLivro);
        cadastrar(objeto);
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
                x.setIdFuncionario(objeto.getIdFuncionario());
                x.setIdLivro(objeto.getIdLivro());
                x.setIdUsuario(objeto.getIdUsuario());
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