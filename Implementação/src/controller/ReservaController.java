package controller;

import model.Reserva;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ReservaController {
    private static ReservaController instance;
    private List<Reserva> reservas;

    private ReservaController() {
        reservas = new ArrayList<>();
    }

    public static ReservaController getInstance() {
        if (instance == null) {
            instance = new ReservaController();
        }
        return instance;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva adicionada: " + reserva);
    }

    public List<Reserva> getTodasReservas() {
        return reservas;
    }

    public List<Reserva> getReservasBySocioId(int socioId) {
        List<Reserva> reservasDoSocio = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getSocioId() == socioId) {
                reservasDoSocio.add(reserva);
            }
        }
        return reservasDoSocio;
    }

    public List<Reserva> getReservasByLivroId(int livroId) {
        List<Reserva> result = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().getId() == livroId) {
                result.add(reserva);
            }
        }
        return result;
    }


    public void removerReserva(Reserva reserva) {
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva r = iterator.next();
            if (r.equals(reserva)) {
                iterator.remove();
                return;
            }
        }
    }

}
