package Interface;

import Modelo.Funcionario;
import Modelo.Usuario;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


//Classe para a tela de login
public class LoginInterface extends BibliotecaInterface{
    private JDialog dialog;
    private JTextField txtUsuario, txtSenha;
    private JRadioButton radioFuncionario, radioAdmin, radioUsuario;

    public void telaLogin() {
        dialog = new JDialog();
        dialog.setTitle("Tela de Login");
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(5, 1));
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);

        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField(20);
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(20);
        
        radioAdmin = new JRadioButton("Administrador");
        radioFuncionario = new JRadioButton("Funcionário");
        radioUsuario = new JRadioButton("Usuário");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioAdmin);
        buttonGroup.add(radioFuncionario);
        buttonGroup.add(radioUsuario);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener((ActionEvent e) -> {//Ação responsavel por tratar o login do sistema
            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();
            
            if (radioAdmin.isSelected()) {
                if(usuario.equals("admin") && senha.equals("admin")){
                    dialog.dispose();
                }
            }
            else if (radioFuncionario.isSelected()) {//Funcionario utiliza a matricula como senha e nome como usuario
                for(Funcionario func : dados.listaFuncionarios){
                    if(func.getNome().equals(usuario) && func.getMatricula() == Integer.valueOf(senha)){
                        dialog.dispose();
                    }
                }
            } else if (radioUsuario.isSelected()) {//Usuario utiliza o registro academico como senha e nome como usuario
                for(Usuario user : dados.listaUsuarios){
                    if(user.getNome().equals(usuario) && user.getRegistroAcademico() == Integer.valueOf(senha)){
                        dialog.dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o tipo de usuário.");
            }
        });
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.add(lblUsuario);
        panelUsuario.add(txtUsuario);

        JPanel panelSenha = new JPanel();
        panelSenha.add(lblSenha);
        panelSenha.add(txtSenha);

        JPanel panelRadio = new JPanel();
        panelRadio.add(radioFuncionario);
        panelRadio.add(radioUsuario);
        panelRadio.add(radioAdmin);

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnLogin);

        dialog.add(panelUsuario);
        dialog.add(panelSenha);
        dialog.add(panelRadio);
        dialog.add(panelBtn);
        
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    public String getTipoPessoa() {//Função utilizada para retornar o tipo de usuario que realizou o login
        if (radioAdmin.isSelected()) {
            return "Admin";
        }else if (radioFuncionario.isSelected()) {
            return "Funcionário";
        } else if (radioUsuario.isSelected()) {
            return "Usuário";
        } else {
            return null;
        }
    }

    public JDialog getDialog() {
        return dialog;
    }
}