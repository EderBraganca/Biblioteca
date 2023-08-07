package Interface;

import DAO.DAOEmprestimo;
import DAO.DAOLivro;
import Dados.Dados;
import Modelo.Emprestimo;
import Modelo.Funcionario;
import Modelo.Livro;
import Modelo.Usuario;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

public class OperacoesInterface extends BibliotecaInterface{
    Dados dados = Dados.getDados();
    DAOLivro livroDAO = new DAOLivro();
    DAOEmprestimo emprestimoDAO = new DAOEmprestimo();
    
    public static void telaOperacoes(String tipo){
        OperacoesInterface operacoesInterface = new OperacoesInterface();
        
        ActionListener acaoRealizarEmpBt = (ActionEvent e) -> {
            operacoesInterface.telaCadastrarEmprestimo();
        };
        ActionListener acaoConsultarBt = (ActionEvent e) -> {
            operacoesInterface.telaConsultar();
        };
        
        if(tipo.equals("admin")){
            JFrame telaEmprestimo = new JFrame("Tela Operacoes");
            telaEmprestimo.setSize(600, 600);

            JPanel panelEmprestimo = new JPanel();

            JButton realizarEmpBt = new JButton("Cadastrar Emprestimo");
            realizarEmpBt.addActionListener(acaoRealizarEmpBt);
            JButton consultarBt = new JButton("Consultar Livro");
            consultarBt.addActionListener(acaoConsultarBt);
            
            panelEmprestimo.add(realizarEmpBt);
            panelEmprestimo.add(consultarBt);

            telaEmprestimo.add(panelEmprestimo);
            telaEmprestimo.setLocationRelativeTo(null);
            telaEmprestimo.setVisible(true);
        }
        else{
            JFrame telaEmprestimo = new JFrame("Tela Operacoes");
            telaEmprestimo.setSize(600, 600);

            JPanel panelEmprestimo = new JPanel();

            JButton consultarBt = new JButton("Consultar Livro");
            consultarBt.addActionListener(acaoConsultarBt);

            panelEmprestimo.add(consultarBt);

            telaEmprestimo.add(panelEmprestimo);
            telaEmprestimo.setLocationRelativeTo(null);
            telaEmprestimo.setVisible(true);
        }
    };
    
    public void telaCadastrarEmprestimo(){
        JFrame telaCadastro = new JFrame("Tela Cadastro");
        telaCadastro.setSize(600, 600);

        JPanel panelCadastro = new JPanel(new GridLayout(6, 2));

        JLabel inputIdLabel = new JLabel("Id");
        JTextField inputId = new JTextField(10);

        JLabel inputDataLabel = new JLabel("Data");
        MaskFormatter mascaraData = null;
        
        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
        }
        
        JFormattedTextField inputData = new JFormattedTextField(mascaraData);

        JLabel inputLivroLabel = new JLabel("Livro");
        List<Livro> listaLivros = dados.listaLivros;

        List<String> nomesLivros = new ArrayList<>();
        for (Livro livro : listaLivros) {
            nomesLivros.add(livro.getTitulo());
        }

        JList<String> livrosList = new JList<>(nomesLivros.toArray(new String[0]));
        livrosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel inputUsuarioLabel = new JLabel("Usuario");
        List<Usuario> listaUsuarios = dados.listaUsuarios;

        List<String> nomesUsuarios = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            nomesUsuarios.add(usuario.getNome());
        }

        JList<String> usuariosList = new JList<>(nomesUsuarios.toArray(new String[0]));
        usuariosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel inputFuncionarioLabel = new JLabel("Funcionario");
        List<Funcionario> listaFuncionarios = dados.listaFuncionarios;

        List<String> nomesFuncionarios = new ArrayList<>();
        for (Funcionario funcionario : listaFuncionarios) {
            nomesFuncionarios.add(funcionario.getNome());
        }

        JList<String> funcionariosList = new JList<>(nomesFuncionarios.toArray(new String[0]));
        funcionariosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton cancelarBt = new JButton("Voltar");
        cancelarBt.addActionListener(e -> {
            telaCadastro.dispose();
        });
        JButton salvarBt = new JButton("Salvar");

        salvarBt.addActionListener(e -> {
            try {
                int id = Integer.parseInt(inputId.getText());
                Date dataEmprestimo;

                try {
                    dataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(inputData.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida!");
                    return;
                }
                
                Map<String, Integer> mapaLivros = new HashMap<>();
                for (Livro livro : listaLivros) {
                    mapaLivros.put(livro.getTitulo(), livro.getId());
                }

                Map<String, Integer> mapaUsuarios = new HashMap<>();
                for (Usuario usuario : listaUsuarios) {
                    mapaUsuarios.put(usuario.getNome(), usuario.getId());
                }
                
                Map<String, Integer> mapaFuncionarios = new HashMap<>();
                for (Funcionario funcionario : listaFuncionarios) {
                    mapaFuncionarios.put(funcionario.getNome(), funcionario.getId());
                }
                
                String nomeLivroSelecionado = livrosList.getSelectedValue();
                int idLivroSelecionado = mapaLivros.get(nomeLivroSelecionado);
                
                String nomeUsuarioSelecionado = usuariosList.getSelectedValue();
                int idUsuarioSelecionado = mapaUsuarios.get(nomeUsuarioSelecionado);
                
                String nomeFuncionarioSelecionado = funcionariosList.getSelectedValue();
                int idFuncionarioSelecionado = mapaFuncionarios.get(nomeFuncionarioSelecionado);

                Emprestimo newEmprestimo = new Emprestimo(id, dataEmprestimo, idLivroSelecionado, idUsuarioSelecionado, idFuncionarioSelecionado);
                emprestimoDAO.cadastrar(newEmprestimo);

                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valores inválidos!");
        }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputDataLabel);
        panelCadastro.add(inputData);
        panelCadastro.add(inputLivroLabel);
        panelCadastro.add(livrosList);
        panelCadastro.add(inputUsuarioLabel);
        panelCadastro.add(usuariosList);
        panelCadastro.add(inputFuncionarioLabel);
        panelCadastro.add(funcionariosList);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    };
    
    public void telaConsultar(){
        JFrame telaFuncionario = new JFrame("Tela Consulta");
        telaFuncionario.setSize(600, 600);

        JPanel panelFuncionario = new JPanel();

        JButton buscarBt = new JButton("Buscar");

        JTextField campoBusca = new JTextField(20);

        JTextArea areaResultado = new JTextArea(10, 40);
        areaResultado.setEditable(false); 

        buscarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tituloBuscado = campoBusca.getText();
                List<Livro> resultadosBusca = livroDAO.buscarLivroPeloTitulo(tituloBuscado);
                
                areaResultado.setText(""); 
                for (Livro livro : resultadosBusca) {
                    areaResultado.append("Título: " + livro.getTitulo() + "\n");
                    areaResultado.append("\n");
                }
            }
        });

        panelFuncionario.add(campoBusca);
        panelFuncionario.add(buscarBt);

        JScrollPane scrollPane = new JScrollPane(areaResultado);
        panelFuncionario.add(scrollPane);

        telaFuncionario.add(panelFuncionario);
        telaFuncionario.setLocationRelativeTo(null);
        telaFuncionario.setVisible(true);
    };
}
