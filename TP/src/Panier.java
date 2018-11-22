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

    public void ajouterListeAuPanier(ArrayList<Produit> listeDeProduits){
        for(Produit produit : listeDeProduits){
            this.ajouterAuPanier(produit);
        }
    }

    public void ajouterAuPanier(Produit produit){
        listeDesProduits.add(produit);
    }

    public void retirerDuPanier(Produit produit){
        if(listeDesProduits.contains(produit)) {
            listeDesProduits.remove(produit);
        }
        else{
            System.out.println("Le produit n'est pas dans la liste.");
        }
    }
}
