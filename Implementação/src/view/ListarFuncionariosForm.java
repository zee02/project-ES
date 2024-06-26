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

    public ListarFuncionariosForm(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;

        setTitle("Lista de Funcionários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar modelo de tabela
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Salário");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Cargo");

        // Preencher a tabela com dados dos funcionários
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        for (Funcionario f : funcionarios) {
            tableModel.addRow(new Object[]{f.getNome(), f.getSalario(), f.getTelefone(), f.getCargo()});
        }

        // Criar a tabela com o modelo
        JTable funcionariosTable = new JTable(tableModel);
        funcionariosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Seleção única

        // Adicionar a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(funcionariosTable);
        getContentPane().add(scrollPane);

        // Botão para apagar funcionário selecionado
        JButton btnApagar = new JButton("Apagar Funcionário");
        btnApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = funcionariosTable.getSelectedRow();
                if (selectedRow != -1) { // Verifica se uma linha foi selecionada
                    String nome = (String) funcionariosTable.getValueAt(selectedRow, 0);
                    funcionarioController.apagarFuncionario(nome);
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Funcionário apagado com sucesso!");
                    atualizarTabela(tableModel); // Atualiza a tabela após apagar
                } else {
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Selecione um funcionário para apagar.");
                }
            }
        });

        getContentPane().add(btnApagar, BorderLayout.SOUTH);
    }

    private void atualizarTabela(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // Limpa todas as linhas da tabela
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        for (Funcionario f : funcionarios) {
            tableModel.addRow(new Object[]{f.getNome(), f.getSalario(), f.getTelefone(), f.getCargo()});
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListarFuncionariosForm listarFuncionariosForm = new ListarFuncionariosForm(funcionarioController);
                listarFuncionariosForm.setVisible(true);
            }
        });
    }
}
