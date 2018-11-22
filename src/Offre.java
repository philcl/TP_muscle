import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe Offre.
 */
public class Offre {

    private static int identifiantCompteur;
    private float taux;
    private ArrayList<? extends Produit> produits;
    private int identifiant;
    private Superviseur s;

    public Offre(Superviseur sup){
        identifiant = identifiantCompteur;
        identifiantCompteur++;
        taux = 0;
        s = sup;
        s.notify(this);
    }

    public Offre(float taux,ArrayList<? extends Produit> produits, Superviseur sup) {
        super();
        s = sup;
        s.notify(this);
        this.taux = taux;
    }

    public ArrayList<? extends Produit> getProduits() {
        return produits;
    }
}
