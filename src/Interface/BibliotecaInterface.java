package Interface;
import Dados.Dados;
import static Interface.AutorInterface.telaCrudAutor;
import static Interface.FuncionarioInterface.telaCrudFuncionario;
import static Interface.CategoriaInterface.telaCrudCategoria;
import static Interface.LivroInterface.telaCrudLivro;
import static Interface.OperacoesInterface.telaOperacoes;
import static Interface.UsuarioInterface.telaCrudUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BibliotecaInterface {
    Dados dados = Dados.getDados();
    
    public static void InterfaceInicialAdmin(String[] args) {
        ActionListener acaoBotaoFunc = (ActionEvent e) -> {
            telaCrudFuncionario();
        };
        ActionListener acaoBotaoUsuario = (ActionEvent e) -> {
            telaCrudUsuario();
        };
        ActionListener acaoBotaoAutor = (ActionEvent e) -> {
            telaCrudAutor();
        };
        ActionListener acaoBotaoLivro = (ActionEvent e) -> {
            telaCrudLivro();
        };
        ActionListener acaoBotaoCategoria = (ActionEvent e) -> {
            telaCrudCategoria();
        };
        ActionListener acaoBotaoEmp = (ActionEvent e) -> {
            telaOperacoes("admin");
        };

        JFrame telaInicial = new JFrame("Tela Inicial");
        
        telaInicial.setSize(600, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setLocationRelativeTo(null);
        
        JPanel menu = new JPanel();
     
        JButton crudFuncionarioBt = new JButton("Funcionario");
        crudFuncionarioBt.addActionListener(acaoBotaoFunc);
        menu.add(crudFuncionarioBt);
        
        JButton crudUsuarioBt = new JButton("Usuario");
        crudUsuarioBt.addActionListener(acaoBotaoUsuario);
        menu.add(crudUsuarioBt);
        
        JButton crudLivroBt = new JButton("Livro");
        crudLivroBt.addActionListener(acaoBotaoLivro);
        menu.add(crudLivroBt);
        
        JButton crudAutorBt = new JButton("Autor");
        crudAutorBt.addActionListener(acaoBotaoAutor);
        menu.add(crudAutorBt);
        
        JButton crudCategoriaBt = new JButton("Categoria");
        crudCategoriaBt.addActionListener(acaoBotaoCategoria);
        menu.add(crudCategoriaBt);
        
        JButton crudEmprestimoBt = new JButton("Operacoes");
        crudEmprestimoBt.addActionListener(acaoBotaoEmp);
        menu.add(crudEmprestimoBt);
        
        telaInicial.add(menu);
        
        telaInicial.setVisible(true);
    }    
    
    public static void InterfaceInicialUsuario(String[] args) {
        ActionListener acaoBotaoEmp = (ActionEvent e) -> {
            telaOperacoes("Usuario");
        };

        JFrame telaInicial = new JFrame("Tela Inicial");
        telaInicial.setLocationRelativeTo(null);
        
        telaInicial.setSize(600, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel();
        
        JButton crudEmprestimoBt = new JButton("Operacoes");
        crudEmprestimoBt.addActionListener(acaoBotaoEmp);
        menu.add(crudEmprestimoBt);
        
        telaInicial.add(menu);
        
        telaInicial.setVisible(true);
    }    
}