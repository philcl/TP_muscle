import java.util.ArrayList;
import java.util.HashMap;

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

    //todo points fidelite
    /**
     * Calcule le prix total du {@link Panier}.
     * @return prix du panier.
     */
    public double calculDuPrix(Client client){
        double prix = 0;
        HashMap<Double, Offre> listeDesOffresUnitaires = new HashMap<>();
        HashMap<Double, Offre> listeDesPacks = new HashMap<>();
        HashMap<Double, Offre> offresUnitairesRejetees = new HashMap<>();

        boolean loop = true;
        boolean packOverlap = false;

        //remplissage de la liste des offres
        for (Produit produit : listeDesProduits){
            if (!produit.getOffres().isEmpty()) {
                System.out.println("offre non empty");
                for (Offre offre : produit.getOffres()) {
                    if(offre.getSesProduits().size() == 1) {
                        System.out.println(offre.getTaux() + "son Taux");
                        listeDesOffresUnitaires.put(offre.argentGagne(), offre);
                    }
                    else if (offre.getSesProduits().size() > 1){
                        listeDesPacks.put(offre.argentGagne(), offre);
                    }
                }
            }
        }

        //retrait des offres incompletes
        if (!listeDesPacks.isEmpty()){
            for (Offre offre : listeDesPacks.values()){
                for (Produit produit1 : offre.getSesProduits()){
                    if (!listeDesProduits.contains(produit1)){
                        listeDesPacks.remove(offre.argentGagne(), offre);
                    }
                }
            }
        }

        //comparaison des offres unitaires sur un même produit
        for(Offre offre1 : listeDesOffresUnitaires.values()){
            for (Offre offre2 : listeDesOffresUnitaires.values()){
                //deux offres concernant le meme produit
                if (offre1.getSesProduits().equals(offre2.getSesProduits())){
                    //on supprime la moins avantageuse
                    if (offre1.argentGagne() <= offre2.argentGagne()){
                        listeDesOffresUnitaires.remove(offre1.argentGagne(), offre1);
                    }
                    else{
                        listeDesOffresUnitaires.remove(offre2.argentGagne(), offre2);
                    }
                }
            }
        }

        do {
            loop = false;
            //comparaison des offres unitaires et des packs
            for (Offre offre1 : listeDesPacks.values()) {
                for (Offre offre2 : listeDesOffresUnitaires.values()) {
                    if (offre1.getSesProduits().contains(offre2.getSesProduits().get(0))) {
                        //on supprime la moins avantageuse
                        if (offre1.argentGagne() <= offre2.argentGagne()) {
                            listeDesPacks.remove(offre1.argentGagne(), offre1);
                        } else {
                            //on garde en memoire l'offre unitaire rejetee dans le cas ou le pack soit rejete plus tard
                            offresUnitairesRejetees.put(offre2.argentGagne(), offre2);
                            listeDesOffresUnitaires.remove(offre2.argentGagne(), offre2);
                        }
                    }
                }
            }

            //comparaison des packs
            for (Offre offre1 : listeDesPacks.values()){
                for (Offre offre2 : listeDesPacks.values()){
                    //si deux packs ont un élément en commun on retire le moins bon, sauf si ces packs sont les memes
                    if (!offre1.equals(offre2)){
                        for(Produit produit : offre1.getSesProduits()){
                            if (offre2.getSesProduits().contains(produit)){
                                packOverlap = true;
                                break;
                            }
                        }
                    }
                    //on supprime le pack le moins rentable et on remet a jour les offres unitaires sur les produits du pack pour les appliquer si necessaire
                    if (packOverlap){
                        loop = true; //si un pack est retire on doit refaire la comparaison entre les offres unitaires et les packs pour ne pas cumuler deux offres sur un produit par megarde
                        if (offre1.argentGagne() <= offre2.argentGagne()){
                            for(Offre offre : offresUnitairesRejetees.values()){
                                if (offre1.getSesProduits().contains(offre.getSesProduits().get(0))){
                                    listeDesOffresUnitaires.put(offre.argentGagne(), offre);
                                    offresUnitairesRejetees.remove(offre.argentGagne(), offre);
                                }
                            }
                            listeDesPacks.remove(offre1.argentGagne(), offre1);
                        }
                        else {
                            for(Offre offre : offresUnitairesRejetees.values()){
                                if (offre2.getSesProduits().contains(offre.getSesProduits().get(0))){
                                    listeDesOffresUnitaires.put(offre.argentGagne(), offre);
                                    offresUnitairesRejetees.remove(offre.argentGagne(), offre);
                                }
                            }
                            listeDesPacks.remove(offre2.argentGagne(), offre2);
                        }
                    }
                    packOverlap = false;
                }
            }
        }while (loop);

        //calcul du prix final sans le rabais de categorie
        //prix sans reductions
        for (Produit produit : listeDesProduits){
            prix += produit.getPrix();
            //todo ajout des points sur les cartes de fidelite si adherent
        }

        //prix apres reductions unitaires
        for(Double d : listeDesOffresUnitaires.keySet()){
            prix -= d;
        }

        //prix apres reductions de packs
        for(Double d : listeDesPacks.keySet()){
            prix -= d;
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
