package biblioteca;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BibliotecaInterface {
    Dados dados = new Dados();
    
    public static void main(String[] args) {
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
            telaCrudUsuario();
        };
        ActionListener acaoBotaoEmp = (ActionEvent e) -> {
            telaEmprestimo();
        };
        ActionListener acaoBotaoCategoria = (ActionEvent e) -> {
            telaCrudCategoria();
        };

        JFrame telaInicial = new JFrame("Tela Inicial");
        
        telaInicial.setSize(600, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    
    public static void telaCrudFuncionario(){
        JFrame telaFuncionario = new JFrame("Tela Funcionario");
        telaFuncionario.setSize(600, 600);
        
        JPanel panelFuncionario = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelFuncionario.add(cadastrarBt);
        panelFuncionario.add(listarBt);
        
        telaFuncionario.add(panelFuncionario);
        telaFuncionario.setVisible(true);
    };
    
    public static void telaCrudUsuario(){
        JFrame telaUsuario = new JFrame("Tela Usuario");
        telaUsuario.setSize(600, 600);
        
        JPanel panelUsuario = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelUsuario.add(cadastrarBt);
        panelUsuario.add(listarBt);
        
        telaUsuario.add(panelUsuario);
        telaUsuario.setVisible(true);
    };
    
    public static void telaCrudAutor(){
        JFrame telaAutor = new JFrame("Tela Autor");
        telaAutor.setSize(600, 600);
        
        JPanel panelAutor = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelAutor.add(cadastrarBt);
        panelAutor.add(listarBt);
        
        telaAutor.add(panelAutor);
        telaAutor.setVisible(true);
    };
    
    public static void telaCrudLivro(){
        JFrame telaLivro = new JFrame("Tela Livro");
        telaLivro.setSize(600, 600);
        
        JPanel panelLivro = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelLivro.add(cadastrarBt);
        panelLivro.add(listarBt);
        
        telaLivro.add(panelLivro);
        telaLivro.setVisible(true);
    };
    
    public static void telaCrudCategoria(){
        JFrame telaCategoria = new JFrame("Tela Categoria");
        telaCategoria.setSize(600, 600);
        
        JPanel panelCategoria = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelCategoria.add(cadastrarBt);
        panelCategoria.add(listarBt);
        
        telaCategoria.add(panelCategoria);
        telaCategoria.setVisible(true);
    };
    
    public static void telaEmprestimo(){
        JFrame telaEmprestimo = new JFrame("Tela Emprestimo");
        telaEmprestimo.setSize(600, 600);
        
        JPanel panelEmprestimo = new JPanel();
        
        JButton realizarEmpBt = new JButton("Cadastrar Emprestimo");
        JButton consultarBt = new JButton("Listar");

        panelEmprestimo.add(realizarEmpBt);
        panelEmprestimo.add(consultarBt);
        
        telaEmprestimo.add(panelEmprestimo);
        telaEmprestimo.setVisible(true);
    };
}
