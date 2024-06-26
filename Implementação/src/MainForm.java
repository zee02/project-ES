import controller.FuncionarioController;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JButton gerirFuncionariosButton;
    private JButton gerirLivrosButton;
    private JButton gerirSociosButton;
    private JButton listaSociosButton;
    private JButton pesquisaSocioButton;
    private JButton gestaoReservasButton; // Botão para Gestão de Reservas dsdsa
    private JButton gestaoPagamentosMultasButton; // Botão para Gestão de Pagamentos e Multas
    private JButton pesquisaEstatisticasButton; // Botão para Pesquisa e Estatísticas
    private JLabel bemVindoLabel;
    private JButton gestaoMinhasReservasButton;
    private JButton pesquisaReservaPorLivroButton;

    private JButton PesquisaNovoEmprestimoButton;

    public MainForm() {
        // Inicialize os componentes
        mainPanel = new JPanel();
        bemVindoLabel = new JLabel("Bem-vindo!");
        gerirFuncionariosButton = new JButton("Gerir Funcionários");
        gerirLivrosButton = new JButton("Gerir Livros");
        gerirSociosButton = new JButton("Novo Sócio");
        listaSociosButton = new JButton("Lista de Sócios");
        pesquisaSocioButton = new JButton("Pesquisar Sócio");
        gestaoReservasButton = new JButton("Gestão de Reservas"); // Botão para Gestão de Reservas
        gestaoPagamentosMultasButton = new JButton("Gestão de Pagamentos e Multas"); // Botão para Gestão de Pagamentos e Multas
        pesquisaEstatisticasButton = new JButton("Pesquisa e Estatísticas"); // Botão para Pesquisa e Estatísticas
        gestaoMinhasReservasButton = new JButton("Minhas Reservas");
        pesquisaReservaPorLivroButton = new JButton("Pesquisar Reserva por Livro");
        PesquisaNovoEmprestimoButton = new JButton(" Requistar Novo emprestimo");

        // Configure o layout do painel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(bemVindoLabel);
        mainPanel.add(gerirFuncionariosButton);
        mainPanel.add(gerirLivrosButton);
        mainPanel.add(gerirSociosButton);
        mainPanel.add(listaSociosButton);
        mainPanel.add(pesquisaSocioButton);
        mainPanel.add(gestaoReservasButton); // Adicionar o botão de Gestão de Reservas
        mainPanel.add(gestaoPagamentosMultasButton); // Adicionar o botão de Gestão de Pagamentos e Multas
        mainPanel.add(pesquisaEstatisticasButton); // Adicionar o botão de Pesquisa e Estatísticas
        mainPanel.add(gestaoMinhasReservasButton);
        mainPanel.add(pesquisaReservaPorLivroButton);
        mainPanel.add(PesquisaNovoEmprestimoButton);

        // Configure o JFrame
        setContentPane(mainPanel);
        setTitle("Sistema de Gestão");
        setSize(600, 400); // Aumentei o tamanho para melhorar a visualização dos componentes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gerirFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Gerir Funcionários clicado!"); // Verificação simples
                FuncionarioController funcionarioController = new FuncionarioController();
                FuncionarioForm funcionarioForm = new FuncionarioForm(funcionarioController);
                funcionarioForm.setVisible(true);
            }
        });



        gerirLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivroForm livroForm = new LivroForm();
                livroForm.setVisible(true);
            }
        });

        gerirSociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NovoSocioForm novoSocioForm = new NovoSocioForm();
                novoSocioForm.setVisible(true);
            }
        });

        listaSociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaSocioForm listaSocioForm = new ListaSocioForm();
                listaSocioForm.setVisible(true);
            }
        });

        PesquisaNovoEmprestimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisaNovoEmprestimo pesquisaNovoEmprestimo = new PesquisaNovoEmprestimo();
                pesquisaNovoEmprestimo.setVisible(true);
            }
        });


        pesquisaReservaPorLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarReservaPorLivroForm pesquisarReservaPorLivroForm = new PesquisarReservaPorLivroForm();
                pesquisarReservaPorLivroForm.setVisible(true);
            }
        });

        pesquisaSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarSocioForm pesquisaSocioForm = new PesquisarSocioForm();
                pesquisaSocioForm.setVisible(true);
            }
        });

        gestaoReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarSocioFormReserva pesquisarSocioFormReserva = new PesquisarSocioFormReserva();
                pesquisarSocioFormReserva.setVisible(true);
            }
        });

        gestaoMinhasReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarSocioFormMinhasReservas pesquisarSocioFormMinhasReservas = new PesquisarSocioFormMinhasReservas();
                pesquisarSocioFormMinhasReservas.setVisible(true);
            }
        });

        gestaoPagamentosMultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestaoPagamentosMultas gestaoPagamentosMultasForm = new GestaoPagamentosMultas();
                gestaoPagamentosMultasForm.setVisible(true);
            }
        });

        pesquisaEstatisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisaEstatisticas pesquisaEstatisticasForm = new PesquisaEstatisticas();
                pesquisaEstatisticasForm.setVisible(true);
            }
        });

        // Inicialmente, o MainForm não é visível
        setVisible(false);
    }

    public void mostrarPaginaPrincipal(String nome) {
        // Atualiza o label de boas-vindas com o nome
        bemVindoLabel.setText("Bem-vindo, " + nome + "!");
        // Define o JFrame como visível
        setVisible(true);
    }

    private void abrirLandingPage() {
        LandingPage landingPageNomeForm = new LandingPage();
        landingPageNomeForm.setVisible(true);
        landingPageNomeForm.addNomeValidadoListener(new NomeValidadoListener() {
            @Override
            public void nomeValidado(String nome) {
                // Quando o nome é validado, exibir MainForm
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mostrarPaginaPrincipal(nome);
                        landingPageNomeForm.dispose(); // Fechar a Landing Page
                    }
                });
            }

            @Override
            public void nomeInvalido() {
                // Caso o nome seja inválido (não tratado no exemplo anterior)
                JOptionPane.showMessageDialog(MainForm.this, "Ocorreu um erro, o teu pedido de acesso não teve sucesso");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainForm mainForm = new MainForm();
                mainForm.abrirLandingPage(); // Abre a Landing Page inicialmente
            }
        });
    }
}
