package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OperacoesInterface {

    public static void telaOperacoes(){
        JFrame telaEmprestimo = new JFrame("Tela Operacoes");
        telaEmprestimo.setSize(600, 600);
        
        JPanel panelEmprestimo = new JPanel();
        
        JButton realizarEmpBt = new JButton("Cadastrar Emprestimo");
        JButton consultarBt = new JButton("Consultar Livro");

        panelEmprestimo.add(realizarEmpBt);
        panelEmprestimo.add(consultarBt);
        
        telaEmprestimo.add(panelEmprestimo);
        telaEmprestimo.setVisible(true);
    };
    
    public static void telaCadastrarEmprestimo(){
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
    
    public static void telaConsultar(){
        JFrame telaFuncionario = new JFrame("Tela Consulta");
        telaFuncionario.setSize(600, 600);
        
        JPanel panelFuncionario = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        JButton listarBt = new JButton("Listar");

        panelFuncionario.add(cadastrarBt);
        panelFuncionario.add(listarBt);
        
        telaFuncionario.add(panelFuncionario);
        telaFuncionario.setVisible(true);
    };
}
