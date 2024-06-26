package controller;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroController {
    private List<Livro> livros;
    private static LivroController instance;

    public LivroController() {
        this.livros = new ArrayList<>();
        inicializarLivros();
    }

    private void inicializarLivros() {
        livros.add(new Livro(1, "Piratas", "Novo","Fernando",2));
        livros.add(new Livro(2, "Tesouro", "Novo","Raul",1));
        livros.add(new Livro(3, "Ilha Misteriosa", "Usado","Roberto",0));
    }

    public void gerenciarEstadoLivro(int idLivro, String estado) {
        Livro livro = encontrarLivroPorId(idLivro);
        if (livro != null) {
            livro.setEstado(estado);
        }
    }

    public boolean restaurarLivro(int idLivro) {
        Livro livro = encontrarLivroPorId(idLivro);
        if (livro != null) {
            livro.setEstado("Restauração em andamento");
            return true;
        }
        return false;
    }

    public static LivroController getInstance() {
        if (instance == null) {
            instance = new LivroController();
        }
        return instance;
    }


    public List<Livro> getLivros() {
        return livros;
    }

    private Livro encontrarLivroPorId(int idLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == (idLivro)) {
                return livro;
            }
        }
        return null;
    }
}
