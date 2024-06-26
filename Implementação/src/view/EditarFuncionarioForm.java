package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarFuncionarioForm extends JFrame {
    private JPanel editarFuncionarioPanel;
    private JTextField nomeField;
    private JTextField salarioField;
    private JTextField telefoneField;
    private JTextField cargoField;
    private JButton editarButton;
    private JButton voltarButton;

    private FuncionarioController funcionarioController = new FuncionarioController();

    public EditarFuncionarioForm(Funcionario funcionario) {
        editarFuncionarioPanel = new JPanel();
        nomeField = new JTextField(funcionario.getNome(), 20);
        salarioField = new JTextField(String.valueOf(funcionario.getSalario()), 20);
        telefoneField = new JTextField(funcionario.getTelefone(), 20);
        cargoField = new JTextField(funcionario.getCargo(), 20);
        editarButton = new JButton("Editar");
        voltarButton = new JButton("Voltar");

        editarFuncionarioPanel.setLayout(new BoxLayout(editarFuncionarioPanel, BoxLayout.Y_AXIS));
        editarFuncionarioPanel.add(new JLabel("Nome:"));
        editarFuncionarioPanel.add(nomeField);
        editarFuncionarioPanel.add(new JLabel("Salário:"));
        editarFuncionarioPanel.add(salarioField);
        editarFuncionarioPanel.add(new JLabel("Telefone:"));
        editarFuncionarioPanel.add(telefoneField);
        editarFuncionarioPanel.add(new JLabel("Cargo:"));
        editarFuncionarioPanel.add(cargoField);
        editarFuncionarioPanel.add(editarButton);
        editarFuncionarioPanel.add(voltarButton);

        setContentPane(editarFuncionarioPanel);
        setTitle("Editar Funcionário");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    double salario = Double.parseDouble(salarioField.getText());
                    String telefone = telefoneField.getText();
                    String cargo = cargoField.getText();

                    if (nome.isEmpty() || telefone.isEmpty() || cargo.isEmpty()) {
                        JOptionPane.showMessageDialog(EditarFuncionarioForm.this, "Os dados foram inseridos de forma incorreta");
                    } else {
                        funcionarioController.editarFuncionario(nome, salario, telefone, cargo);
                        JOptionPane.showMessageDialog(EditarFuncionarioForm.this, "Funcionário editado com sucesso");
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarFuncionarioForm.this, "Os dados foram inseridos de forma incorreta");
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
