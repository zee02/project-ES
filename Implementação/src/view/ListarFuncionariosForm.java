package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarFuncionariosForm extends JFrame {

    private FuncionarioController funcionarioController;

    public ListarFuncionariosForm(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;

        setTitle("Lista de Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Funcionario funcionario : funcionarioController.listarFuncionarios()) {
            JButton btnApagar = new JButton("Apagar");
            btnApagar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    funcionarioController.apagarFuncionario(funcionario.getNome());
                    JOptionPane.showMessageDialog(ListarFuncionariosForm.this, "Funcionário apagado com sucesso!");
                    dispose(); // Fecha a janela atual
                    new ListarFuncionariosForm(funcionarioController).setVisible(true); // Abre uma nova janela atualizada
                }
            });
            panel.add(new JLabel(funcionario.getNome()));
            panel.add(btnApagar);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        setLocationRelativeTo(null);
    }
}
