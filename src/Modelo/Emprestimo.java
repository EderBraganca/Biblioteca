package Modelo;

import java.util.Date;

public class Emprestimo {
    private int id;
    private Date dataEmprestimo;
    private int idFuncionario; 
    private int idUsuario;
    private int idLivro;

    public Emprestimo(int id, Date dataEmprestimo, int idFuncionario, int idUsuario, int idLivro) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.idFuncionario = idFuncionario;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    
}