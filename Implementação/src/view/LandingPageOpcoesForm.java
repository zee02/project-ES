package view;
import javax.swing.*;

public class LandingPageOpcoesForm extends JFrame {
    private JPanel opcoesPanel;

    public LandingPageOpcoesForm(String nome) {
        // Configurações básicas do JFrame
        super("Landing Page - Opções");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Criação do painel para conter os componentes
        opcoesPanel = new JPanel();
        opcoesPanel.setLayout(new BoxLayout(opcoesPanel, BoxLayout.Y_AXIS));

        // Adiciona um JLabel para exibir a mensagem de boas-vindas
        JLabel bemVindoLabel = new JLabel("Bem vindo, " + nome);
        bemVindoLabel.setAlignmentX(CENTER_ALIGNMENT); // Centraliza o JLabel horizontalmente

        // Adiciona o JLabel ao painel
        opcoesPanel.add(Box.createVerticalGlue()); // Adiciona espaço no topo
        opcoesPanel.add(bemVindoLabel);
        opcoesPanel.add(Box.createVerticalGlue()); // Adiciona espaço embaixo

        // Define o painel como conteúdo do JFrame
        setContentPane(opcoesPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPageOpcoesForm form = new LandingPageOpcoesForm("Nome do Funcionário");
                form.setVisible(true);
            }
        });
    }
}
