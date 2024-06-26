package view;

import model.Socio;

import javax.swing.*;
import java.awt.*;

public class VisualizarSocioForm {
    private JFrame frame;
    private JPanel panel;
    private JLabel idLabel, nomeLabel, nifCcLabel, telefoneLabel, moradaLabel, emailLabel, tipoNotificacaoLabel, funcionarioLabel, tipoSocioLabel;

    public VisualizarSocioForm(Socio socio) {
        frame = new JFrame("Visualizar Sócio");
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        idLabel = new JLabel(String.valueOf(socio.getId()));
        panel.add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        nomeLabel = new JLabel(socio.getNome());
        panel.add(nomeLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("NIF/CC:"), gbc);

        gbc.gridx = 1;
        nifCcLabel = new JLabel(socio.getNifCc());
        panel.add(nifCcLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        telefoneLabel = new JLabel(socio.getTelefone());
        panel.add(telefoneLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Morada:"), gbc);

        gbc.gridx = 1;
        moradaLabel = new JLabel(socio.getMorada());
        panel.add(moradaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailLabel = new JLabel(socio.getEmail());
        panel.add(emailLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Tipo de Notificação:"), gbc);

        gbc.gridx = 1;
        tipoNotificacaoLabel = new JLabel(socio.getTipoNotificacao());
        panel.add(tipoNotificacaoLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Funcionário:"), gbc);

        gbc.gridx = 1;
        funcionarioLabel = new JLabel(socio.getFuncionario());
        panel.add(funcionarioLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Tipo de Sócio:"), gbc);

        gbc.gridx = 1;
        tipoSocioLabel = new JLabel(socio.getTipoSocio());
        panel.add(tipoSocioLabel, gbc);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> frame.dispose());
        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(fecharButton, gbc);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
