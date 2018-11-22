/**
 * Classe MembreDuPersonnel.
 * Une {@link Categorie} de {@link Client}.
 */
public class MembreDuPersonnel extends Categorie {

    public MembreDuPersonnel(){

    }

    /**
     * Change un {@link MembreDuPersonnel} en {@link ClientSimple}.
     */
    public Categorie deconnexion(){
        return new ClientSimple();
    }
    public Categorie connexion(){
        return this;
    }
}
