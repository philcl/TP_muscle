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
    /*Parcours de la liste de produit pour lister les offres (suppression des doublons a l'aide de l'identifiant)
    * Recherche des packs de produits et suppression des offres incompletes
    * Calcul du prix pour chaque produit pour chaque offre (pas de packs) + choix de l'offre la plus avantageuse en cas d'offre double
    * Calcul du prix total de chaque pack et comparaison avec la somme des produits unitaire puis choix de l'offre la plus avantageuse
    * Calcul d prix final*/
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
