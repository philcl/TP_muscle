import java.util.ArrayList;

/**
 * Classe Offre.
 */
public class Offre {

    private static int identifiantCompteur = 0;
    private float taux;
    private ArrayList<Produit> sesProduits;
    private int identifiant;
    private Superviseur s;

    public Offre(Superviseur sup){
        identifiant = identifiantCompteur;
        identifiantCompteur++;
        taux = 0;
        sesProduits = new ArrayList<>();
        s = sup;
        s.notify(this);
    }

    public Offre(float taux,ArrayList<? extends Produit> produits, Superviseur sup) {
        this(sup);
        this.taux = taux;
    }

    public void setProduits(Produit prod) {
        sesProduits.add(prod);
    }

    public ArrayList<? extends Produit> getSesProduits() {
        return sesProduits;
    }
}
