package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarSocioFormReserva extends JFrame {
    private JTextField idField;
    private JButton pesquisarButton;
    private JFrame frame;

    public PesquisarSocioFormReserva() {
        frame = new JFrame();
        frame.setTitle("Pesquisar Sócio por ID");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel idLabel = new JLabel("ID do Sócio:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(idLabel, constraints);

        idField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(idField, constraints);

        pesquisarButton = new JButton("Pesquisar");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(pesquisarButton, constraints);

        frame.add(panel);

        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText().trim();
                if (!idText.isEmpty()) {
                    int socioId = Integer.parseInt(idText);
                    frame.dispose();
                    new ListaLivrosRequisitadosForm(socioId);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira o ID do sócio.");
                }
            }
        });

        frame.setVisible(true);
    }
}