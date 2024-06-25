import view.FuncionarioForm;
import view.LivroForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JButton gerirFuncionariosButton;
    private JButton gerirLivrosButton;

    public MainForm() {
        // Inicialize os componentes
        mainPanel = new JPanel();
        gerirFuncionariosButton = new JButton("Gerir Funcionários");
        gerirLivrosButton = new JButton("Gerir Livros");

        // Configure o layout do painel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(gerirFuncionariosButton);
        mainPanel.add(gerirLivrosButton);

        // Configure o JFrame
        setContentPane(mainPanel);
        setTitle("Sistema de Gestão");
        setSize(400, 200);
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
