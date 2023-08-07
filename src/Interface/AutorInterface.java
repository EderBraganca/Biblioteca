package Interface;

import DAO.DAOAutor;
import Modelo.Autor;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AutorInterface {
    DAOAutor autorDAO = new DAOAutor();
    private JTable tableAutores;
    private DefaultTableModel tableModel;
    
    public static void telaCrudAutor(){
        AutorInterface autorInterface = new AutorInterface();
        
        ActionListener acaoCadastrarBt = (ActionEvent e) -> {
            autorInterface.telaCadastrarAutor();
        };
        ActionListener acaoListarBt = (ActionEvent e) -> {
            autorInterface.telaListarAutor();
        };
        
        JFrame telaAutor = new JFrame("Tela Autor");
        telaAutor.setSize(600, 600);
        
        JPanel panelAutor = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        cadastrarBt.addActionListener(acaoCadastrarBt);
        JButton listarBt = new JButton("Listar");
        listarBt.addActionListener(acaoListarBt);

        panelAutor.add(cadastrarBt);
        panelAutor.add(listarBt);
        
        telaAutor.add(panelAutor);
        telaAutor.setLocationRelativeTo(null);
        telaAutor.setVisible(true);
    };
    
    public void telaCadastrarAutor(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");

        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputBiografiaLabel = new JLabel("Biografia");
        JTextField inputBiografia = new JTextField(10);

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
                String biografia = inputBiografia.getText();
                String nome = inputNome.getText();
                String sobreNome = inputSobreNome.getText();
                Autor newAutor= new Autor(biografia, id, nome, sobreNome);
                autorDAO.cadastrar(newAutor);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores invalidos!");
            }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputBiografiaLabel);
        panelCadastro.add(inputBiografia);
        panelCadastro.add(inputNomeLabel);
        panelCadastro.add(inputNome);
        panelCadastro.add(inputSobreNomeLabel);
        panelCadastro.add(inputSobreNome);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    };
    
    public void telaListarAutor(){
        JFrame telaAutor = new JFrame("Tela Listagem");
        telaAutor.setSize(600, 600);
        telaAutor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelListagem = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Sobrenome"}, 0);
        tableAutores = new JTable(tableModel);
        tableAutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarListaAutores();

        JScrollPane scrollPane = new JScrollPane(tableAutores);
        panelListagem.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();

        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(e -> {
            telaAutor.dispose();
        });
        panelBotoes.add(voltarBt);

        JButton excluirBt = new JButton("Excluir");
        excluirBt.addActionListener((ActionEvent e) -> {
            int row = tableAutores.getSelectedRow();
            if (row >= 0) {
                Autor autorSelecionado = autorDAO.listar().get(row);
                int option = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o autor?", "Excluir autor",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    autorDAO.remover(autorSelecionado);
                    atualizarListaAutores();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um autor para excluir.");
            }
        });
        panelBotoes.add(excluirBt);

        JButton editarBt = new JButton("Editar");
        editarBt.addActionListener(e -> {
            int selectedRow = tableAutores.getSelectedRow();
            if (selectedRow >= 0) {
                Autor autorSelecionado = autorDAO.listar().get(selectedRow);
                exibirTelaEditarAutor(autorSelecionado);
                atualizarListaAutores();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um autor para editar.");
            }
        });
        panelBotoes.add(editarBt);

        panelListagem.add(panelBotoes, BorderLayout.SOUTH);

        telaAutor.add(panelListagem);
        telaAutor.setLocationRelativeTo(null);
        telaAutor.setVisible(true);
    }

    private void exibirTelaEditarAutor(Autor autor) {
        JTextField campoBiografia = new JTextField(autor.getBiografia());
        JTextField campoNome = new JTextField(autor.getNome());
        JTextField campoSobrenome = new JTextField(autor.getSobreNome());

        JPanel panelEditar = new JPanel();
        panelEditar.setLayout(new BoxLayout(panelEditar, BoxLayout.Y_AXIS));
        panelEditar.add(new JLabel("Biografia:"));
        panelEditar.add(campoBiografia);
        panelEditar.add(new JLabel("Nome:"));
        panelEditar.add(campoNome);
        panelEditar.add(new JLabel("Sobrenome:"));
        panelEditar.add(campoSobrenome);

        int option = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Autor",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            autor.setBiografia(campoBiografia.getText( ));
            autor.setNome(campoNome.getText());
            autor.setSobreNome(campoSobrenome.getText());
            autorDAO.atualizar(autor);
        }
    }

    private void atualizarListaAutores() {
        List<Autor> listaAutores = autorDAO.listar();
        tableModel.setRowCount(0);
        for (Autor autor : listaAutores) {
            Object[] rowData = {autor.getId(), autor.getNome(), autor.getSobreNome()};
            tableModel.addRow(rowData);
        }
    }
}
