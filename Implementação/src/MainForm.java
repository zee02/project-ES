
import view.LandingPage;
import view.NomeValidadoListener;

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
    private JButton pesquisaSocioButton; // Botão para abrir o PesquisarSocioForm
    private JLabel bemVindoLabel; // Label para mostrar "Bem-vindo, <nome>!"

    public MainForm() {
        // Configura o JFrame
        setTitle("Sistema de Gestão");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os componentes da interface
        mainPanel = new JPanel();
        gerirFuncionariosButton = new JButton("Gerir Funcionários");
        gerirLivrosButton = new JButton("Gerir Livros");
        gerirSociosButton = new JButton("Gerir Sócios"); // Botão para gerir sócios
        listaSociosButton = new JButton("Lista de Sócios"); // Botão para abrir ListaSocioForm
        pesquisaSocioButton = new JButton("Pesquisar Sócio"); // Botão para abrir o PesquisarSocioForm
        bemVindoLabel = new JLabel("Bem-vindo!");

        // Adiciona os componentes ao painel principal
        mainPanel.add(bemVindoLabel);
        mainPanel.add(gerirFuncionariosButton);
        mainPanel.add(gerirLivrosButton);
        mainPanel.add(gerirSociosButton);
        mainPanel.add(listaSociosButton);
        mainPanel.add(pesquisaSocioButton);

        // Adiciona o painel principal ao JFrame
        setContentPane(mainPanel);

        // Define inicialmente como invisível
        setVisible(false);

        // Configura os ActionListeners para os botões
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

        pesquisaSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarSocioForm pesquisaSocioForm = new PesquisarSocioForm();
                pesquisaSocioForm.setVisible(true);
            }
        });
    }

    public void mostrarPaginaPrincipal(String nome) {
        // Atualiza o label de boas-vindas com o nome
        bemVindoLabel.setText("Bem-vindo, " + nome + "!");

        // Define o JFrame como visível
        setVisible(true);
    }

    // Método para abrir a Landing Page e iniciar o fluxo de login
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
