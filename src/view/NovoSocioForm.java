package view;

import controller.SocioController;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoSocioForm {
    private JPanel novoSocio;
    private JTextField nomeField;
    private JTextField nifCcField;
    private JTextField telefoneField;
    private JTextField moradaField;
    private JTextField emailField;
    private JTextField tipoNotificacaoField;
    private JTextField funcionarioField;
    private JTextField tipoSocioField;
    private JButton adicionarButton;
    private JLabel mensagemLabel;

    private SocioController socioController = new SocioController();

    public NovoSocioForm() {
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAdicionar();
            }
        });
    }

    private void handleAdicionar() {
        Socio socio = new Socio(
                nomeField.getText(),
                nifCcField.getText(),
                telefoneField.getText(),
                moradaField.getText(),
                emailField.getText(),
                tipoNotificacaoField.getText(),
                funcionarioField.getText(),
                tipoSocioField.getText()
        );

        String resultado = socioController.adicionarSocio(socio);
        mensagemLabel.setText(resultado);
    }

    public JPanel getNovoSocio() {
        return novoSocio;
    }
}
