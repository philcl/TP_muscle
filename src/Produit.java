import java.util.ArrayList;

/**
 * Classe abstraite Produit.
 */
public abstract class Produit {

    protected String titre;
    protected double prix;
    protected ArrayList<Offre> sesOffres;
    protected int pointsFidelite;

    public Produit(){
        this(-1, "", 0);
    }
    public Produit(double prix, String titre, int pointsFidelite){
        this.prix = prix;
        this.titre = titre;
        this.pointsFidelite = pointsFidelite;
        sesOffres = new ArrayList<>();
    }

    public double getPrix() {
        return prix;
    }
    public String getTitre(){
        return titre;
    }
}
