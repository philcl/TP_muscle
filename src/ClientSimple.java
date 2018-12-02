/**
 * Classe ClientSimple.
 * Une {@link Categorie} de {@link Client}.
 */
public class ClientSimple extends Categorie {

    public ClientSimple(){

    }

    private static ClientSimple instance = null;

    public static ClientSimple getInstance(){
        if(instance == null){
            instance = new ClientSimple();
        }
        return instance;
    }

    /**
     * Change un {@link ClientSimple} en {@link Adherent} ou en {@link MembreDuPersonnel}.
     */
    public Categorie connexion(){
        return ClientSimple.getInstance();
    }
    public Categorie deconnexion(){
        return ClientSimple.getInstance();
    }

    public double getRabais(Client client){
        return 0;
    }
}
