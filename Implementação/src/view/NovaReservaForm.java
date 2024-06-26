// NovaReservaForm.java
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaReservaForm extends JFrame {

    public NovaReservaForm() {
        setTitle("Nova Reserva");
        setSize(400, 300); // Ajustando o tamanho da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel livroInfoLabel = new JLabel("Informações do Livro:");
        livroInfoLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Ajustando a fonte para um título

        JTextArea livroTextArea = new JTextArea(5, 30);
        livroTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(livroTextArea);

        // Simulando informações de um livro para a reserva
        String infoLivro = "Título: Livro Exemplo\nAutor: Autor Exemplo\nNº de pessoas em lista de espera: 5";
        livroTextArea.setText(infoLivro);

        JLabel funcionarioLabel = new JLabel("Selecione o funcionário:");
        JComboBox<String> funcionarioComboBox = new JComboBox<>(new String[]{"Funcionário 1", "Funcionário 2", "Funcionário 3"});

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui seria o código para confirmar a reserva
                JOptionPane.showMessageDialog(NovaReservaForm.this, "Reserva do Livro confirmada");
                dispose();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(livroInfoLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(funcionarioLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(funcionarioComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(adicionarButton, constraints);

        setContentPane(panel);
        setVisible(true);
    }
}
