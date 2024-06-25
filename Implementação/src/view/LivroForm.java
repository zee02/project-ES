package view;
import controller.LivroController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LivroForm extends JFrame {
    private JPanel livroPanel;
    private JTextField idField;
    private JTextField estadoField;
    private JButton gerenciarEstadoButton;
    private JButton restaurarButton;
    private JTextArea outputArea;

    private LivroController livroController = new LivroController();

    public LivroForm() {
        // Inicialize os componentes
        livroPanel = new JPanel();
        idField = new JTextField(20);
        estadoField = new JTextField(20);
        gerenciarEstadoButton = new JButton("Gerenciar Estado");
        restaurarButton = new JButton("Restaurar");
        outputArea = new JTextArea(10, 30);

        // Configure o layout do painel
        livroPanel.setLayout(new BoxLayout(livroPanel, BoxLayout.Y_AXIS));
        livroPanel.add(new JLabel("ID do Livro:"));
        livroPanel.add(idField);
        livroPanel.add(new JLabel("Estado do Livro:"));
        livroPanel.add(estadoField);
        livroPanel.add(gerenciarEstadoButton);
        livroPanel.add(restaurarButton);
        livroPanel.add(new JScrollPane(outputArea));

        // Configure o JFrame
        setContentPane(livroPanel);
        setTitle("Gerenciar Livros");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adicione os ouvintes de eventos aos botões
        gerenciarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String estado = estadoField.getText();
                livroController.gerenciarEstadoLivro(id, estado);
                updateOutput();
            }
        });

        restaurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                livroController.restaurarLivro(id);
                updateOutput();
            }
        });

        // Inicializar a área de saída com os estados atuais
        updateOutput();
    }

    private void updateOutput() {
        List<String> estadosLivros = livroController.listarEstadosLivros();
        StringBuilder sb = new StringBuilder();
        sb.append("Estados dos Livros:\n");
        for (String estado : estadosLivros) {
            sb.append(estado).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LivroForm().setVisible(true);
            }
        });
    }
}

