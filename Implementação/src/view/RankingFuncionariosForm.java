package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RankingFuncionariosForm extends JFrame {
    private JPanel rankingPanel;
    private JTextArea rankingTextArea;
    private JButton voltarButton;

    private FuncionarioController funcionarioController = new FuncionarioController();

    public RankingFuncionariosForm() {
        rankingPanel = new JPanel();
        rankingTextArea = new JTextArea(10, 30);
        voltarButton = new JButton("Voltar");

        rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));
        rankingPanel.add(new JScrollPane(rankingTextArea));
        rankingPanel.add(voltarButton);

        setContentPane(rankingPanel);
        setTitle("Ranking de Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        atualizarRanking();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void atualizarRanking() {
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        rankingTextArea.setText("");
        if (funcionarios.isEmpty()) {
            rankingTextArea.setText("Não existem funcionários");
        } else {
            // Ordenar por salário para exemplo de ranking
            funcionarios.sort((f1, f2) -> Double.compare(f2.getSalario(), f1.getSalario()));
            for (Funcionario funcionario : funcionarios) {
                rankingTextArea.append(funcionario.toString() + "\n");
            }
        }
    }
}
