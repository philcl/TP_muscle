import java.util.ArrayList;

/**
 * Classe Test, utilisée pour tester les classes.
 */
public class Test {

    public static void main(String[] args){
        CD CD1 = new CD(10.5, "Era", 10), CD2 = new CD(5, "Hans Zimmer", 5);
        DVD DVD1 = new DVD(20, "Avengers", 15), DVD2 = new DVD(30, "Les animaux fantastique 1", 20);
        DVD DVD3 = new DVD(20, "Star Wars", 5);
        Livre Livre1 = new Livre(50, "Harry Potter 1", 7);

        ObservateurOffre supOffre1 = new ObservateurOffre(), supOffre2 = new ObservateurOffre(), supOffre3 = new ObservateurOffre();
        Offre Offre1 = new Offre(supOffre1), Offre2 = new Offre(supOffre2), Offre3 = new Offre(supOffre3);

        Client Client1 = new Client("Felix", "felix.jacquemin@u-psud.fr", "azerty", Adherent.getInstance());
        Client Client2 = new Client("Philippe", "philippe.claude@u-psud.fr", "azerty", ClientSimple.getInstance());
        Client Client3 = new Client("Maissa", "maissa.khamis@u-psud.fr", "azerty", MembreDuPersonnel.getInstance());

        Offre1.setProduits(CD1);

        Offre2.setProduits(CD1);
        Offre2.setProduits(DVD1);
        Offre2.setProduits(Livre1);

        Offre3.setProduits(CD1);
        Offre3.setProduits(CD2);
        Offre3.setProduits(DVD3);
        Offre3.setProduits(DVD2);

        //todo creer les paniers et gerer les prix
    }
}
