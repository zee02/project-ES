package controller;

import model.Socio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SocioController {
    private static SocioController instance;
    private List<Socio> socios;

    private SocioController() {
        socios = new ArrayList<>();
    }

    public static SocioController getInstance() {
        if (instance == null) {
            instance = new SocioController();
        }
        return instance;
    }

    public boolean addSocio(Socio socio) {
        return socios.add(socio);
    }

    public List<Socio> getAllSocios() {
        return new ArrayList<>(socios);
    }

    public Socio getSocioById(int id) {
        for (Socio socio : socios) {
            if (socio.getId() == id) {
                return socio;
            }
        }
        return null;
    }

    public boolean atualizarSocio(Socio socioAtualizado) {
        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (socio.getId() == socioAtualizado.getId()) {
                socios.set(i, socioAtualizado);
                return true;
            }
        }
        return false; // Retorna false se o sócio não foi encontrado e atualizado
    }

    public boolean removerSocio(int id) {
        Iterator<Socio> iterator = socios.iterator();
        while (iterator.hasNext()) {
            Socio socio = iterator.next();
            if (socio.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false; // Retorna false se o sócio não foi encontrado e removido
    }
}
