package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisaEstatisticas extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public PesquisaEstatisticas() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addPaginaCategorias();
        addPaginaPesquisasEstatisticas();

        add(mainPanel);
        setTitle("Gestão de Pesquisas e Estatísticas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addPaginaCategorias() {
        JPanel categoriasPage = new JPanel(new BorderLayout());
        JButton pesquisasEstatisticasButton = new JButton("Pesquisas e Estatísticas");
        pesquisasEstatisticasButton.addActionListener(e -> cardLayout.show(mainPanel, "Pesquisas e Estatísticas"));
        categoriasPage.add(pesquisasEstatisticasButton, BorderLayout.CENTER);
        mainPanel.add(categoriasPage, "Categorias");
    }

    private void addPaginaPesquisasEstatisticas() {
        JPanel pesquisasEstatisticasPage = new JPanel(new BorderLayout());

        JButton bibliotecaButton = new JButton("Biblioteca");
        bibliotecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        pesquisasEstatisticasPage.add(bibliotecaButton, BorderLayout.CENTER);
        mainPanel.add(pesquisasEstatisticasPage, "Pesquisas e Estatísticas");
    }

}
