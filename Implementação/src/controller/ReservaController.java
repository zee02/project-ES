package controller;

import model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas = new ArrayList<>();

    public String adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        return "Reserva do Livro confirmada";
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public List<Reserva> listarReservasPorSocio(String idSocio) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getIdSocio().equals(idSocio)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }
}
