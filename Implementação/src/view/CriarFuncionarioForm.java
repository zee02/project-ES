package view;

import controller.FuncionarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarFuncionarioForm extends JFrame {
    private JPanel criarFuncionarioPanel;
    private JTextField nomeField;
    private JTextField salarioField;
    private JTextField telefoneField;
    private JTextField cargoField;
    private JButton criarButton;
    private JButton voltarButton;

    private FuncionarioController funcionarioController = new FuncionarioController();

    public CriarFuncionarioForm() {
        criarFuncionarioPanel = new JPanel();
        nomeField = new JTextField(20);
        salarioField = new JTextField(20);
        telefoneField = new JTextField(20);
        cargoField = new JTextField(20);
        criarButton = new JButton("Criar");
        voltarButton = new JButton("Voltar");

        criarFuncionarioPanel.setLayout(new BoxLayout(criarFuncionarioPanel, BoxLayout.Y_AXIS));
        criarFuncionarioPanel.add(new JLabel("Nome:"));
        criarFuncionarioPanel.add(nomeField);
        criarFuncionarioPanel.add(new JLabel("Salário:"));
        criarFuncionarioPanel.add(salarioField);
        criarFuncionarioPanel.add(new JLabel("Telefone:"));
        criarFuncionarioPanel.add(telefoneField);
        criarFuncionarioPanel.add(new JLabel("Cargo:"));
        criarFuncionarioPanel.add(cargoField);
        criarFuncionarioPanel.add(criarButton);
        criarFuncionarioPanel.add(voltarButton);

        setContentPane(criarFuncionarioPanel);
        setTitle("Criar Funcionário");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    double salario = Double.parseDouble(salarioField.getText());
                    String telefone = telefoneField.getText();
                    String cargo = cargoField.getText();

                    if (nome.isEmpty() || telefone.isEmpty() || cargo.isEmpty()) {
                        JOptionPane.showMessageDialog(CriarFuncionarioForm.this, "Os dados foram inseridos de forma incorreta");
                    } else {
                        funcionarioController.criarFuncionario(nome, salario, telefone, cargo);
                        JOptionPane.showMessageDialog(CriarFuncionarioForm.this, "Funcionário criado com sucesso");
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CriarFuncionarioForm.this, "Os dados foram inseridos de forma incorreta");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
