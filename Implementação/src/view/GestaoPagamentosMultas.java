package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestaoPagamentosMultas extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public GestaoPagamentosMultas() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addLandingPage();
        addInserirNomePage();
        addCategoriasPage();
        addGestaoPagamentosMultasPage();

        add(mainPanel);
        setTitle("Gestão de Pagamentos e Multas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addLandingPage() {
        JPanel landingPage = new JPanel(new BorderLayout());
        JButton gerirButton = new JButton("Gerir");
        gerirButton.addActionListener(e -> cardLayout.show(mainPanel, "Inserir Nome"));
        landingPage.add(gerirButton, BorderLayout.CENTER);
        mainPanel.add(landingPage, "Landing Page");
    }

    private void addInserirNomePage() {
        JPanel inserirNomePage = new JPanel(new BorderLayout());
        JTextField nomeField = new JTextField();
        JButton entrarButton = new JButton("Entrar");
        entrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            if (nome.equals("NomeExistente")) {
                cardLayout.show(mainPanel, "Categorias");
            } else {
                JOptionPane.showMessageDialog(this, "Nome não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        inserirNomePage.add(new JLabel("Inserir Nome:"), BorderLayout.NORTH);
        inserirNomePage.add(nomeField, BorderLayout.CENTER);
        inserirNomePage.add(entrarButton, BorderLayout.SOUTH);
        mainPanel.add(inserirNomePage, "Inserir Nome");
    }

    private void addCategoriasPage() {
        JPanel categoriasPage = new JPanel(new BorderLayout());
        JButton pagamentosEMultasButton = new JButton("Pagamentos e Multas");
        pagamentosEMultasButton.addActionListener(e -> cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas"));
        categoriasPage.add(pagamentosEMultasButton, BorderLayout.CENTER);
        mainPanel.add(categoriasPage, "Categorias");
    }

    private void addGestaoPagamentosMultasPage() {
        JPanel gestaoPagamentosMultasPage = new JPanel(new BorderLayout());
        JButton acoesButton = new JButton("Ações");
        acoesButton.addActionListener(e -> {
            JPopupMenu popupMenu = new JPopupMenu();

            JMenuItem anularItem = new JMenuItem("Anular");
            anularItem.addActionListener(event -> JOptionPane.showMessageDialog(mainPanel, "Multa anulada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
            popupMenu.add(anularItem);

            JMenuItem notificarItem = new JMenuItem("Notificar");
            notificarItem.addActionListener(event -> JOptionPane.showMessageDialog(mainPanel, "Notificação enviada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
            popupMenu.add(notificarItem);

            JMenuItem pagarItem = new JMenuItem("Pagar");
            pagarItem.addActionListener(event -> JOptionPane.showMessageDialog(mainPanel, "Pagamento efetuado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
            popupMenu.add(pagarItem);

            popupMenu.show(gestaoPagamentosMultasPage, gestaoPagamentosMultasPage.getWidth() / 2, gestaoPagamentosMultasPage.getHeight() / 2);
        });
        gestaoPagamentosMultasPage.add(acoesButton, BorderLayout.CENTER);
        mainPanel.add(gestaoPagamentosMultasPage, "Gestão de Pagamentos e Multas");
    }
}
