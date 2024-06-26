// ListaLivrosRequisitadosForm.java
package view;

import javax.swing.*;
import java.awt.*;

public class ListaLivrosRequisitadosForm extends JFrame {

    public ListaLivrosRequisitadosForm() {
        setTitle("Lista de Livros Requisitados");
        setSize(600, 400); // Ajustando o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea livrosTextArea = new JTextArea(10, 40);
        livrosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(livrosTextArea);

        // Aqui deveria ser carregada a lista de livros requisitados do sócio
        String listaLivros = "Livro 1\nLivro 2\nLivro 3";
        livrosTextArea.setText(listaLivros);

        JButton novaReservaButton = new JButton("+");
        novaReservaButton.addActionListener(e -> abrirNovaReservaForm());

        panel.add(new JLabel("Lista de Livros Requisitados"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(novaReservaButton, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }

    private void abrirNovaReservaForm() {
        NovaReservaForm novaReservaForm = new NovaReservaForm();
        novaReservaForm.setVisible(true);
    }

}
