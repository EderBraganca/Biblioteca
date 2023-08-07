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
import javax.swing.SwingUtilities;

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
        
        // Botão de login
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener((ActionEvent e) -> {
            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();
            
            if (radioAdmin.isSelected()) {
                if(usuario.equals("admin") && senha.equals("admin")){
                    dialog.dispose();
                }
            }
            else if (radioFuncionario.isSelected()) {
                for(Funcionario func : dados.listaFuncionarios){
                    if(func.getMatricula() == Integer.valueOf(usuario)){
                        dialog.dispose();
                    }
                }
            } else if (radioUsuario.isSelected()) {
                for(Usuario usu : dados.listaUsuarios){
                    if(usu.getRegistroAcademico() == Integer.valueOf(usuario)){
                        dialog.dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o tipo de usuário.");
            }
             dialog.dispose();
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

        dialog.setVisible(true);
    }
    
    public String getTipoPessoa() {
        if (radioAdmin.isSelected()) {
            return "Admin";
        }else if (radioFuncionario.isSelected()) {
            return "Funcionario";
        } else if (radioUsuario.isSelected()) {
            return "Usuário";
        } else {
            return null;
        }
    }

    public JDialog getDialog() {
        return dialog;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface();
            }
        });
    }
}
