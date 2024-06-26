package view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestaoPagamentosMultas extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable table;
    private Object[][] data;

    public GestaoPagamentosMultas() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addGestaoPagamentosMultasPage();

        add(mainPanel);
        setTitle("Gestão de Pagamentos e Multas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addGestaoPagamentosMultasPage() {
        JPanel gestaoPagamentosMultasPage = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Sócio", "Data", "Status", "Quantia", "Tipo", "Mais Info"};

        data = new Object[][]{
                {"1", "Sócio A", "01/06/2023", "Pendente", "50€", "Multa", "Mais Info"},
                {"2", "Sócio B", "02/06/2023", "Pendente", "30€", "Pagamento", "Mais Info"},
                {"3", "Sócio C", "03/06/2023", "Pago", "20€", "Multa", "Mais Info"}
        };

        table = new JTable(data, columnNames);
        table.getColumn("Mais Info").setCellRenderer((TableCellRenderer) new ButtonRenderer());
        table.getColumn("Mais Info").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        gestaoPagamentosMultasPage.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(gestaoPagamentosMultasPage, "Gestão de Pagamentos e Multas");
        cardLayout.show(mainPanel, "Gestão de Pagamentos e Multas");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestaoPagamentosMultas frame = new GestaoPagamentosMultas();
            frame.setVisible(true);
        });
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            selectedRow = row;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem notifyItem = new JMenuItem("Notificar");
                JMenuItem cancelItem = new JMenuItem("Anular");
                JMenuItem payItem = new JMenuItem("Pagar");

                notifyItem.addActionListener(e -> JOptionPane.showMessageDialog(button, "Notificado com sucesso"));
                cancelItem.addActionListener(e -> {
                    data[selectedRow][3] = "Anulado";
                    table.repaint();
                });
                payItem.addActionListener(e -> showPaymentDetailsDialog(selectedRow));

                popupMenu.add(notifyItem);
                popupMenu.add(cancelItem);
                popupMenu.add(payItem);

                popupMenu.show(button, button.getWidth() / 2, button.getHeight() / 2);
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private void showPaymentDetailsDialog(int row) {
        JDialog paymentDialog = new JDialog(this, "Detalhes do Pagamento", true);
        paymentDialog.setSize(400, 300);
        paymentDialog.setLayout(new GridLayout(6, 2));

        paymentDialog.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField((String) data[row][1]);
        paymentDialog.add(nomeField);

        paymentDialog.add(new JLabel("Método de Pagamento:"));
        String[] methods = {"Dinheiro", "Cartão"};
        JComboBox<String> methodBox = new JComboBox<>(methods);
        paymentDialog.add(methodBox);

        paymentDialog.add(new JLabel("Data de Pagamento:"));
        JTextField dateField = new JTextField((String) data[row][2]);
        paymentDialog.add(dateField);

        paymentDialog.add(new JLabel("NIF:"));
        JTextField nifField = new JTextField();
        paymentDialog.add(nifField);

        paymentDialog.add(new JLabel("Estado:"));
        JTextField statusField = new JTextField((String) data[row][3]);
        paymentDialog.add(statusField);

        JButton submitButton = new JButton("Submeter");
        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(paymentDialog, "Pagamento submetido com sucesso");
            data[row][3] = "Pago";
            table.repaint();
            paymentDialog.dispose();
        });
        paymentDialog.add(submitButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> paymentDialog.dispose());
        paymentDialog.add(cancelButton);

        paymentDialog.setLocationRelativeTo(this);
        paymentDialog.setVisible(true);
    }
}
