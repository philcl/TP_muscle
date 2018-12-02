/**
 * Classe ClientSimple.
 * Une {@link Categorie} de {@link Client}.
 */
public class ClientSimple extends Categorie {

    public ClientSimple(){

    }

    /**
     * Change un {@link ClientSimple} en {@link Adherent} ou en {@link MembreDuPersonnel}.
     */
    public Categorie connexion(){
        return new ClientSimple();
    }
    public Categorie deconnexion(){
        return this;
    }

    public double getRabais(Client client){
        return 0;
    }
}
