package controller;
import model.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroController {
    private Map<String, String> estadosLivros;

    public LivroController() {
        this.estadosLivros = new HashMap<>();
    }

    public void gerenciarEstadoLivro(String idLivro, String estado) {
        estadosLivros.put(idLivro, estado);
    }

    public void restaurarLivro(String idLivro) {
        estadosLivros.remove(idLivro);
    }

    public List<String> listarEstadosLivros() {
        return new ArrayList<>(estadosLivros.values());
    }
}
