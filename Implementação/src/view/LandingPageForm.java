package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPageForm {
    private JPanel landingPage;
    private JTextField nomeField;
    private JButton entrarButton;
    private JLabel mensagemLabel;

    public LandingPageForm() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEntrar();
            }
        });
    }

    private void handleEntrar() {
        String nome = nomeField.getText();
        if (!nome.isEmpty()) {
            mensagemLabel.setText("Bem-vindo!");
            // Redirecionar para a página de opções
        } else {
            mensagemLabel.setText("Por favor, insira um nome válido.");
        }
    }

    public JPanel getLandingPage() {
        return landingPage;
    }
}
