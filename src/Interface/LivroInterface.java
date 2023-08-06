package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LivroInterface {
    
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
    
    public static void telaCadastrarLivro(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        telaCadastro.setSize(600, 600);
        
        JPanel panelCadastro = new JPanel();
        
        JButton calcelarBt = new JButton("Cancelar");
        JButton salvarBt = new JButton("Salvar");

        panelCadastro.add(calcelarBt);
        panelCadastro.add(salvarBt);
        
        telaCadastro.add(panelCadastro);
        telaCadastro.setVisible(true);
    };
    
    public static void telaListarLivro(){
        JFrame telaFuncionario = new JFrame("Tela Listagem");
        telaFuncionario.setSize(600, 600);
        
        JPanel panelFuncionario = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelFuncionario.add(cadastrarBt);
        panelFuncionario.add(listarBt);
        
        telaFuncionario.add(panelFuncionario);
        telaFuncionario.setVisible(true);
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
    
    public static void telaCadastrarCategoria(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        telaCadastro.setSize(600, 600);
        
        JPanel panelCadastro = new JPanel();
        
        JButton calcelarBt = new JButton("Cancelar");
        JButton salvarBt = new JButton("Salvar");

        panelCadastro.add(calcelarBt);
        panelCadastro.add(salvarBt);
        
        telaCadastro.add(panelCadastro);
        telaCadastro.setVisible(true);
    };
    
    public static void telaListarCategoria(){
        JFrame telaCadastro = new JFrame("Tela Listagem");
        telaCadastro.setSize(600, 600);
        
        JPanel panelFuncionario = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelFuncionario.add(cadastrarBt);
        panelFuncionario.add(listarBt);
        
        telaCadastro.add(panelFuncionario);
        telaCadastro.setVisible(true);
    };
}
