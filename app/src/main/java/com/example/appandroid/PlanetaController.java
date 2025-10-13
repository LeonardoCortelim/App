package com.example.appandroid;

import java.util.ArrayList;

public class PlanetaController {
    PlanetaDao planetaDAO;

    public PlanetaController() {
        planetaDAO = new PlanetaDao();
    }

    public void addPlaneta(Planeta planeta) {
        // Aqui você pode adicionar regras de negócio, validações etc.
        planetaDAO.addPlaneta(planeta);
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Planeta planeta : planetaDAO.getPlanetas()) {
            nomes.add(planeta.nome);
        }
        return nomes;
    }
}
