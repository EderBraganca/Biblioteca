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
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

//Classe para a tela de operações
public class OperacoesInterface extends BibliotecaInterface{
    Dados dados = Dados.getDados();
    DAOLivro livroDAO = new DAOLivro();
    DAOEmprestimo emprestimoDAO = new DAOEmprestimo();
    
    public static void telaOperacoes(String tipo){
        OperacoesInterface operacoesInterface = new OperacoesInterface();
        JFrame telaEmprestimo = new JFrame("Tela Operacoes");
        telaEmprestimo.setSize(600, 600);
        
        //Acoes dos botoes da interface inicial da tela
        ActionListener acaoRealizarEmpBt = (ActionEvent e) -> {
            operacoesInterface.telaCadastrarEmprestimo();
        };
        ActionListener acaoConsultarBt = (ActionEvent e) -> {
            operacoesInterface.telaConsultar();
        };
        ActionListener acaoVoltarBt = (ActionEvent e) -> {
            telaEmprestimo.dispose();
        };
        
        //Tratamento da tela para administrador/funcionario
        if(tipo.equals("admin")){
            JPanel panelEmprestimo = new JPanel(new GridLayout(4, 1));

            JButton realizarEmpBt = new JButton("Cadastrar Emprestimo");
            realizarEmpBt.addActionListener(acaoRealizarEmpBt);
            JButton consultarBt = new JButton("Consultar Livro");
            consultarBt.addActionListener(acaoConsultarBt);
            JButton voltarBt = new JButton("Voltar");
            voltarBt.addActionListener(acaoVoltarBt);
            
            panelEmprestimo.add(realizarEmpBt);
            panelEmprestimo.add(consultarBt);
            panelEmprestimo.add(voltarBt);

            telaEmprestimo.add(panelEmprestimo);
            telaEmprestimo.setLocationRelativeTo(null);
            telaEmprestimo.setVisible(true);
        }
        else{//Tratamento da tela para usuarios 
            JPanel panelEmprestimo = new JPanel(new GridLayout(4, 1));

            JButton consultarBt = new JButton("Consultar Livro");
            consultarBt.addActionListener(acaoConsultarBt);
            JButton voltarBt = new JButton("Voltar");
            voltarBt.addActionListener(acaoVoltarBt);

            panelEmprestimo.add(consultarBt);
            panelEmprestimo.add(voltarBt);

            telaEmprestimo.add(panelEmprestimo);
            telaEmprestimo.setLocationRelativeTo(null);
            telaEmprestimo.setVisible(true);
        }
    };
    
    public void telaCadastrarEmprestimo(){
        //Tela de formulario onde estao os componentes de cadastro
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
        JTextField inputLivro = new JTextField(20);

        JLabel inputUsuarioLabel = new JLabel("Registro Usuario");
        JTextField inputUsuario = new JTextField(20);

        JLabel inputFuncionarioLabel = new JLabel("Matricula Funcionario ");
        JTextField inputFuncionario = new JTextField(20);

        JButton cancelarBt = new JButton("Voltar");
        cancelarBt.addActionListener(e -> {
            telaCadastro.dispose();
        });
        JButton salvarBt = new JButton("Salvar");

        //Função salvar do formulario com tratamento try/catch
        salvarBt.addActionListener(e -> {
            try {
                int userExiste = 0, livroExiste = 0, funcExiste = 0;
                int id = Integer.parseInt(inputId.getText());
                String livro = inputLivro.getText();
                int idLivro = 0;
                int registro = Integer.parseInt(inputUsuario.getText());
                int matricula = Integer.parseInt(inputFuncionario.getText());
                Date dataEmprestimo;

                try {
                    dataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(inputData.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida!");
                    return;
                }
                for(Usuario x : dados.listaUsuarios){
                    if(x.getRegistroAcademico() == registro)
                        userExiste = 1;
                }
                for(Funcionario x : dados.listaFuncionarios){
                    if(x.getMatricula() == matricula)
                        funcExiste = 1;
                }
                for(Livro x : dados.listaLivros){
                    if(x.getTitulo().equals(livro)){
                        livroExiste = 1;
                        idLivro = x.getId();
                    }
                }
                if(userExiste == 1 && livroExiste == 1 && funcExiste == 1){
                    Emprestimo newEmprestimo = new Emprestimo(id, dataEmprestimo, idLivro, registro, matricula);
                    emprestimoDAO.cadastrar(newEmprestimo);
                    JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                }
                else if(livroExiste == 0){
                    JOptionPane.showMessageDialog(null, "Livro invalido!");
                }
                else if(userExiste == 0){
                    JOptionPane.showMessageDialog(null, "Usuario invalido!");
                }
                else if(funcExiste == 0){
                    JOptionPane.showMessageDialog(null, "Funcionario invalido!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores inválidos!");
            }
        });

        panelCadastro.add(inputIdLabel);
        panelCadastro.add(inputId);
        panelCadastro.add(inputDataLabel);
        panelCadastro.add(inputData);
        panelCadastro.add(inputLivroLabel);
        panelCadastro.add(inputLivro);
        panelCadastro.add(inputUsuarioLabel);
        panelCadastro.add(inputUsuario);
        panelCadastro.add(inputFuncionarioLabel);
        panelCadastro.add(inputFuncionario);

        panelCadastro.add(cancelarBt);
        panelCadastro.add(salvarBt);

        telaCadastro.add(panelCadastro);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    };
    
    public void telaConsultar(){
        //Tela onde são feitas as pesquisas, tanto para usuario, tanto para funcionarios
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
                    areaResultado.append("Título: " + livro.getTitulo() + " - ");
                    areaResultado.append("Autores: " + livro.getAutores() + " - ");
                    areaResultado.append("Categorias: " + livro.getCategorias());
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
