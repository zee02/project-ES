package controller;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroController {
    private List<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<>();
        inicializarLivros();
    }

    private void inicializarLivros() {
        livros.add(new Livro("1", "Piratas", "Novo"));
        livros.add(new Livro("2", "Tesouro", "Novo"));
        livros.add(new Livro("3", "Ilha Misteriosa", "Usado"));
    }

    public void gerenciarEstadoLivro(String idLivro, String estado) {
        Livro livro = encontrarLivroPorId(idLivro);
        if (livro != null) {
            livro.setEstado(estado);
        }
    }

    public void restaurarLivro(String idLivro) {
        Livro livro = encontrarLivroPorId(idLivro);
        if (livro != null) {
            livro.setEstado("Disponível");
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    private Livro encontrarLivroPorId(String idLivro) {
        for (Livro livro : livros) {
            if (livro.getId().equals(idLivro)) {
                return livro;
            }
        }
        return null;
    }
}
