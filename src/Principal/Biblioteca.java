package Principal;

import Interface.LoginInterface;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Biblioteca {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginInterface telaLogin = new LoginInterface();
                telaLogin.telaLogin();
                String tipoPessoa = telaLogin.getTipoPessoa();

                switch (tipoPessoa) {
                    case "Admin":
                        JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                        LoginInterface.InterfaceInicialAdmin(args);
                        break;
                    case "Funcionário":
                        JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                        LoginInterface.InterfaceInicialAdmin(args);
                        break;
                    case "Usuário":
                        JOptionPane.showMessageDialog(null, "Bem-vindo, " + tipoPessoa + "!");
                        LoginInterface.InterfaceInicialUsuario(args);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Nenhum tipo de pessoa selecionado.");
                        System.exit(0);
                }
            }
        });
    }
}