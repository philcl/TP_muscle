/**
 * Classe abstraite Produit.
 */
public abstract class Produit {

    protected String titre;
    protected float prix;

    public float getPrix() {
        return prix;
    }
    public String getTitre(){
        return titre;
    }
}
