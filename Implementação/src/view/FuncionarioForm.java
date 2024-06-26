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
    private JButton rankingButton; // Botão para exibir o ranking
    private JTextField nomeField;
    private JTextField salarioField;
    private JTextField telefoneField;
    private JTextField cargoField;
    private JTextArea outputArea;

    private FuncionarioController funcionarioController;

    public FuncionarioForm(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
        funcionarioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        adicionarButton = new JButton("Adicionar");
        editarButton = new JButton("Editar");
        apagarButton = new JButton("Apagar");
        listarButton = new JButton("Listar");
        rankingButton = new JButton("Ranking"); // Inicializa o botão Ranking

        nomeField = new JTextField(30);
        salarioField = new JTextField(30);
        telefoneField = new JTextField(30);
        cargoField = new JTextField(30);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

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
        funcionarioPanel.add(listarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        funcionarioPanel.add(rankingButton, gbc); // Adiciona o botão Ranking ao painel

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String salarioText = salarioField.getText();
                String telefone = telefoneField.getText();
                String cargo = cargoField.getText();

                if (!isValidInput(nome, salarioText, telefone, cargo)) {
                    return;
                }

                try {
                    double salario = Double.parseDouble(salarioText);
                    funcionarioController.criarFuncionario(nome, salario, telefone, cargo);
                    funcionarioController.adicionarPontos(nome, 10); // Exemplo: Adiciona 10 pontos ao criar
                    outputArea.setText("Funcionário criado com sucesso!");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Salário deve ser um número válido.");
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String salarioText = salarioField.getText();
                String telefone = telefoneField.getText();
                String cargo = cargoField.getText();

                if (!isValidInput(nome, salarioText, telefone, cargo)) {
                    return;
                }

                try {
                    double salario = Double.parseDouble(salarioText);
                    funcionarioController.editarFuncionario(nome, salario, telefone, cargo);
                    outputArea.setText("Funcionário editado com sucesso!");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Salário deve ser um número válido.");
                }
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                if (nome.isEmpty()) {
                    outputArea.setText("O campo Nome deve ser preenchido.");
                    return;
                }
                funcionarioController.apagarFuncionario(nome);
                outputArea.setText("Funcionário apagado com sucesso!");
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarFuncionariosForm listarFuncionariosForm = new ListarFuncionariosForm(funcionarioController);
                listarFuncionariosForm.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankingFuncionariosForm rankingForm = new RankingFuncionariosForm(funcionarioController);
                rankingForm.setVisible(true); // Exibe a janela de ranking ao clicar no botão
            }
        });



        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criar uma nova instância do FuncionarioForm e exibir
                FuncionarioForm funcionarioForm = new FuncionarioForm(funcionarioController);
                funcionarioForm.setVisible(true);
                dispose(); // Fechar a janela atual
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        funcionarioPanel.add(btnVoltar, gbc); // Adiciona o botão Voltar ao painel

        setContentPane(funcionarioPanel);
        setTitle("Gestão Funcionários");
        setSize(800, 600); // Ajustando o tamanho conforme necessário
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private boolean isValidInput(String nome, String salarioText, String telefone, String cargo) {
        if (nome.isEmpty() || telefone.isEmpty() || cargo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return false;
        }

        try {
            double salario = Double.parseDouble(salarioText);
            if (salario < 0) {
                JOptionPane.showMessageDialog(this, "O salário não pode ser negativo.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário deve ser um número válido.");
            return false;
        }

        // Implementar validações adicionais, se necessário

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FuncionarioController funcionarioController = new FuncionarioController();
                FuncionarioForm funcionarioForm = new FuncionarioForm(funcionarioController);
                funcionarioForm.setVisible(true);
            }
        });
    }
}
