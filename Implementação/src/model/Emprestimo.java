package model;

public class Emprestimo {
    private int idSocio;
    private int idLivro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean devolvido;

    public Emprestimo(int idSocio, int idLivro, String dataEmprestimo) {
        this.idSocio = idSocio;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.devolvido = false; // Por padrão, o empréstimo não está devolvido quando criado
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.devolvido = true; // Marca o empréstimo como devolvido quando a data de devolução é definida
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
