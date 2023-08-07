package Dados;

import Modelo.Autor;
import Modelo.Categoria;
import Modelo.Emprestimo;
import Modelo.Funcionario;
import Modelo.Livro;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Dados {
    private static Dados dados;

    public static Dados getDados() {
        if (dados == null) {
            dados = new Dados();
        }
        return dados;
    }
    public List<Funcionario> listaFuncionarios = new ArrayList<>();
    public List<Usuario> listaUsuarios = new ArrayList<>();
    public List<Autor> listaAutores = new ArrayList<>();
    public List<Livro> listaLivros = new ArrayList<>();
    public List<Categoria> listaCategorias = new ArrayList<>();
    public List<Emprestimo> listaEmprestimos = new ArrayList<>();
}