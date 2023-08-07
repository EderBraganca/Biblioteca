package Interface;

import DAO.DAOCategoria;
import Modelo.Categoria;
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


public class CategoriaInterface extends BibliotecaInterface{
    
    DAOCategoria categoriaDAO = new DAOCategoria(dados);
    private JTable tableCategorias;
    private DefaultTableModel tableModel;
    
    public static void telaCrudCategoria(){
        CategoriaInterface categoriaInterface = new CategoriaInterface();
        
        ActionListener acaoCadastrarBt = (ActionEvent e) -> {
            categoriaInterface.telaCadastrarCategoria();
        };
        ActionListener acaoListarBt = (ActionEvent e) -> {
            categoriaInterface.telaListarCategoria();
        };
        
        JFrame telaCategoria = new JFrame("Tela Categoria");
        telaCategoria.setSize(600, 600);
        
        JPanel panelCategoria = new JPanel();
        
        JButton cadastrarBt = new JButton("Cadastrar");
        cadastrarBt.addActionListener(acaoCadastrarBt);
        JButton listarBt = new JButton("Listar");
        listarBt.addActionListener(acaoListarBt);

        panelCategoria.add(cadastrarBt);
        panelCategoria.add(listarBt);
        
        telaCategoria.add(panelCategoria);
        telaCategoria.setLocationRelativeTo(null);
        telaCategoria.setVisible(true);
    };
    
    public void telaCadastrarCategoria(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        
        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputTituloLabel = new JLabel("Titulo");
        JTextField inputTitulo = new JTextField(10);

        JButton cancelarBt = new JButton("Voltar");
        cancelarBt.addActionListener(e -> {
            telaCadastro.dispose();
        });
        JButton salvarBt = new JButton("Salvar");

        salvarBt.addActionListener(e -> {
            try {
                int id = Integer.parseInt(inputId.getText());
                String titulo = inputTitulo.getText();
                Categoria newCategoria = new Categoria(id, titulo);
                categoriaDAO.cadastrar(newCategoria);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores invalidos!");
            }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputTituloLabel);
        panelCadastro.add(inputTitulo);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    };
    
    public void telaListarCategoria(){
        JFrame telaCategoria = new JFrame("Tela Listagem");
        telaCategoria.setSize(600, 600);
        telaCategoria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelListagem = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Titulo"}, 0);
        tableCategorias = new JTable(tableModel);
        tableCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarListaCategorias();

        JScrollPane scrollPane = new JScrollPane(tableCategorias);
        panelListagem.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();

        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(e -> {
            telaCategoria.dispose();
        });
        panelBotoes.add(voltarBt);

        JButton excluirBt = new JButton("Excluir");
        excluirBt.addActionListener((ActionEvent e) -> {
            int row = tableCategorias.getSelectedRow();
            if (row >= 0) {
                Categoria categoriaSelecionado = categoriaDAO.listar().get(row);
                int option = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o categoria?", "Excluir Categoria",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    categoriaDAO.remover(categoriaSelecionado);
                    atualizarListaCategorias();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um categoria para excluir.");
            }
        });
        panelBotoes.add(excluirBt);

        JButton editarBt = new JButton("Editar");
        editarBt.addActionListener(e -> {
            int selectedRow = tableCategorias.getSelectedRow();
            if (selectedRow >= 0) {
                Categoria categoriaSelecionado = categoriaDAO.listar().get(selectedRow);
                exibirTelaEditarCategoria(categoriaSelecionado);
                atualizarListaCategorias();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um categoria para editar.");
            }
        });
        panelBotoes.add(editarBt);

        panelListagem.add(panelBotoes, BorderLayout.SOUTH);

        telaCategoria.add(panelListagem);
        telaCategoria.setLocationRelativeTo(null);
        telaCategoria.setVisible(true);
    }

    private void exibirTelaEditarCategoria(Categoria categoria) {
        JTextField campoTitulo = new JTextField(categoria.getTitulo());

        JPanel panelEditar = new JPanel();
        panelEditar.setLayout(new BoxLayout(panelEditar, BoxLayout.Y_AXIS));
        panelEditar.add(new JLabel("Titulo:"));
        panelEditar.add(campoTitulo);

        int option = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Categoria",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            categoria.setTitulo(campoTitulo.getText());
            categoriaDAO.atualizar(categoria);
        }
    }

    private void atualizarListaCategorias() {
        List<Categoria> listaCategorias = categoriaDAO.listar();
        tableModel.setRowCount(0);
        for (Categoria user : listaCategorias) {
            Object[] rowData = {user.getId(), user.getTitulo()};
            tableModel.addRow(rowData);
        }
    }
}
