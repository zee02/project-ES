package controller;

import model.Emprestimo;
import model.Livro;
import model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmprestimoController {
    private static EmprestimoController instance;
    private List<Emprestimo> emprestimos;
    private List<Livro> livros;

    private EmprestimoController() {
        emprestimos = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public static EmprestimoController getInstance() {
        if (instance == null) {
            instance = new EmprestimoController();
        }
        return instance;
    }

    public boolean addLivro(Livro livro) {
        return livros.add(livro);
    }

    public Livro getLivroById(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public boolean verificarIdSocio(int idSocio) {
        SocioController socioController = SocioController.getInstance();
        return socioController.getSocioById(idSocio) != null;
    }

    public boolean verificarIdLivro(int idLivro) {
        return getLivroById(idLivro) != null;
    }

    public boolean socioComLimiteUltrapassado(int idSocio) {
        // Supondo que um sócio pode ter no máximo 3 empréstimos
        long count = emprestimos.stream().filter(e -> idSocio == idSocio).count();
        return count >= 3;
    }

    public boolean socioComMultaPendente(int idSocio) {
        // Implementação de exemplo, supondo que não há multas pendentes
        // Isso deve ser implementado de acordo com a lógica de multas do seu sistema
        return false;
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public boolean registrarDevolucao(int idSocio, int idLivro) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.getIdSocio() == idSocio && emprestimo.getIdLivro() == idLivro) {
                iterator.remove();
                return true;
            }
        }
        return false; // Retorna false se o empréstimo não foi encontrado e removido
    }

    public String obterDataAtual() {
        return LocalDate.now().toString();
    }
}
