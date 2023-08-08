package Interface;
import Dados.Dados;
import static Interface.AutorInterface.telaCrudAutor;
import static Interface.FuncionarioInterface.telaCrudFuncionario;
import static Interface.CategoriaInterface.telaCrudCategoria;
import static Interface.LivroInterface.telaCrudLivro;
import static Interface.OperacoesInterface.telaOperacoes;
import static Interface.UsuarioInterface.telaCrudUsuario;
import Principal.Biblioteca;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

//Classe para a tela Inicial
public class BibliotecaInterface {
    Dados dados = Dados.getDados();
    
    //Tela inicial para o Administrador/Funcionario
    public static void InterfaceInicialAdmin(String[] args) {
        JFrame telaInicial = new JFrame("Tela Inicial");
        
        //Acoes dos botoes da interface inicial da tela
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
        ActionListener acaoBotaoLogoff = (ActionEvent e) -> {
            telaInicial.dispose();
            Biblioteca.main(args);
        };
        ActionListener acaoBotaoExit = (ActionEvent e) -> {
            System.exit(0);
        };
        
        telaInicial.setSize(600, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setLocationRelativeTo(null);
        
        JPanel menu = new JPanel(new GridLayout(4, 1));
     
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
        
        JButton logoffBt = new JButton("Logout");
        logoffBt.addActionListener(acaoBotaoLogoff);
        menu.add(logoffBt);
        
        JButton exitBt = new JButton("Sair");
        exitBt.addActionListener(acaoBotaoExit);
        menu.add(exitBt);
        
        telaInicial.add(menu);
    
        telaInicial.setVisible(true);
    }    
    
    //Tela inicial para o usuario
    public static void InterfaceInicialUsuario(String[] args) {
        JFrame telaInicial = new JFrame("Tela Inicial");
        
        ActionListener acaoBotaoEmp = (ActionEvent e) -> {
            telaOperacoes("Usuario");
        };
        ActionListener acaoBotaoLogoff = (ActionEvent e) -> {
            telaInicial.dispose();
            Biblioteca.main(args);
        };
        ActionListener acaoBotaoExit = (ActionEvent e) -> {
            System.exit(0);
        };
        
        telaInicial.setSize(600, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new GridLayout(4, 1));
        
        JButton crudEmprestimoBt = new JButton("Operacoes");
        crudEmprestimoBt.addActionListener(acaoBotaoEmp);
        menu.add(crudEmprestimoBt);
        
        JButton logoffBt = new JButton("Logout");
        logoffBt.addActionListener(acaoBotaoLogoff);
        menu.add(logoffBt);
        
        JButton exitBt = new JButton("Sair");
        exitBt.addActionListener(acaoBotaoExit);
        menu.add(exitBt);
        
        telaInicial.add(menu);
        
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setVisible(true);
    }    
}