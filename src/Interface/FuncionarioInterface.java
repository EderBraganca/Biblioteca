package Interface;

import DAO.DAOFuncionario;
import Modelo.Funcionario;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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

public class FuncionarioInterface extends BibliotecaInterface {

    private final DAOFuncionario funcionarioDAO = new DAOFuncionario();
    private JTable tableFuncionarios;
    private DefaultTableModel tableModel;

    public static void telaCrudFuncionario() {
        FuncionarioInterface funcionarioInterface = new FuncionarioInterface();

        ActionListener acaoCadastrarBt = (ActionEvent e) -> {
            funcionarioInterface.telaCadastrarFuncionario();
        };
        ActionListener acaoListarBt = (ActionEvent e) -> {
            funcionarioInterface.telaListarFuncionario();
        };

        JFrame telaFuncionario = new JFrame("Tela Funcionario");
        telaFuncionario.setSize(600, 600);

        JPanel panelFuncionario = new JPanel();

        JButton cadastrarBt = new JButton("Cadastrar");
        cadastrarBt.addActionListener(acaoCadastrarBt);
        JButton listarBt = new JButton("Listar");
        listarBt.addActionListener(acaoListarBt);

        panelFuncionario.add(cadastrarBt);
        panelFuncionario.add(listarBt);

        telaFuncionario.add(panelFuncionario);
        telaFuncionario.setLocationRelativeTo(null);
        telaFuncionario.setVisible(true);
    }
    
    public void telaCadastrarFuncionario() {
        JFrame telaCadastro = new JFrame("Tela Cadastro");

        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputMatriculaLabel = new JLabel("Matricula");
        JTextField inputMatricula = new JTextField(10);

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
                int matricula = Integer.parseInt(inputMatricula.getText());
                String nome = inputNome.getText();
                String sobreNome = inputSobreNome.getText();
                Funcionario newfuncionario = new Funcionario(matricula, id, nome, sobreNome);
                funcionarioDAO.cadastrar(newfuncionario);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores invalidos!");
            }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputMatriculaLabel);
        panelCadastro.add(inputMatricula);
        panelCadastro.add(inputNomeLabel);
        panelCadastro.add(inputNome);
        panelCadastro.add(inputSobreNomeLabel);
        panelCadastro.add(inputSobreNome);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    }
    
    public void telaListarFuncionario() {
        JFrame telaFuncionario = new JFrame("Tela Listagem");
        telaFuncionario.setSize(600, 600);
        telaFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelListagem = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Matricula", "Nome", "Sobrenome"}, 0);
        tableFuncionarios = new JTable(tableModel);
        tableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarListaFuncionarios();

        JScrollPane scrollPane = new JScrollPane(tableFuncionarios);
        panelListagem.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();

        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(e -> {
            telaFuncionario.dispose();
        });
        panelBotoes.add(voltarBt);

        JButton excluirBt = new JButton("Excluir");
        excluirBt.addActionListener((ActionEvent e) -> {
            int row = tableFuncionarios.getSelectedRow();
            if (row >= 0) {
                Funcionario funcionarioSelecionado = funcionarioDAO.listar().get(row);
                int option = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o funcionário?", "Excluir Funcionário",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    funcionarioDAO.remover(funcionarioSelecionado);
                    atualizarListaFuncionarios();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um funcionário para excluir.");
            }
        });
        panelBotoes.add(excluirBt);

        JButton editarBt = new JButton("Editar");
        editarBt.addActionListener(e -> {
            int selectedRow = tableFuncionarios.getSelectedRow();
            if (selectedRow >= 0) {
                Funcionario funcionarioSelecionado = funcionarioDAO.listar().get(selectedRow);
                exibirTelaEditarFuncionario(funcionarioSelecionado);
                atualizarListaFuncionarios();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um funcionário para editar.");
            }
        });
        panelBotoes.add(editarBt);

        panelListagem.add(panelBotoes, BorderLayout.SOUTH);

        telaFuncionario.add(panelListagem);
        telaFuncionario.setLocationRelativeTo(null);
        telaFuncionario.setVisible(true);
    }

    private void exibirTelaEditarFuncionario(Funcionario funcionario) {
        JTextField campoMatricula = new JTextField(Integer.toString(funcionario.getMatricula()));
        JTextField campoNome = new JTextField(funcionario.getNome());
        JTextField campoSobrenome = new JTextField(funcionario.getSobreNome());

        JPanel panelEditar = new JPanel();
        panelEditar.setLayout(new BoxLayout(panelEditar, BoxLayout.Y_AXIS));
        panelEditar.add(new JLabel("Matrícula:"));
        panelEditar.add(campoMatricula);
        panelEditar.add(new JLabel("Nome:"));
        panelEditar.add(campoNome);
        panelEditar.add(new JLabel("Sobrenome:"));
        panelEditar.add(campoSobrenome);

        int option = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            funcionario.setMatricula(Integer.valueOf(campoMatricula.getText()));
            funcionario.setNome(campoNome.getText());
            funcionario.setSobreNome(campoSobrenome.getText());
            funcionarioDAO.atualizar(funcionario);
        }
    }

    private void atualizarListaFuncionarios() {
        List<Funcionario> listaFuncionarios = funcionarioDAO.listar();
        tableModel.setRowCount(0);
        for (Funcionario func : listaFuncionarios) {
            Object[] rowData = {func.getId(), func.getMatricula(), func.getNome(), func.getSobreNome()};
            tableModel.addRow(rowData);
        }
    }
}
