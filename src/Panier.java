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
    //Doit regarder les réducs des produits de façon unitaire puis liste les packs puis applique les reducs de pack.
    /**
     * Calcule le prix total du {@link Panier}.
     * @return prix du panier.
     */
    public double calculDuPrix(Client client){
        float prix = 0;
        for (Produit produit : listeDesProduits){
            prix += produit.getPrix();
        }
        //calcul du rabais en fonction de la catégorie.
        return prix - prix * client.getCategorie().getRabais(client);
    }

    public void ajouterListeAuPanier(ArrayList<Produit> listeDeProduits){
        for(Produit produit : listeDeProduits){
            this.ajouterAuPanier(produit);
        }
    }

    public void ajouterAuPanier(Produit produit){
        listeDesProduits.add(produit);
    }

}
