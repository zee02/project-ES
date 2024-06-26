package view;

import controller.FuncionarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioMain extends JFrame {

    private FuncionarioController funcionarioController;

    public FuncionarioMain(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;

        setTitle("Gestão de Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Create a button to list employees
        JButton btnListarFuncionarios = new JButton("Listar Funcionários");

        // Add ActionListener to the button
        btnListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarFuncionariosForm listarFuncionariosForm = new ListarFuncionariosForm(funcionarioController);
                listarFuncionariosForm.setVisible(true);
            }
        });

        // Add button to the panel
        panel.add(btnListarFuncionarios);

        // Add panel to the JFrame
        add(panel);

        // Set JFrame location relative to the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();

        // Ensure Swing components are initialized on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FuncionarioMain funcionarioMain = new FuncionarioMain(funcionarioController);
                funcionarioMain.setVisible(true);
            }
        });
    }
}
