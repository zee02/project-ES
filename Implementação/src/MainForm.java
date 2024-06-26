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
    private JButton gestaoReservasButton; // Botão para Gestão de Reservas
    private JButton gestaoPagamentosMultasButton; // Botão para Gestão de Pagamentos e Multas
    private JButton pesquisaEstatisticasButton; // Botão para Pesquisa e Estatísticas

    private JButton gestaoMinhasReservasButton;
    private JButton pesquisaReservaPorLivroButton;


    public MainForm() {
        // Inicialize os componentes
        mainPanel = new JPanel();
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

        // Configure o layout do painel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
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



        // Configure o JFrame
        setContentPane(mainPanel);
        setTitle("Sistema de Gestão");
        setSize(400, 300); // Aumentei o tamanho para melhorar a visualização dos componentes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adicione os ouvintes de eventos aos botões
        gerirFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioForm funcionarioForm = new FuncionarioForm();
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

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
