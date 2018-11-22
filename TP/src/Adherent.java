/**
 * Classe Adherent.
 * Une {@link Categorie} de {@link Client}.
 */
public class Adherent extends Categorie {

    public Adherent(){

    }

    /**
     * Change un {@link Adherent} en {@link ClientSimple}.
     */
    public Categorie deconnexion(){
        return new ClientSimple();
    }
    public Categorie connexion(){
        return this;
    }
}
