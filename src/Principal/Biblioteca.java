package Principal;

import Interface.LoginInterface;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Biblioteca {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginInterface telaLogin = new LoginInterface();

                telaLogin.getDialog().setVisible(true);

                String tipoPessoa = telaLogin.getTipoPessoa();

                if (tipoPessoa.equals("Admin")) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                    telaLogin.InterfaceInicialAdmin(args);
                } 
                else if (tipoPessoa.equals("Funcionario")) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                    telaLogin.InterfaceInicialAdmin(args);
                } 
                else if (tipoPessoa.equals("Usuario")) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                    telaLogin.InterfaceInicialUsuario(args);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum tipo de pessoa selecionado.");
                    System.exit(0);
                }
            }
        });
    }
}