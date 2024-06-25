package view;
import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FuncionarioForm extends JFrame {
    private JPanel funcionarioPanel;
    private JButton adicionarButton;
    private JButton editarButton;
    private JButton apagarButton;
    private JButton listarButton;
    private JTextField nomeField;
    private JTextField salarioField;
    private JTextField telefoneField;
    private JTextField cargoField;
    private JTextArea outputArea;

    private FuncionarioController funcionarioController;

    public FuncionarioForm() {
        funcionarioController = new FuncionarioController();
        setContentPane(funcionarioPanel);
        setTitle("Gerenciar Funcionários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double salario = Double.parseDouble(salarioField.getText());
                String telefone = telefoneField.getText();
                String cargo = cargoField.getText();
                funcionarioController.criarFuncionario(nome, salario, telefone, cargo);
                outputArea.setText("Funcionário criado com sucesso!");
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double salario = Double.parseDouble(salarioField.getText());
                String telefone = telefoneField.getText();
                String cargo = cargoField.getText();
                funcionarioController.editarFuncionario(nome, salario, telefone, cargo);
                outputArea.setText("Funcionário editado com sucesso!");
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                funcionarioController.apagarFuncionario(nome);
                outputArea.setText("Funcionário apagado com sucesso!");
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Funcionario f : funcionarioController.listarFuncionarios()) {
                    sb.append("Nome: ").append(f.getNome()).append(", Salário: ").append(f.getSalario())
                            .append(", Telefone: ").append(f.getTelefone()).append(", Cargo: ").append(f.getCargo()).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });
    }
}
