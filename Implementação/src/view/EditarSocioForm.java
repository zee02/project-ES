package view;

import controller.SocioController;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarSocioForm extends JFrame {
    private Socio socio;
    private JTextField nomeField, nifField, telefoneField, moradaField, emailField;
    private JComboBox<String> tipoNotificacaoComboBox;
    private JLabel idLabel, funcionarioLabel, tipoSocioLabel;
    private JButton atualizarButton;
    private SocioController socioController;

    public EditarSocioForm(int socioId) {
        socioController = SocioController.getInstance();

        socio = socioController.getSocioById(socioId);
        if (socio == null) {
            JOptionPane.showMessageDialog(this, "Sócio não encontrado para o ID fornecido.");
            dispose();
            return;
        }

        setTitle("Editar Sócio");
        setSize(500, 400); // Ajustando o tamanho da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        idLabel = new JLabel("ID: " + socio.getId());
        idLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Definindo fonte maior e em negrito
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(idLabel, constraints);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(nomeLabel, constraints);

        nomeField = new JTextField(socio.getNome());
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(nomeField, constraints);

        JLabel nifLabel = new JLabel("NIF/CC:");
        nifLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(nifLabel, constraints);

        nifField = new JTextField(socio.getNifCc());
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(nifField, constraints);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(telefoneLabel, constraints);

        telefoneField = new JTextField(socio.getTelefone());
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(telefoneField, constraints);

        JLabel moradaLabel = new JLabel("Morada:");
        moradaLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(moradaLabel, constraints);

        moradaField = new JTextField(socio.getMorada());
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(moradaField, constraints);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(emailLabel, constraints);

        emailField = new JTextField(socio.getEmail());
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(emailField, constraints);

        JLabel tipoNotificacaoLabel = new JLabel("Tipo de Notificação:");
        tipoNotificacaoLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(tipoNotificacaoLabel, constraints);

        String[] tiposNotificacao = {"SMS", "Email"};
        tipoNotificacaoComboBox = new JComboBox<>(tiposNotificacao);
        tipoNotificacaoComboBox.setSelectedItem(socio.getTipoNotificacao());
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(tipoNotificacaoComboBox, constraints);

        funcionarioLabel = new JLabel("Funcionário: " + socio.getFuncionario());
        funcionarioLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        panel.add(funcionarioLabel, constraints);

        tipoSocioLabel = new JLabel("Tipo de Sócio: " + socio.getTipoSocio());
        tipoSocioLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Definindo fonte maior
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        panel.add(tipoSocioLabel, constraints);

        atualizarButton = new JButton("Atualizar");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        panel.add(atualizarButton, constraints);

        add(panel);

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarSocio();
            }
        });

        setVisible(true);
    }

    private void atualizarSocio() {
        socio.setNome(nomeField.getText());
        socio.setNifCc(nifField.getText());
        socio.setTelefone(telefoneField.getText());
        socio.setMorada(moradaField.getText());
        socio.setEmail(emailField.getText());
        socio.setTipoNotificacao((String) tipoNotificacaoComboBox.getSelectedItem());

        socioController.atualizarSocio(socio);

        dispose();
    }
}
