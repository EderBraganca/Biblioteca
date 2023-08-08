package Interface;

import DAO.DAOLivro;
import Modelo.Autor;
import Modelo.Categoria;
import Modelo.Livro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//Classe para a tela de livros
public class LivroInterface extends BibliotecaInterface {
    
    DAOLivro livroDAO = new DAOLivro();
    private JTable tableLivros;
    private DefaultTableModel tableModel;
    
    public static void telaCrudLivro() {
        LivroInterface livroInterface = new LivroInterface();
        JFrame telaLivro = new JFrame("Tela Livro");
        
        //Acoes dos botoes da interface inicial da tela
        ActionListener acaoCadastrarBt = (ActionEvent e) -> {
            livroInterface.telaCadastrarLivro();
        };
        ActionListener acaoListarBt = (ActionEvent e) -> {
            livroInterface.telaListarLivro();
        };        
        ActionListener acaoVoltarBt = (ActionEvent e) -> {
            telaLivro.dispose();
        };
        
        telaLivro.setSize(600, 600);
        
        JPanel panelLivro = new JPanel(new GridLayout(4, 1));
        
        JButton cadastrarBt = new JButton("Cadastrar");
        cadastrarBt.addActionListener(acaoCadastrarBt);
        JButton listarBt = new JButton("Listar");
        listarBt.addActionListener(acaoListarBt);
        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(acaoVoltarBt);
        
        panelLivro.add(cadastrarBt);
        panelLivro.add(listarBt);
        panelLivro.add(voltarBt);
        
        telaLivro.add(panelLivro);
        telaLivro.setLocationRelativeTo(null);
        telaLivro.setVisible(true);
    }
    
    public void telaCadastrarLivro() {
        //Tela de formulario onde estao os componentes de cadastro
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        telaCadastro.setSize(600, 600);
        JPanel panelCadastro = new JPanel(new GridLayout(5, 2));
        
        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);
        
        JLabel inputTituloLabel = new JLabel("Titulo");
        JTextField inputTitulo = new JTextField(10);
        
        JLabel inputCategoriaLabel = new JLabel("Categorias");
        List<Categoria> listaCategorias = dados.listaCategorias;        
        
        List<String> nomesCategorias = new ArrayList<>();
        for (Categoria categoria : listaCategorias) {
            nomesCategorias.add(categoria.getTitulo());
        }
        
        JList<String> categoriaList = new JList<>(nomesCategorias.toArray(new String[0]));
        categoriaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        categoriaList.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel inputAutorLabel = new JLabel("Autores");
        List<Autor> listaAutores = dados.listaAutores;        
        
        List<String> nomesAutores = new ArrayList<>();
        for (Autor autor : listaAutores) {
            nomesAutores.add(autor.getNome());
        }
        
        JList<String> autoresList = new JList<>(nomesAutores.toArray(new String[0]));
        autoresList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        autoresList.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton cancelarBt = new JButton("Voltar");
        cancelarBt.addActionListener(e -> {
            telaCadastro.dispose();
        });
        JButton salvarBt = new JButton("Salvar");
        
        //Função salvar do formulario com tratamento try/catch
        salvarBt.addActionListener(e -> {
            try {
                int id = Integer.parseInt(inputId.getText());
                String titulo = inputTitulo.getText();
                List<String> nomesCategoriasSelecionadas = categoriaList.getSelectedValuesList();
                
                Map<String, Integer> mapaCategorias = new HashMap<>();
                for (Categoria categoria : listaCategorias) {
                    mapaCategorias.put(categoria.getTitulo(), categoria.getId());
                }
                List<Integer> idsCategoriasSelecionadas = new ArrayList<>();
                
                for (String nomeCategoria : nomesCategoriasSelecionadas) {
                    int idCategoriaSelecionada = mapaCategorias.get(nomeCategoria);
                    idsCategoriasSelecionadas.add(idCategoriaSelecionada);
                }
                
                List<String> nomesAutoresSelecionadas = autoresList.getSelectedValuesList();
                
                Map<String, Integer> mapaAutores = new HashMap<>();
                for (Autor autor : listaAutores) {
                    mapaAutores.put(autor.getNome(), autor.getId());
                }
                
                List<Integer> idsAutoresSelecionadas = new ArrayList<>();
                
                for (String nomeAutor : nomesAutoresSelecionadas) {
                    int idAutoresSelecionada = mapaAutores.get(nomeAutor);
                    idsAutoresSelecionadas.add(idAutoresSelecionada);
                }
                
                Livro newLivro = new Livro(id, titulo, idsCategoriasSelecionadas, idsAutoresSelecionadas);
                livroDAO.cadastrar(newLivro);
                
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores invalidos!");
            }
        });
        
        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputTituloLabel);
        panelCadastro.add(inputTitulo);
        panelCadastro.add(inputCategoriaLabel);
        panelCadastro.add(categoriaList);
        panelCadastro.add(inputAutorLabel);
        panelCadastro.add(autoresList);
        
        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);
        
        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    }
    
    public void telaListarLivro() {
        JFrame telaLivro = new JFrame("Tela Listagem");
        telaLivro.setSize(600, 600);
        telaLivro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panelListagem = new JPanel(new BorderLayout());
        
        tableModel = new DefaultTableModel(new Object[]{"ID", "Titulo", "Autores", "Categorias"}, 0);
        tableLivros = new JTable(tableModel);
        tableLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarListaLivros();
        
        JScrollPane scrollPane = new JScrollPane(tableLivros);
        panelListagem.add(scrollPane, BorderLayout.CENTER);
        
        JPanel panelBotoes = new JPanel();
        
        JButton voltarBt = new JButton("Voltar");
        voltarBt.addActionListener(e -> {
            telaLivro.dispose();
        });
        panelBotoes.add(voltarBt);
        
        JButton excluirBt = new JButton("Excluir");
        excluirBt.addActionListener((ActionEvent e) -> {
            int row = tableLivros.getSelectedRow();
            if (row >= 0) {
                Livro livroSelecionado = livroDAO.listar().get(row);
                int option = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o livro?", "Excluir Livro",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    livroDAO.remover(livroSelecionado);
                    atualizarListaLivros();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um livro para excluir.");
            }
        });
        panelBotoes.add(excluirBt);
        
        JButton editarBt = new JButton("Editar");
        editarBt.addActionListener(e -> {
            int selectedRow = tableLivros.getSelectedRow();
            if (selectedRow >= 0) {
                Livro livroSelecionado = livroDAO.listar().get(selectedRow);
                exibirTelaEditarLivro(livroSelecionado);
                atualizarListaLivros();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um livro para editar.");
            }
        });
        panelBotoes.add(editarBt);
        
        panelListagem.add(panelBotoes, BorderLayout.SOUTH);
        
        telaLivro.add(panelListagem);
        telaLivro.setLocationRelativeTo(null);
        telaLivro.setVisible(true);
    }
    
    private void exibirTelaEditarLivro(Livro livro) {
        JTextField campoTitulo = new JTextField(livro.getTitulo());
        JPanel panelEditar = new JPanel();
        panelEditar.setLayout(new BoxLayout(panelEditar, BoxLayout.Y_AXIS));
        panelEditar.add(new JLabel("Titulo:"));
        panelEditar.add(campoTitulo);
        
        int option = JOptionPane.showConfirmDialog(null, panelEditar, "Editar Livro",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (option == JOptionPane.OK_OPTION) {
            livro.setTitulo(campoTitulo.getText());
            livroDAO.atualizar(livro);
        }
    }
    
    private void atualizarListaLivros() {
        List<Livro> listaLivros = livroDAO.listar();
        tableModel.setRowCount(0);
        for (Livro livro : listaLivros) {
            Object[] rowData = {livro.getId(), livro.getTitulo(), livro.getAutores(), livro.getCategorias()};
            tableModel.addRow(rowData);
        }
    }
}
