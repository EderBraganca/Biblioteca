package Interface;

import DAO.DAOUsuario;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UsuarioInterface {
    DAOUsuario usuarioDAO = new DAOUsuario();
    private JTable tableUsuarios;
    private DefaultTableModel tableModel;
    
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
    
    public void telaCadastrarUsuario(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");

        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputRegistroLabel = new JLabel("Registro Academico");
        JTextField inputRegistro = new JTextField(10);

        JLabel inputNomeLabel = new JLabel("Nome");
        JTextField inputNome = new JTextField(20);

        JLabel inputSobreNomeLabel = new JLabel("Sobrenome");
        JTextField inputSobreNome = new JTextField(40);

        JButton cancelarBt = new JButton("Voltar");
        cancelarBt.addActionListener(e -> {
            telaCadastro.dispose();
        });
        JButton salvarBt = new JButton("Salvar");

        salvarBt.addActionListener(e -> {
            try {
                int id = Integer.parseInt(inputId.getText());
                int registro = Integer.parseInt(inputRegistro.getText());
                String nome = inputNome.getText();
                String sobreNome = inputSobreNome.getText();
                Usuario newUsuario= new Usuario(registro, id, nome, sobreNome);
                usuarioDAO.cadastrar(newUsuario);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores invalidos!");
            }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputRegistroLabel);
        panelCadastro.add(inputRegistro);
        panelCadastro.add(inputNomeLabel);
        panelCadastro.add(inputNome);
        panelCadastro.add(inputSobreNomeLabel);
        panelCadastro.add(inputSobreNome);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setVisible(true);
    };
    
    public void telaListarUsuario(){
        JFrame telaUsuario = new JFrame("Tela Listagem");
        telaUsuario.setSize(600, 600);
        telaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelListagem = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Registro", "Nome", "Sobrenome"}, 0);
        tableUsuarios = new JTable(tableModel);
        tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarListaUsuarios();

        JScrollPane scrollPane = new JScrollPane(tableUsuarios);
        panelListagem.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();

        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(e -> {
            telaUsuario.dispose();
        });
        panelBotoes.add(voltarBt);

        JButton excluirBt = new JButton("Excluir");
        excluirBt.addActionListener((ActionEvent e) -> {
            int row = tableUsuarios.getSelectedRow();
            if (row >= 0) {
                Usuario usuarioSelecionado = usuarioDAO.listar().get(row);
                int option = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o usuario?", "Excluir usuario",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    usuarioDAO.remover(usuarioSelecionado);
                    atualizarListaUsuarios();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um usuario para excluir.");
            }
        });
        panelBotoes.add(excluirBt);

        JButton editarBt = new JButton("Editar");
        editarBt.addActionListener(e -> {
            int selectedRow = tableUsuarios.getSelectedRow();
            if (selectedRow >= 0) {
                Usuario usuarioSelecionado = usuarioDAO.listar().get(selectedRow);
                exibirTelaEditarUsuario(usuarioSelecionado);
                atualizarListaUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um usuario para editar.");
            }
        });
        panelBotoes.add(editarBt);

        panelListagem.add(panelBotoes, BorderLayout.SOUTH);

        telaUsuario.add(panelListagem);
        telaUsuario.setVisible(true);
    }

    private void exibirTelaEditarUsuario(Usuario usuario) {
        JTextField campoRegistro = new JTextField(Integer.toString(usuario.getRegistroAcademico()));
        JTextField campoNome = new JTextField(usuario.getNome());
        JTextField campoSobrenome = new JTextField(usuario.getSobreNome());

        JPanel panelEditar = new JPanel();
        panelEditar.setLayout(new BoxLayout(panelEditar, BoxLayout.Y_AXIS));
        panelEditar.add(new JLabel("Registro:"));
        panelEditar.add(campoRegistro);
        panelEditar.add(new JLabel("Nome:"));
        panelEditar.add(campoNome);
        panelEditar.add(new JLabel("Sobrenome:"));
        panelEditar.add(campoSobrenome);

        int option = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Usuário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            usuario.setRegistroAcademico(Integer.valueOf(campoRegistro.getText()));
            usuario.setNome(campoNome.getText());
            usuario.setSobreNome(campoSobrenome.getText());
            usuarioDAO.atualizar(usuario);
        }
    }

    private void atualizarListaUsuarios() {
        List<Usuario> listaUsuarios = usuarioDAO.listar();
        tableModel.setRowCount(0);
        for (Usuario user : listaUsuarios) {
            Object[] rowData = {user.getId(), user.getRegistroAcademico(), user.getNome(), user.getSobreNome()};
            tableModel.addRow(rowData);
        }
    }
    
}
