/**
 * Classe MembreDuPersonnel.
 * Une {@link Categorie} de {@link Client}.
 */
public class MembreDuPersonnel extends Categorie {

    public MembreDuPersonnel(){

    }

    private static MembreDuPersonnel instance = null;

    public static MembreDuPersonnel getInstance(){
        if(instance == null){
            instance = new MembreDuPersonnel();
        }
        return instance;
    }

    /**
     * Change un {@link MembreDuPersonnel} en {@link ClientSimple}.
     */
    public Categorie deconnexion(){
        return ClientSimple.getInstance();
    }
    public Categorie connexion(){
        return MembreDuPersonnel.getInstance();
    }

    public double getRabais(Client client){
        return 0.05;
    }
}
