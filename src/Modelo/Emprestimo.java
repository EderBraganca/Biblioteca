package Modelo;

import java.util.Date;

public class Emprestimo {
    private int id;
    private Date dataEmprestimo;
    private Funcionario funcionarioEmp; 
    private Usuario usuarioEmp;
    private Livro livroEmp;

    public Emprestimo(int id, Date dataEmprestimo, Funcionario funcionarioEmp, Usuario usuarioEmp, Livro livroEmp) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.funcionarioEmp = funcionarioEmp;
        this.usuarioEmp = usuarioEmp;
        this.livroEmp = livroEmp;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Funcionario getFuncionarioEmp() {
        return funcionarioEmp;
    }

    public void setFuncionarioEmp(Funcionario funcionarioEmp) {
        this.funcionarioEmp = funcionarioEmp;
    }

    public Usuario getUsuarioEmp() {
        return usuarioEmp;
    }

    public void setUsuarioEmp(Usuario usuarioEmp) {
        this.usuarioEmp = usuarioEmp;
    }

    public Livro getLivroEmp() {
        return livroEmp;
    }

    public void setLivroEmp(Livro livroEmp) {
        this.livroEmp = livroEmp;
    }
}