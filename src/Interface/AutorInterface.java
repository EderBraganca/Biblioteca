package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AutorInterface {
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
    
    public static void telaCadastrarAutor(){
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
    
    public static void telaListarAutor(){
        JFrame telaFuncionario = new JFrame("Tela Listagem");
        telaFuncionario.setSize(600, 600);
        
        JPanel panelCadastro = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelCadastro.add(cadastrarBt);
        panelCadastro.add(listarBt);
        
        telaFuncionario.add(panelCadastro);
        telaFuncionario.setVisible(true);
    };
}
