package view;

import controller.SocioController;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class NovoSocioForm extends JFrame {
    private JPanel panel;
    private JTextField nomeField;
    private JTextField nifCcField;
    private JTextField telefoneField;
    private JTextField moradaField;
    private JTextField emailField;
    private JComboBox<String> tipoNotificacaoComboBox;
    private JTextField funcionarioField;
    private JComboBox<String> tipoSocioComboBox;
    private JButton adicionarButton;
    private SocioController socioController;

    public NovoSocioForm() {
        socioController = SocioController.getInstance();

        setTitle("Novo Sócio");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField(20);
        panel.add(nomeField);

        panel.add(new JLabel("NIF/CC:"));
        nifCcField = new JTextField(20);
        panel.add(nifCcField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField(20);
        panel.add(telefoneField);

        panel.add(new JLabel("Morada:"));
        moradaField = new JTextField(20);
        panel.add(moradaField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        panel.add(emailField);

        panel.add(new JLabel("Tipo de Notificação:"));
        tipoNotificacaoComboBox = new JComboBox<>(new String[]{"SMS", "Email"});
        panel.add(tipoNotificacaoComboBox);

        panel.add(new JLabel("Funcionário:"));
        funcionarioField = new JTextField(20);
        panel.add(funcionarioField);

        panel.add(new JLabel("Tipo de Sócio:"));
        tipoSocioComboBox = new JComboBox<>(new String[]{"Regular", "Premium", "VIP"});
        panel.add(tipoSocioComboBox);

        adicionarButton = new JButton("Adicionar");
        panel.add(adicionarButton);

        add(panel);
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText().trim();
                String nifCc = nifCcField.getText().trim();
                String telefone = telefoneField.getText().trim();
                String morada = moradaField.getText().trim();
                String email = emailField.getText().trim();
                String tipoNotificacao = (String) tipoNotificacaoComboBox.getSelectedItem();
                String funcionario = funcionarioField.getText().trim();
                String tipoSocio = (String) tipoSocioComboBox.getSelectedItem();

                // Verificações dos campos
                if (nome.isEmpty() || nifCc.isEmpty() || telefone.isEmpty() || morada.isEmpty() ||
                        email.isEmpty() || funcionario.isEmpty()) {
                    JOptionPane.showMessageDialog(NovoSocioForm.this,
                            "Por favor, preencha todos os campos obrigatórios.",
                            "Campos Incompletos",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Verificação do tipo de notificação
                List<String> tiposValidos = Arrays.asList("SMS", "Email");
                if (!tiposValidos.contains(tipoNotificacao)) {
                    JOptionPane.showMessageDialog(NovoSocioForm.this,
                            "Tipo de Notificação inválido. Selecione 'SMS' ou 'Email'.",
                            "Tipo de Notificação Inválido",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Socio socio = new Socio(nome, nifCc, telefone, morada, email, tipoNotificacao, funcionario, tipoSocio);
                boolean success = socioController.addSocio(socio);

                if (success) {
                    JOptionPane.showMessageDialog(NovoSocioForm.this, "Novo Sócio Adicionado com Sucesso");
                    dispose(); // Fecha o formulário após adicionar o sócio
                } else {
                    JOptionPane.showMessageDialog(NovoSocioForm.this, "Erro ao adicionar Novo Sócio");
                }
            }
        });
    }
}
