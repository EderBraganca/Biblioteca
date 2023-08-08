package DAO;

import Dados.Dados;
import Modelo.Emprestimo;
import java.util.Date;
import java.util.List;


//Classe DAO responsavel por Emprestimo e suas funções basicas, aqui sao tratadas as operações dos dados
public class DAOEmprestimo implements DAOInterface<Emprestimo>{
    private Dados dados = Dados.getDados();

    @Override
    public void cadastrar(Emprestimo objeto) {
        dados.listaEmprestimos.add(objeto);
    }
    
    public void cadastrar(int id, int idFuncionario, int idUsuario, int idLivro, Date dataEmprestimo){
        Emprestimo objeto = new Emprestimo(id, dataEmprestimo, idFuncionario, idUsuario, idLivro);
        cadastrar(objeto);
    }

    @Override
    public List<Emprestimo> listar() {
        return dados.listaEmprestimos;
    }

    @Override
    public void atualizar(Emprestimo objeto) {
        for(Emprestimo x : dados.listaEmprestimos){
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
        dados.listaEmprestimos.remove(objeto);
    }
}