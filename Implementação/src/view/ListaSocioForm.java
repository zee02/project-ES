package view;

import controller.SocioController;
import model.Socio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaSocioForm extends JFrame {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton visualizarButton;
    private SocioController socioController;

    public ListaSocioForm() {
        socioController = SocioController.getInstance();

        setTitle("Lista de Sócios");
        panel = new JPanel(new BorderLayout());

        // Definindo colunas da tabela
        String[] columnNames = {"ID", "Nome", "NIF/CC", "Telefone", "Tipo"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar apenas uma linha

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        visualizarButton = new JButton("Visualizar");
        panel.add(visualizarButton, BorderLayout.SOUTH);

        add(panel);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Preenche a tabela com os sócios
        loadSocios();

        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int socioId = (int) tableModel.getValueAt(selectedRow, 0);
                    Socio socio = socioController.getSocioById(socioId);
                    if (socio != null) {
                        new VisualizarSocioForm(socio);
                    }
                }
            }
        });

        setVisible(true);
    }

    private void loadSocios() {
        List<Socio> socios = socioController.getAllSocios();
        tableModel.setRowCount(0); // Limpa a tabela antes de carregar os sócios
        for (Socio socio : socios) {
            Object[] row = {
                    socio.getId(),
                    socio.getNome(),
                    socio.getNifCc(),
                    socio.getTelefone(),
                    socio.getTipoSocio()
            };
            tableModel.addRow(row);
        }
    }
}
