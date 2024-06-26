package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
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
        funcionarioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        adicionarButton = new JButton("Adicionar");
        editarButton = new JButton("Editar");
        apagarButton = new JButton("Apagar");
        listarButton = new JButton("Listar");

        nomeField = new JTextField(30); // Aumentando para 30 colunas
        salarioField = new JTextField(30); // Aumentando para 30 colunas
        telefoneField = new JTextField(30); // Aumentando para 30 colunas
        cargoField = new JTextField(30); // Aumentando para 30 colunas
        outputArea = new JTextArea(10, 30); // Aumentando para 30 colunas e 10 linhas
        outputArea.setEditable(false); // Para evitar edição direta da área de saída

        // Configurando os componentes usando GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        funcionarioPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        funcionarioPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        funcionarioPanel.add(new JLabel("Salário:"), gbc);
        gbc.gridx = 1;
        funcionarioPanel.add(salarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        funcionarioPanel.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        funcionarioPanel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        funcionarioPanel.add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1;
        funcionarioPanel.add(cargoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        funcionarioPanel.add(new JLabel("Output:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        funcionarioPanel.add(new JScrollPane(outputArea), gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 7;
        funcionarioPanel.add(adicionarButton, gbc);

        gbc.gridx = 1;
        funcionarioPanel.add(editarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        funcionarioPanel.add(apagarButton, gbc);

        gbc.gridx = 1;
        funcionarioPanel.add(listarButton, gbc);

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

        setContentPane(funcionarioPanel);
        setTitle("Gerenciar Funcionários");
        setSize(800, 600); // Ajustando o tamanho conforme necessário
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FuncionarioForm funcionarioForm = new FuncionarioForm();
                funcionarioForm.setVisible(true);
            }
        });
    }
}
