// GestaoReservasForm.java
package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestaoReservasForm extends JFrame {

    public GestaoReservasForm() {
        setTitle("Gestão de Reservas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton novaReservaButton = new JButton("Nova Reserva");

        novaReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSocioPesquisaForm();
            }
        });

        panel.add(new JLabel("Selecione uma opção:"));
        panel.add(novaReservaButton);

        setContentPane(panel);
        setVisible(true);
    }

    private void abrirSocioPesquisaForm() {
        PesquisarSocioForm socioPesquisaForm = new PesquisarSocioForm();
        socioPesquisaForm.setVisible(true);
        dispose();
    }
}
