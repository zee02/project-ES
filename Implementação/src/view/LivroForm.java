package view;

import controller.LivroController;
import model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LivroForm extends JFrame {
    private JPanel livroPanel;
    private JTextField idField;
    private JComboBox<String> estadoComboBox;
    private JButton gerenciarEstadoButton;
    private JButton restaurarButton;
    private JTextArea outputArea;

    private LivroController livroController = new LivroController();

    public LivroForm() {
        // Inicialize os componentes
        livroPanel = new JPanel();
        idField = new JTextField(20);
        estadoComboBox = new JComboBox<>(new String[]{"Novo", "Usado"});
        gerenciarEstadoButton = new JButton("Gerenciar Estado");
        restaurarButton = new JButton("Restaurar");
        outputArea = new JTextArea(10, 30);

        // Configure o layout do painel
        livroPanel.setLayout(new BoxLayout(livroPanel, BoxLayout.Y_AXIS));
        livroPanel.add(new JLabel("ID do Livro:"));
        livroPanel.add(idField);
        livroPanel.add(new JLabel("Estado do Livro:"));
        livroPanel.add(estadoComboBox);
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
               // int id = idField.getText();
                String estado = (String) estadoComboBox.getSelectedItem();
             //   livroController.gerenciarEstadoLivro(id, estado);
                updateOutput();
            }
        });

        restaurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (livroController.restaurarLivro(Integer.parseInt(id))) {
                    JOptionPane.showMessageDialog(LivroForm.this, "Livro enviado para restauro!");
                    updateOutput();
                } else {
                    JOptionPane.showMessageDialog(LivroForm.this, "Livro não encontrado!");
                }
            }
        });

        // Inicializar a área de saída com os estados atuais
        updateOutput();
    }

    private void updateOutput() {
        List<Livro> livros = livroController.getLivros();
        StringBuilder sb = new StringBuilder();
        sb.append("Estados dos Livros:\n");
        for (Livro livro : livros) {
            sb.append(livro.toString()).append("\n");
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
