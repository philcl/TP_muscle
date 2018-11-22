/**
 * Classe abstraite Produit.
 */
public abstract class Produit {

    protected String titre;
    protected float prix;

    public Produit(){
        this(-1, "");
    }
    public Produit(float prix, String titre){
        this.prix = prix;
        this.titre = titre;
    }

    public float getPrix() {
        return prix;
    }
    public String getTitre(){
        return titre;
    }
}
