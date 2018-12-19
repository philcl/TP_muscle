import java.util.ArrayList;

/**
 * Classe Offre.
 */
public class Offre {

    //todo identifiant plus utilise, a voir si il est utile
    private static int identifiantCompteur = 0;
    private double taux;
    private ArrayList<Produit> sesProduits;
    private int identifiant;
    private ObservateurOffre obs;

    public Offre(ObservateurOffre s){
        identifiant = identifiantCompteur;
        identifiantCompteur++;
        taux = 0;
        sesProduits = new ArrayList<>();
        obs = s;
        obs.notify(this);
    }

    public Offre(double taux, ObservateurOffre sup) throws OffreException {
        this(sup);
        if(taux >= 1) throw new OffreException();
        else this.taux = taux;
    }

    public void addProduits(Produit prod) {
        sesProduits.add(prod);
    }

    public ArrayList<? extends Produit> getSesProduits() {
        return sesProduits;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public double getTaux() {
        return taux;
    }

    public double argentGagne() {
        double res = 0;
        if(!sesProduits.isEmpty()){
            for(Produit produit : sesProduits){
                res += produit.getPrix() * this.taux;
            }
            return res;
        }
        else return 0;
    }
}
