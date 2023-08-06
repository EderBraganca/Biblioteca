package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsuarioInterface {
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
    
    public static void telaCadastrarUsuario(){
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
    
    public static void telaListarUsuario(){
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
