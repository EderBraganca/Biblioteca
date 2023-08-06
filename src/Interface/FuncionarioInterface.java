package Interface;

import DAO.DAOFuncionario;
import Modelo.Funcionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FuncionarioInterface extends BibliotecaInterface {

    DAOFuncionario funcionario = new DAOFuncionario();

    public static void telaCrudFuncionario() {
        ActionListener acaoCadastrarBt = (ActionEvent e) -> {
            telaCadastrarFuncionario();
        };
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
    
    public void telaCadastrarFuncionario() {
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel();

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputMatriculaLabel = new JLabel("Matricula");
        JTextField inputMatricula = new JTextField(10);

        JLabel inputNomeLabel = new JLabel("Nome");
        JTextField inputNome = new JTextField(20);

        JLabel inputSobreNomeLabel = new JLabel("Sobre Nome");
        JTextField inputSobreNome = new JTextField(40);

        JButton calcelarBt = new JButton("Cancelar");
        JButton salvarBt = new JButton("Salvar");
        
        salvarBt.addActionListener(e -> {       
            try {
            int id = Integer.parseInt(inputId.getText());
            int matricula = Integer.parseInt(inputMatricula.getText());
            String nome = inputNome.getText();
            String sobreNome = inputSobreNome.getText();
            Funcionario newfuncionario = new Funcionario(matricula, id, nome, sobreNome);
            funcionario.cadastrar(newfuncionario);
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valores invalidos!");
        }});

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputMatriculaLabel);
        panelCadastro.add(inputMatricula);
        panelCadastro.add(inputNomeLabel);
        panelCadastro.add(inputNome);
        panelCadastro.add(inputSobreNomeLabel);
        panelCadastro.add(inputSobreNome);
        
        panelCadastro.add(calcelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setVisible(true);
    };
    
    public static void telaListarFuncionario() {
        JFrame telaFuncionario = new JFrame("Tela Listagem");
        telaFuncionario.setSize(600, 600);

        JPanel panelListagem = new JPanel();

        JButton voltarBt = new JButton("Voltar");

        panelListagem.add(voltarBt);

        telaFuncionario.add(panelListagem);
        telaFuncionario.setVisible(true);
    };
}
