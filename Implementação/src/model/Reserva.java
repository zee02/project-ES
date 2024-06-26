// model/Reserva.java
package model;

public class Reserva {
    private Livro livro;
    private int socioId;

    private String funcionario;

    public Reserva(Livro livro, int socioId, String funcionario) {
        this.livro = livro;
        this.socioId = socioId;
        this.funcionario = funcionario;

    }

    public Livro getLivro() {
        return livro;
    }

    public int getSocioId() {
        return socioId;
    }


    public String getFuncionario() {
        return funcionario;
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getAutor() + ", Sócio ID: " + socioId + ", Funcionário: " + funcionario;
    }
}
