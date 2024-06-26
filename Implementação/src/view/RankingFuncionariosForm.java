package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RankingFuncionariosForm extends JFrame {
    private JPanel rankingPanel;
    private JTextArea rankingTextArea;

    public RankingFuncionariosForm(FuncionarioController funcionarioController) {
        setTitle("Ranking de Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        rankingPanel = new JPanel(new BorderLayout());
        rankingTextArea = new JTextArea();
        rankingTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rankingTextArea);

        rankingPanel.add(scrollPane, BorderLayout.CENTER);

        List<Funcionario> funcionarios = funcionarioController.listarFuncionariosPorPontos();
        exibirRanking(funcionarios);

        setContentPane(rankingPanel);
        setLocationRelativeTo(null);
    }

    private void exibirRanking(List<Funcionario> funcionarios) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ranking de Funcionários por Pontos:\n\n");
        int posicao = 1;
        for (Funcionario f : funcionarios) {
            sb.append(posicao).append(". ")
                    .append("Nome: ").append(f.getNome()).append(", ")
                    .append("Pontos: ").append(f.getPontos()).append("\n");
            posicao++;
        }
        rankingTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        controller.criarFuncionario("João", 2500, "123456789", "Analista");
        controller.criarFuncionario("Maria", 3000, "987654321", "Gerente");
        controller.criarFuncionario("Pedro", 2000, "456789123", "Programador");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RankingFuncionariosForm rankingForm = new RankingFuncionariosForm(controller);
                rankingForm.setVisible(true);
            }
        });
    }
}
