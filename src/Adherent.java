/**
 * Classe Adherent.
 * Une {@link Categorie} de {@link Client}.
 */
public class Adherent extends Categorie {

    public Adherent(){}

    private static Adherent instance = null;

    public static Adherent getInstance(){
        if(instance == null){
            instance = new Adherent();
        }
        return instance;
    }

    /**
     * Change un {@link Adherent} en {@link ClientSimple}.
     */
    public Categorie deconnexion(){
        return ClientSimple.getInstance();
    }
    public Categorie connexion(){
        return Adherent.getInstance();
    }

    public double getRabais(Client client){
        double rabais = client.getSesCartes().get(0).getRabais();
        CarteDeFidelite c = client.getSesCartes().get(0);
        for(CarteDeFidelite carte : client.getSesCartes()){
            if (carte.getRabais() > rabais){
                rabais = carte.getRabais();
                c = carte;
            }
        }
        c.reinitialisePoints();

        return rabais;
    }

}
