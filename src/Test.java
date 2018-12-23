/**
 * Classe Test, utilisée pour tester les classes.
 */
public class Test {

    public static void main(String[] args){
        // init des Produits, Offres, Clients, Base de données

        CD CD1 = new CD(10.5, "Era", 10), CD2 = new CD(5, "Hans Zimmer", 5);
        DVD DVD1 = new DVD(20, "Avengers", 15), DVD2 = new DVD(30, "Les animaux fantastique 1", 20);
        DVD DVD3 = new DVD(20, "Star Wars", 5);
        Livre Livre1 = new Livre(50, "Harry Potter 1", 7);

        ObservateurOffre supOffre1 = new ObservateurOffre(), supOffre2 = new ObservateurOffre(), supOffre3 = new ObservateurOffre();
        try {
            Offre Offre1 = new Offre(0.5, supOffre1), Offre2 = new Offre(0.2, supOffre2), Offre3 = new Offre(0.1, supOffre3);

            Offre1.addProduits(CD1);

            Offre2.addProduits(CD1);
            Offre2.addProduits(DVD1);
            Offre2.addProduits(Livre1);

            Offre3.addProduits(CD1);
            Offre3.addProduits(CD2);
            Offre3.addProduits(DVD3);
            Offre3.addProduits(DVD2);
        }
        catch(OffreException e) {
            System.out.println("dans except offre");
            e.getMessage();
        }

        BaseDeDonnee bd = BaseDeDonnee.getInstance();

        Client Client1 = new Client("Felix", "felix.jacquemin@u-psud.fr", "azerty", Adherent.getInstance());
        Client Client2 = new Client("Philippe", "philippe.claude@u-psud.fr", "azerty", ClientSimple.getInstance());
        Client Client3 = new Client("Maissa", "maissa.khamis@u-psud.fr", "azerty", MembreDuPersonnel.getInstance());

        Client Client1base = new Client();
        Client Client2base = new Client();
        Client Client3base = new Client();

        bd.addClient(Client1);
        bd.addClient(Client2);
        bd.addClient(Client3);

        Client1base.connexion("Felix", "felix.jacquemin@u-psud.fr", "azerty");
        Client2base.connexion("Philippe", "philippe.claude@u-psud.fr", "azerty");
        Client3base.connexion("Maissa", "maissa.khamis@u-psud.fr", "azerty");

        //init terminé
        // Passage à l'utilisation des paniers et des paiments

        Client1base.ajouterUneCarte(new CarteDeFidelite());
        Client1base.getPanier().ajouterAuPanier(CD1);
        Client1base.getPanier().ajouterAuPanier(CD2);
        Client1base.getPanier().ajouterAuPanier(DVD2);
        System.out.println("adherent");
        System.out.println(Client1base.payer());

        Client1base.getPanier().ajouterAuPanier(CD1);
        Client1base.getPanier().ajouterAuPanier(CD2);
        Client1base.getPanier().ajouterAuPanier(DVD2);
        System.out.println("adherent avec carte de fidelite");
        System.out.println(Client1base.payer());

        Client3base.getPanier().ajouterAuPanier(CD1);
        Client3base.getPanier().ajouterAuPanier(CD2);
        Client3base.getPanier().ajouterAuPanier(DVD2);
        Client3base.getPanier().ajouterAuPanier(DVD1);
        Client3base.getPanier().ajouterAuPanier(Livre1);
        Client3base.getPanier().ajouterAuPanier(DVD3);
        System.out.println("Membre du personnel");
        System.out.println(Client3base.payer());

        Client1base.deconnexion();

        Client1base.getPanier().ajouterAuPanier(CD1);
        Client1base.getPanier().ajouterAuPanier(CD2);
        Client1base.getPanier().ajouterAuPanier(DVD2);
        System.out.println("adherent deconnecté");
        System.out.println(Client1base.payer());
    }
}
