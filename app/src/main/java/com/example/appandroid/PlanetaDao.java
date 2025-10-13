package com.example.appandroid;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> arrayListPlanetas;

    public PlanetaDao() {
        arrayListPlanetas = new ArrayList<>();
        arrayListPlanetas.add(new Planeta("Mercúrio", R.drawable.mercury));
        arrayListPlanetas.add(new Planeta("Vênus", R.drawable.venus));
        arrayListPlanetas.add(new Planeta("Terra", R.drawable.earth));
        arrayListPlanetas.add(new Planeta("Marte", R.drawable.mars));
        arrayListPlanetas.add(new Planeta("Júpiter", R.drawable.jupter));
        arrayListPlanetas.add(new Planeta("Saturno", R.drawable.saturn));
        arrayListPlanetas.add(new Planeta("Urano", R.drawable.uranus));
        arrayListPlanetas.add(new Planeta("Netuno", R.drawable.neptune));
    }

    public ArrayList<Planeta> getPlanetas() {
        return arrayListPlanetas;
    }

    public void addPlaneta(Planeta planeta) {
        arrayListPlanetas.add(planeta);
    }
}
