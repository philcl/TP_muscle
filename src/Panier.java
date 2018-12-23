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

    private void retraitDesOffres(HashMap<Integer, Offre> hm, ArrayList<Offre> ar){
        for(Offre of : ar){
            hm.remove(of.getIdentifiant(), of);
        }
    }

    /**
 * Calcule le prix total du {@link Panier} et ajout des points de fidelite dans la {@link CarteDeFidelite} si le client est identifie comme Adherent.
     * @return prix du panier.
     */
    public double calculDuPrix(Client client){
        double prix = 0;
        HashMap<Integer, Offre> listeDesOffresUnitaires = new HashMap<>();
        HashMap<Integer, Offre> listeDesPacks = new HashMap<>();
        HashMap<Integer, Offre> offresUnitairesRejetees = new HashMap<>();
        ArrayList<Offre> offresTMP = new ArrayList<>();
        ArrayList<Offre> offresTMP2 = new ArrayList<>();

        boolean loop = true;
        boolean packOverlap = false;

        //remplissage de la liste des offres
        for (Produit produit : listeDesProduits){
            if (!produit.getOffres().isEmpty()) {
                System.out.println("offre non empty");
                for (Offre offre : produit.getOffres()) {
                    if(offre.getSesProduits().size() == 1) {
                        System.out.println(offre.getTaux() + "son Taux");
                        listeDesOffresUnitaires.put(offre.getIdentifiant(), offre);
                    }
                    else if (offre.getSesProduits().size() > 1){
                        listeDesPacks.put(offre.getIdentifiant(), offre);
                    }
                }
            }
        }


        //retrait des offres incompletes
        if (!listeDesPacks.isEmpty()){
            for (Offre offre : listeDesPacks.values()){
                for (Produit produit1 : offre.getSesProduits()){
                    if (!listeDesProduits.contains(produit1)){
                        //on ne peut pas retirer les offres de la collection si on itere sur celle ci, on cree donc une liste tampon
                        offresTMP.add(offre);
                    }
                }
            }
            //on retire les offres incorrectes a la fin de l'iteration
            retraitDesOffres(listeDesPacks, offresTMP);
            offresTMP.clear();
        }

        //comparaison des offres unitaires sur un même produit
        for(Offre offre1 : listeDesOffresUnitaires.values()){
            for (Offre offre2 : listeDesOffresUnitaires.values()){
                //deux offres concernant le meme produit
                if (!offre1.getSesProduits().equals(offre2.getSesProduits())){
                    //on supprime la moins avantageuse
                    if (offre1.argentGagne() <= offre2.argentGagne()){
                        offresTMP.add(offre1);
                    }
                    else{
                        offresTMP.add(offre2);
                    }
                }
            }
        }
        retraitDesOffres(listeDesOffresUnitaires, offresTMP);
        offresTMP.clear();

        do {
            loop = false;
            //comparaison des offres unitaires et des packs
            for (Offre offre1 : listeDesPacks.values()) {
                for (Offre offre2 : listeDesOffresUnitaires.values()) {
                    if (offre1.getSesProduits().contains(offre2.getSesProduits().get(0))) {
                        //on supprime la moins avantageuse
                        if (offre1.argentGagne() <= offre2.argentGagne()) {
                            offresTMP.add(offre1);
                        } else {
                            //on garde en memoire l'offre unitaire rejetee dans le cas ou le pack soit rejete plus tard
                            offresUnitairesRejetees.put(offre2.getIdentifiant(), offre2);
                            offresTMP2.add(offre2);
                        }
                    }
                }
            }
            retraitDesOffres(listeDesPacks, offresTMP);
            retraitDesOffres(listeDesOffresUnitaires, offresTMP2);
            offresTMP.clear();
            offresTMP2.clear();

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
                                    listeDesOffresUnitaires.put(offre.getIdentifiant(), offre);
                                    offresTMP.add(offre);
                                }
                            }
                            retraitDesOffres(offresUnitairesRejetees, offresTMP);
                            offresTMP.clear();
                            listeDesPacks.remove(offre1.getIdentifiant(), offre1);
                        }
                        else {
                            for(Offre offre : offresUnitairesRejetees.values()){
                                if (offre2.getSesProduits().contains(offre.getSesProduits().get(0))){
                                    listeDesOffresUnitaires.put(offre.getIdentifiant(), offre);
                                    offresTMP.add(offre);
                                }
                            }
                            retraitDesOffres(offresUnitairesRejetees, offresTMP);
                            offresTMP.clear();
                            listeDesPacks.remove(offre2.getIdentifiant(), offre2);
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
        }

        //prix apres reductions unitaires
        for(Offre of : listeDesOffresUnitaires.values()){
            prix -= of.argentGagne();
        }

        //prix apres reductions de packs
        for(Offre of : listeDesPacks.values()){
            prix -= of.argentGagne();
        }

        //calcul du rabais en fonction de la catégorie.
        prix = prix - prix * client.getCategorie().getRabais(client);

        //ajout des points de fidelite
        for (Produit produit : listeDesProduits){
            if(client.getCategorie().equals(Adherent.getInstance())){
                client.ajoutPointsFidelite(produit.getPointsFidelite());
            }
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

}
