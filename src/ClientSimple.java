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

    public double getRabais(Client client){
        return 0;
    }
}
