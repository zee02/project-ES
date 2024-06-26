package view;

import controller.ReservaController;
import model.Livro;
import model.Reserva;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaReservaForm extends JFrame {
    private Livro livro;
    private int socioId;
    private JTextField funcionarioField;
    private JButton adicionarButton;



    public NovaReservaForm(Livro livro, int socioId) {
        this.livro = livro;
        this.socioId = socioId;




        setTitle("Nova Reserva");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel tituloLabel = new JLabel("Título: " + livro.getNome());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(tituloLabel, constraints);

        JLabel autorLabel = new JLabel("Autor: " + livro.getAutor());
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(autorLabel, constraints);

        JLabel socioLabel = new JLabel("ID do Sócio: " + socioId);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(socioLabel, constraints);

        JLabel funcionarioLabel = new JLabel("Funcionário:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(funcionarioLabel, constraints);

        funcionarioField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(funcionarioField, constraints);

        adicionarButton = new JButton("Adicionar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(adicionarButton, constraints);

        add(panel);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String funcionario = funcionarioField.getText().trim();
                if (!funcionario.isEmpty()) {
                    Reserva novaReserva = new Reserva(livro, socioId, funcionario);
                    ReservaController.getInstance().adicionarReserva(novaReserva);
                    JOptionPane.showMessageDialog(NovaReservaForm.this, "Reserva adicionada com sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(NovaReservaForm.this, "Por favor, insira o nome do funcionário.");
                }
            }
        });

        setVisible(true);
    }
}
