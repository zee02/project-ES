package view;

import controller.LivroController;
import model.Livro;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListaLivrosRequisitadosForm extends JFrame {
    private int socioId;
    private LivroController livroController;

    public ListaLivrosRequisitadosForm(int socioId) {
        this.socioId = socioId;
        this.livroController = LivroController.getInstance();

        setTitle("Lista de Livros Disponíveis");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea livrosTextArea = new JTextArea(10, 40);
        livrosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(livrosTextArea);

        // Carregar a lista de todos os livros disponíveis
        List<Livro> listaLivros = livroController.getLivros();
        StringBuilder sb = new StringBuilder();
        for (Livro livro : listaLivros) {
            sb.append("Título: ").append(livro.getNome())
                    .append(" | Autor: ").append(livro.getAutor())
                    .append(" | Nº de pessoas em espera: ").append(livro.getNumeroPessoasEspera())
                    .append("\n");
        }
        livrosTextArea.setText(sb.toString());

        panel.add(new JLabel("Lista de Livros Disponíveis"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel(new GridLayout(listaLivros.size(), 1));
        for (Livro livro : listaLivros) {
            JButton novaReservaButton = new JButton("+");
            novaReservaButton.addActionListener(e -> abrirNovaReservaForm(livro));
            botoesPanel.add(novaReservaButton);
        }
        panel.add(botoesPanel, BorderLayout.EAST);

        setContentPane(panel);
        setVisible(true);
    }

    private void abrirNovaReservaForm(Livro livro) {
        NovaReservaForm novaReservaForm = new NovaReservaForm(livro,socioId);
        novaReservaForm.setVisible(true);
    }
}
