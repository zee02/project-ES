package view;

import javax.swing.*;
import java.awt.*;

public class GestaoPagamentosMultas extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public GestaoPagamentosMultas() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addGestaoPagamentosMultasPage();
        addBibliotecaPage();
        addSociosPage();
        addLivrosPage();

        add(mainPanel);
        setTitle("Gestão de Pagamentos e Multas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addGestaoPagamentosMultasPage() {
        JPanel gestaoPagamentosMultasPage = new JPanel(new GridLayout(3, 1));
        JButton bibliotecaButton = new JButton("Biblioteca");
        JButton sociosButton = new JButton("Sócios");
        JButton livrosButton = new JButton("Livros");

        bibliotecaButton.addActionListener(e -> cardLayout.show(mainPanel, "Biblioteca"));
        sociosButton.addActionListener(e -> cardLayout.show(mainPanel, "Sócios"));
        livrosButton.addActionListener(e -> cardLayout.show(mainPanel, "Livros"));

        gestaoPagamentosMultasPage.add(bibliotecaButton);
        gestaoPagamentosMultasPage.add(sociosButton);
        gestaoPagamentosMultasPage.add(livrosButton);

        mainPanel.add(gestaoPagamentosMultasPage, "Gestão de Pagamentos e Multas");
        cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas");
    }

    private void addBibliotecaPage() {
        JPanel bibliotecaPage = new JPanel(new BorderLayout());
        String[] columnNames = {"Período", "Dinheiro", "Empréstimos", "Devoluções"};
        Object[][] data = {
                {"Este mês", "1000€", "50", "40"},
                {"Último mês", "800€", "45", "38"},
                {"Desde sempre", "50000€", "2000", "1900"}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        bibliotecaPage.add(scrollPane, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas"));
        bibliotecaPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(bibliotecaPage, "Biblioteca");
    }

    private void addSociosPage() {
        JPanel sociosPage = new JPanel(new BorderLayout());
        JButton searchButton = new JButton("Pesquisar Sócio por ID");

        searchButton.addActionListener(e -> {
            String socioID = JOptionPane.showInputDialog(this, "Introduza o ID do Sócio:");
            if (socioID != null && !socioID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informações do Sócio com ID: " + socioID, "Info Sócio", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado ou inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        sociosPage.add(searchButton, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas"));
        sociosPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(sociosPage, "Sócios");
    }

    private void addLivrosPage() {
        JPanel livrosPage = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Informações sobre os livros", SwingConstants.CENTER);
        livrosPage.add(label, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas"));
        livrosPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(livrosPage, "Livros");
    }

    //public static void main(String[] args) {
    //    SwingUtilities.invokeLater(() -> {
     //       GestaoPagamentosMultas frame = new GestaoPagamentosMultas();
    //        frame.setVisible(true);
    //    });
    //}
}
