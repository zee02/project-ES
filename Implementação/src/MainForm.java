import view.LandingPage;
import view.NomeValidadoListener;

import javax.swing.*;

public class MainForm extends JFrame {

    private JPanel mainPanel;
    private JButton gerirFuncionariosButton;
    private JButton gerirLivrosButton;
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
        bemVindoLabel = new JLabel("Bem-vindo!");

        // Adiciona os componentes ao painel principal
        mainPanel.add(bemVindoLabel);
        mainPanel.add(gerirFuncionariosButton);
        mainPanel.add(gerirLivrosButton);

        // Adiciona o painel principal ao JFrame
        setContentPane(mainPanel);

        // Define inicialmente como invisível
        setVisible(false);
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
