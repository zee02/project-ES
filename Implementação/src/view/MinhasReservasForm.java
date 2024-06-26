package view;

import controller.ReservaController;
import model.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MinhasReservasForm extends JFrame {
    private int socioId;
    private JTextArea reservasTextArea;

    public MinhasReservasForm(int socioId) {
        this.socioId = socioId;

        setTitle("Minhas Reservas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        reservasTextArea = new JTextArea();
        reservasTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservasTextArea);

        JLabel tituloLabel = new JLabel("Minhas Reservas");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tituloLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        carregarReservas();

        setContentPane(panel);
        setVisible(true);
    }

    private void carregarReservas() {
        List<Reserva> reservas = ReservaController.getInstance().getReservasBySocioId(socioId);

        if (reservas.isEmpty()) {
            reservasTextArea.setText("Nenhuma reserva encontrada para o sócio com ID: " + socioId);
        } else {
            JPanel reservasPanel = new JPanel();
            reservasPanel.setLayout(new BoxLayout(reservasPanel, BoxLayout.Y_AXIS));

            for (Reserva reserva : reservas) {
                JPanel reservaPanel = new JPanel(new BorderLayout());

                JLabel livroLabel = new JLabel("Livro: " + reserva.getLivro().getNome());
                JLabel autorLabel = new JLabel("Autor: " + reserva.getLivro().getAutor());
                JLabel idLivroLabel = new JLabel("ID do Livro: " + reserva.getLivro().getId());

                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.add(livroLabel);
                infoPanel.add(autorLabel);
                infoPanel.add(idLivroLabel);

                reservaPanel.add(infoPanel, BorderLayout.WEST);

                JButton excluirButton = new JButton("Excluir");
                excluirButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int confirmacao = JOptionPane.showConfirmDialog(
                                MinhasReservasForm.this,
                                "Tem certeza que deseja excluir esta reserva?",
                                "Confirmar Exclusão",
                                JOptionPane.YES_NO_OPTION);
                        if (confirmacao == JOptionPane.YES_OPTION) {
                            ReservaController.getInstance().removerReserva(reserva);
                            carregarReservas(); // Atualiza a lista após a exclusão
                        }
                    }
                });
                reservaPanel.add(excluirButton, BorderLayout.EAST);

                reservasPanel.add(reservaPanel);
                reservasPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre reservas
            }

            reservasTextArea.setText(""); // Limpa o text area antes de adicionar o painel de reservas
            reservasTextArea.setLayout(new BorderLayout());
            reservasTextArea.add(reservasPanel, BorderLayout.NORTH);
        }
    }
}
