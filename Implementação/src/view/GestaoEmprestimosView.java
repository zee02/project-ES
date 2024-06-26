package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestaoEmprestimosView extends JFrame {
    private JButton btnValoresDivida;
    private JButton btnAnuidade;
    private JButton btnRestricoes;

    public GestaoEmprestimosView() {
        setTitle("Gestão de Empréstimos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        btnValoresDivida = new JButton("Valores de Dívida");
        btnAnuidade = new JButton("Anuidade");
        btnRestricoes = new JButton("Restrições");

        panel.add(btnValoresDivida);
        panel.add(btnAnuidade);
        panel.add(btnRestricoes);

        add(panel);

        btnValoresDivida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Quando um Sócio ultrapassa a data de devolução, ele acumula dívidas diárias. Por exemplo, se a multa é de 2,50 € por dia, a cada dia que passa, essa dívida aumenta. Isso incentiva os usuários a devolverem os itens a tempo e cobre os custos associados aos atrasos.");
                // Aqui você abriria a janela de Valores de Dívida com as informações relevantes
            }
        });

        btnAnuidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Para manter sua associação ativa e aproveitar todos os benefícios oferecidos pela nossa biblioteca, atente-se às seguintes condições de anuidade:\n" +
                        "\n" +
                        "Sócio Premium:\n" +
                        "Anuidade: 20 euros por ano\n" +
                        "Benefícios: Pode requisitar até 3 livros ao mesmo tempo.\n" +
                        "\n" +
                        "Sócio Normal:\n" +
                        "\n" +
                        "Anuidade: 10 euros por ano\n" +
                        "«Benefícios: Pode requisitar até 1 livro por vez.\n" +
                        "\n" +
                        "Regularize sua anuidade dentro do prazo para continuar desfrutando dos serviços de empréstimo de livros. Caso a anuidade não seja paga, você ficará impossibilitado de requisitar novos livros até que a situação seja\u2028regularizada.");
                // Aqui você abriria a janela de Anuidade com as informações relevantes
            }
        });

        btnRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Impedir empréstimos com multas pendentes promove a responsabilidade do usuário e evita o acúmulo de débitos. Além disso, a restrição de empréstimos ativos garante o retorno oportuno dos materiais, facilitando o acesso equitativo aos recursos. Essas medidas garantem uma experiência eficiente e justa para todos os usuários da biblioteca.");
                // Aqui você abriria a janela de Restrições com as informações relevantes
            }
        });
    }


}
