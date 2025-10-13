public  class PlanetaController {
    PlanetaDao planetaDao;

    public PlanetaController(){
        planetaDao = new PlanetaDao();
    }
    public void addPlaneta(Planeta planeta){

    }

    public ArrayList<Planeta> getPlaneta(){
        return planetaDao.getPlanetas();
    }
    public ArrayList<String> getNomePlanetas(){
        ArrayList<String> nomes = new ArrayList<String>();
        for(Planeta planeta : planetaDao.getPlanetas()){
            nomes.add(planeta.nome);
        }
    }
    return nomes;
}