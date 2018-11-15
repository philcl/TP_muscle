import java.util.ArrayList;

/**
 * Classe Panier.
 */
public class Panier {

    private ArrayList<Produit> listeDesProduits;

    public Panier(){
        listeDesProduits = new ArrayList<>();
    }

    public ArrayList<Produit> getListeDesProduits() {
        return listeDesProduits;
    }

    //todo améliorer pour prendre les offres en compte.

    /**
     * Calcule le prix total du {@link Panier}.
     * @return prix du panier.
     */
    public float calculDuPrix(){
        float prix = 0;
        for (Produit produit : listeDesProduits){
            prix += produit.getPrix();
        }
        return prix;
    }
}
