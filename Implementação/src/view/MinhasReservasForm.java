package view;

import javax.swing.*;
import java.awt.*;

public class MinhasReservasForm extends JFrame {

    public MinhasReservasForm() {
        setTitle("Minhas Reservas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea reservasTextArea = new JTextArea(10, 30);
        reservasTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservasTextArea);

        // Placeholder for loading and displaying Socio's reservations
        String reservas = "Reserva 1\nReserva 2\nReserva 3";
        reservasTextArea.setText(reservas);

        panel.add(new JLabel("Minhas Reservas"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(panel);
        setVisible(true);
    }
}
