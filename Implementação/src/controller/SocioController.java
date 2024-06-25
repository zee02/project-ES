package controller;

import model.Socio;
import java.util.ArrayList;
import java.util.List;

public class SocioController {
    private List<Socio> socios = new ArrayList<>();

    public String adicionarSocio(Socio socio) {
        if (dadosValidos(socio)) {
            socios.add(socio);
            return "Novo Sócio Adicionado com sucesso";
        } else {
            return "Erro ao adicionar Novo Sócio";
        }
    }

    private boolean dadosValidos(Socio socio) {
        // Implementar validação dos dados do sócio
        return true;
    }

    public Socio pesquisarSocio(String nome) {
        for (Socio socio : socios) {
            if (socio.getNome().equals(nome)) {
                return socio;
            }
        }
        return null;
    }

    public List<Socio> listarSocios() {
        return socios;
    }

    public String editarSocio(Socio socio) {
        // Implementar lógica para editar sócio
        for (Socio s : socios) {
            if (s.getNome().equals(socio.getNome())) {
                s.setNifCc(socio.getNifCc());
                s.setTelefone(socio.getTelefone());
                s.setMorada(socio.getMorada());
                s.setEmail(socio.getEmail());
                s.setTipoNotificacao(socio.getTipoNotificacao());
                s.setFuncionario(socio.getFuncionario());
                s.setTipoSocio(socio.getTipoSocio());
                return "Sócio editado com sucesso";
            }
        }
        return "Sócio não encontrado";
    }
}
