package view;

import javax.swing.*;
import java.awt.*;

public class PesquisaEstatisticas extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public PesquisaEstatisticas() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addPesquisaEstatisticaPage();
        addBibliotecaPage();
        addSociosPage();
        addLivrosPage();
        addLivroEspecificoPage();
        addTopLivrosPage();
        addAutoresPage();
        addGenerosPage();
        addSubgenerosPage();
        addGeralPage();

        add(mainPanel);
        setTitle("Pesquisa e Estatística");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addPesquisaEstatisticaPage() {
        JPanel pesquisaEstatisticaPage = new JPanel(new GridLayout(3, 1));
        JButton bibliotecaButton = new JButton("Biblioteca");
        JButton sociosButton = new JButton("Sócios");
        JButton livrosButton = new JButton("Livros");

        bibliotecaButton.addActionListener(e -> cardLayout.show(mainPanel, "Biblioteca"));
        sociosButton.addActionListener(e -> cardLayout.show(mainPanel, "Sócios"));
        livrosButton.addActionListener(e -> cardLayout.show(mainPanel, "Livros"));

        pesquisaEstatisticaPage.add(bibliotecaButton);
        pesquisaEstatisticaPage.add(sociosButton);
        pesquisaEstatisticaPage.add(livrosButton);

        mainPanel.add(pesquisaEstatisticaPage, "Pesquisa e Estatística");
        cardLayout.show(mainPanel, "Pesquisa e Estatística");
    }

    private void addBibliotecaPage() {
        JPanel bibliotecaPage = new JPanel(new BorderLayout());
        String[] columnNames = {"Período", "Dinheiro", "Empréstimos", "Devoluções", "Quantidade de Sócios"};
        Object[][] data = {
                {"Este mês", "1000€", "50", "40", "10"},
                {"Último mês", "800€", "45", "38", "8"},
                {"Desde sempre", "50000€", "2000", "1900", "500"}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        bibliotecaPage.add(scrollPane, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Pesquisa e Estatística"));
        bibliotecaPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(bibliotecaPage, "Biblioteca");
    }

    private void addSociosPage() {
        JPanel sociosPage = new JPanel(new BorderLayout());
        JButton searchButton = new JButton("Pesquisar Sócio por ID");

        searchButton.addActionListener(e -> {
            String socioID = JOptionPane.showInputDialog(this, "Introduza o ID do Sócio:");
            if (socioID != null && !socioID.trim().isEmpty()) {
                String[] columnNames = {"Título", "Data de Empréstimo", "Data de Devolução"};
                Object[][] data = {
                        {"Livro A", "01/01/2022", "15/01/2022"},
                        {"Livro B", "05/02/2022", "20/02/2022"}
                };
                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);

                JFrame socioFrame = new JFrame("Informações do Sócio");
                socioFrame.setSize(300, 200);
                socioFrame.add(scrollPane);
                socioFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado ou inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        sociosPage.add(searchButton, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Pesquisa e Estatística"));
        sociosPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(sociosPage, "Sócios");
    }

    private void addLivrosPage() {
        JPanel livrosPage = new JPanel(new GridLayout(2, 1));
        JButton livroEspecificoButton = new JButton("Livro Específico");
        JButton topLivrosButton = new JButton("Top Livros");

        livroEspecificoButton.addActionListener(e -> cardLayout.show(mainPanel, "Livro Específico"));
        topLivrosButton.addActionListener(e -> cardLayout.show(mainPanel, "Top Livros"));

        livrosPage.add(livroEspecificoButton);
        livrosPage.add(topLivrosButton);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Pesquisa e Estatística"));
        livrosPage.add(backButton);

        mainPanel.add(livrosPage, "Livros");
    }

    private void addLivroEspecificoPage() {
        JPanel livroEspecificoPage = new JPanel(new BorderLayout());
        JButton searchButton = new JButton("Pesquisar Livro por ID");

        searchButton.addActionListener(e -> {
            String livroID = JOptionPane.showInputDialog(this, "Introduza o ID do Livro:");
            if (livroID != null && !livroID.trim().isEmpty()) {
                // Example of displaying book details; replace with actual data retrieval logic
                JFrame livroFrame = new JFrame("Informações do Livro");
                livroFrame.setSize(300, 200);
                JLabel infoLabel = new JLabel("Informações do Livro com ID: " + livroID, SwingConstants.CENTER);
                livroFrame.add(infoLabel);
                livroFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado ou inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        livroEspecificoPage.add(searchButton, BorderLayout.CENTER);
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Livros"));
        livroEspecificoPage.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(livroEspecificoPage, "Livro Específico");
    }

    private void addTopLivrosPage() {
        JPanel topLivrosPage = new JPanel(new GridLayout(4, 1));
        JButton autoresButton = new JButton("Autores");
        JButton generoButton = new JButton("Gênero");
        JButton subgeneroButton = new JButton("Subgênero");
        JButton geralButton = new JButton("Geral");

        autoresButton.addActionListener(e -> cardLayout.show(mainPanel, "Autores"));
        generoButton.addActionListener(e -> cardLayout.show(mainPanel, "Gêneros"));
        subgeneroButton.addActionListener(e -> cardLayout.show(mainPanel, "Subgêneros"));
        geralButton.addActionListener(e -> cardLayout.show(mainPanel, "Geral"));

        topLivrosPage.add(autoresButton);
        topLivrosPage.add(generoButton);
        topLivrosPage.add(subgeneroButton);
        topLivrosPage.add(geralButton);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Livros"));
        topLivrosPage.add(backButton);

        mainPanel.add(topLivrosPage, "Top Livros");
    }

    private void addAutoresPage() {
        JPanel autoresPage = new JPanel(new BorderLayout());
        String[] autores = {"Autor 1", "Autor 2", "Autor 3"};
        JComboBox<String> autoresDropdown = new JComboBox<>(autores);
        autoresPage.add(autoresDropdown, BorderLayout.NORTH);

        JButton selectButton = new JButton("Selecionar");
        selectButton.addActionListener(e -> {
            String selectedAutor = (String) autoresDropdown.getSelectedItem();
            String[] columnNames = {"Título", "Ano", "Mais Info"};
            Object[][] data = {
                    {"Livro A", "2020", "Mais Info"},
                    {"Livro B", "2021", "Mais Info"}
            };
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            autoresPage.add(scrollPane, BorderLayout.CENTER);

            JButton maisInfoButton = new JButton("Mais Info");
            maisInfoButton.addActionListener(event -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String bookTitle = (String) table.getValueAt(selectedRow, 0);
                    JFrame bookInfoFrame = new JFrame("Informações do Livro");
                    bookInfoFrame.setSize(300, 200);
                    JLabel bookInfoLabel = new JLabel("Informações do Livro: " + bookTitle, SwingConstants.CENTER);
                    bookInfoFrame.add(bookInfoLabel);
                    bookInfoFrame.setVisible(true);
                }
            });
            autoresPage.add(maisInfoButton, BorderLayout.SOUTH);
        });

        autoresPage.add(selectButton, BorderLayout.SOUTH);

        mainPanel.add(autoresPage, "Autores");
    }

    private void addGenerosPage() {
        JPanel generosPage = new JPanel(new BorderLayout());
        String[] generos = {"Gênero 1", "Gênero 2", "Gênero 3"};
        JComboBox<String> generosDropdown = new JComboBox<>(generos);
        generosPage.add(generosDropdown, BorderLayout.NORTH);

        JButton selectButton = new JButton("Selecionar");
        selectButton.addActionListener(e -> {
            String selectedGenero = (String) generosDropdown.getSelectedItem();
            String[] columnNames = {"Título", "Ano", "Mais Info"};
            Object[][] data = {
                    {"Livro A", "2020", "Mais Info"},
                    {"Livro B", "2021", "Mais Info"}
            };
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            generosPage.add(scrollPane, BorderLayout.CENTER);

            JButton maisInfoButton = new JButton("Mais Info");
            maisInfoButton.addActionListener(event -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String bookTitle = (String) table.getValueAt(selectedRow, 0);
                    JFrame bookInfoFrame = new JFrame("Informações do Livro");
                    bookInfoFrame.setSize(300, 200);
                    JLabel bookInfoLabel = new JLabel("Informações do Livro: " + bookTitle, SwingConstants.CENTER);
                    bookInfoFrame.add(bookInfoLabel);
                    bookInfoFrame.setVisible(true);
                }
            });
            generosPage.add(maisInfoButton, BorderLayout.SOUTH);
        });

        generosPage.add(selectButton, BorderLayout.SOUTH);

        mainPanel.add(generosPage, "Gêneros");
    }

    private void addSubgenerosPage() {
        JPanel subgenerosPage = new JPanel(new BorderLayout());
        String[] subgeneros = {"Subgênero 1", "Subgênero 2", "Subgênero 3"};
        JComboBox<String> subgenerosDropdown = new JComboBox<>(subgeneros);
        subgenerosPage.add(subgenerosDropdown, BorderLayout.NORTH);

        JButton selectButton = new JButton("Selecionar");
        selectButton.addActionListener(e -> {
            String selectedSubgenero = (String) subgenerosDropdown.getSelectedItem();
            String[] columnNames = {"Título", "Ano", "Mais Info"};
            Object[][] data = {
                    {"Livro A", "2020", "Mais Info"},
                    {"Livro B", "2021", "Mais Info"}
            };
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            subgenerosPage.add(scrollPane, BorderLayout.CENTER);

            JButton maisInfoButton = new JButton("Mais Info");
            maisInfoButton.addActionListener(event -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String bookTitle = (String) table.getValueAt(selectedRow, 0);
                    JFrame bookInfoFrame = new JFrame("Informações do Livro");
                    bookInfoFrame.setSize(300, 200);
                    JLabel bookInfoLabel = new JLabel("Informações do Livro: " + bookTitle, SwingConstants.CENTER);
                    bookInfoFrame.add(bookInfoLabel);
                    bookInfoFrame.setVisible(true);
                }
            });
            subgenerosPage.add(maisInfoButton, BorderLayout.SOUTH);
        });

        subgenerosPage.add(selectButton, BorderLayout.SOUTH);

        mainPanel.add(subgenerosPage, "Subgêneros");
    }

    private void addGeralPage() {
        JPanel geralPage = new JPanel(new BorderLayout());
        String[] columnNames = {"Título", "Requisições", "Mais Info"};
        Object[][] data = {
                {"Livro A", "100", "Mais Info"},
                {"Livro B", "90", "Mais Info"}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        geralPage.add(scrollPane, BorderLayout.CENTER);

        JButton maisInfoButton = new JButton("Mais Info");
        maisInfoButton.addActionListener(event -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String bookTitle = (String) table.getValueAt(selectedRow, 0);
                JFrame bookInfoFrame = new JFrame("Informações do Livro");
                bookInfoFrame.setSize(300, 200);
                JLabel bookInfoLabel = new JLabel("Informações do Livro: " + bookTitle, SwingConstants.CENTER);
                bookInfoFrame.add(bookInfoLabel);
                bookInfoFrame.setVisible(true);
            }
        });
        geralPage.add(maisInfoButton, BorderLayout.SOUTH);

        mainPanel.add(geralPage, "Geral");
    }
}
