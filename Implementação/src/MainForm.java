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
    private JButton pesquisaSocioButton; // Botão para abrir o PesquisaSocioForm

    public MainForm() {
        // Inicialize os componentes
        mainPanel = new JPanel();
        gerirFuncionariosButton = new JButton("Gerir Funcionários");
        gerirLivrosButton = new JButton("Gerir Livros");
        gerirSociosButton = new JButton("Novo Sócio");
        listaSociosButton = new JButton("Lista de Sócios");
        pesquisaSocioButton = new JButton("Pesquisar Sócio"); // Botão para abrir o PesquisaSocioForm

        // Configure o layout do painel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(gerirFuncionariosButton);
        mainPanel.add(gerirLivrosButton);
        mainPanel.add(gerirSociosButton);
        mainPanel.add(listaSociosButton);
        mainPanel.add(pesquisaSocioButton); // Adicionar o botão de pesquisa de sócio

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
