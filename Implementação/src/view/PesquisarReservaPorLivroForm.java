package view;

import controller.ReservaController;
import model.Reserva;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PesquisarReservaPorLivroForm extends JFrame {
    private JTextField livroIdField;
    private JTextArea reservasTextArea;

    public PesquisarReservaPorLivroForm() {
        setTitle("Pesquisar Reservas por ID do Livro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel livroIdLabel = new JLabel("ID do Livro:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(livroIdLabel, constraints);

        livroIdField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        inputPanel.add(livroIdField, constraints);

        JButton pesquisarButton = new JButton("Pesquisar");
        constraints.gridx = 2;
        constraints.gridy = 0;
        inputPanel.add(pesquisarButton, constraints);

        panel.add(inputPanel, BorderLayout.NORTH);

        reservasTextArea = new JTextArea();
        reservasTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservasTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        pesquisarButton.addActionListener(e -> pesquisarReservas());

        setContentPane(panel);
        setVisible(true);
    }

    private void pesquisarReservas() {
        String livroIdText = livroIdField.getText().trim();
        if (!livroIdText.isEmpty()) {
            try {
                int livroId = Integer.parseInt(livroIdText);
                List<Reserva> reservas = ReservaController.getInstance().getReservasByLivroId(livroId);

                if (reservas.isEmpty()) {
                    reservasTextArea.setText("Nenhuma reserva encontrada para o livro com ID: " + livroId);
                } else {
                    StringBuilder reservasInfo = new StringBuilder();
                    for (Reserva reserva : reservas) {
                        reservasInfo.append("ID da Reserva: ").append(reserva.getLivro().getId())
                                .append("\nLivro: ").append(reserva.getLivro().getNome())
                                .append("\nAutor: ").append(reserva.getLivro().getAutor())
                                .append("\nID do Sócio: ").append(reserva.getSocioId())
                                .append("\n\n");
                    }
                    reservasTextArea.setText(reservasInfo.toString());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de livro válido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira o ID do livro.");
        }
    }
}
