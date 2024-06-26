package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarFuncionariosForm extends JFrame {

    private FuncionarioController funcionarioController;
    private JTable funcionariosTable;
    private DefaultTableModel tableModel;

    public ListarFuncionariosForm(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;

        setTitle("Lista de Funcionários");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Salário");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Cargo");

        funcionariosTable = new JTable(tableModel);
        funcionariosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(funcionariosTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnEditar = new JButton("Editar Funcionário");
        JButton btnApagar = new JButton("Apagar Funcionário");
        JButton btnVoltar = new JButton("Voltar");

        buttonPanel.add(btnEditar);
        buttonPanel.add(btnApagar);
        buttonPanel.add(btnVoltar);

        add(buttonPanel, BorderLayout.SOUTH);

        atualizarTabela();

        btnApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = funcionariosTable.getSelectedRow();
                if (selectedRow != -1) {
                    String nome = (String) funcionariosTable.getValueAt(selectedRow, 0);
                    funcionarioController.apagarFuncionario(nome);
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Funcionário apagado com sucesso!");
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Selecione um funcionário para apagar.");
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = funcionariosTable.getSelectedRow();
                if (selectedRow != -1) {
                    String nome = (String) funcionariosTable.getValueAt(selectedRow, 0);
                    double salario = (double) funcionariosTable.getValueAt(selectedRow, 1);
                    String telefone = (String) funcionariosTable.getValueAt(selectedRow, 2);
                    String cargo = (String) funcionariosTable.getValueAt(selectedRow, 3);

                    Funcionario funcionario = new Funcionario(nome, salario, telefone, cargo);

                    EditarFuncionarioForm editarFuncionarioForm = new EditarFuncionarioForm(funcionario);
                    editarFuncionarioForm.setVisible(true);
                    dispose(); // Fecha a janela atual
                } else {
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Selecione um funcionário para editar.");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioForm funcionarioForm = new FuncionarioForm(funcionarioController);
                funcionarioForm.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            tableModel.addRow(new Object[]{funcionario.getNome(), funcionario.getSalario(), funcionario.getTelefone(), funcionario.getCargo()});
        }
    }
}
