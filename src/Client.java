import java.util.ArrayList;

/**
 * Classe Client.
 */
public class Client {

    private String nom, mail, motDePasse;
    private Categorie categorie;
    private Panier panier;
    private ArrayList<CarteDeFidelite> sesCartes;

    public Client (){
        this("","","", ClientSimple.getInstance());
    }

    public Client (String nom, String mail, String motDePasse, Categorie categorie){
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.categorie = categorie;
        this.panier = new Panier();
        this.sesCartes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Panier getPanier(){
        return this.panier;
    }

    public ArrayList<CarteDeFidelite> getSesCartes(){
        return this.sesCartes;
    }

    public void ajouterUneCarte(CarteDeFidelite carteDeFidelite){
        //todo retirer le instanceof (mettre une Exception)
        if (categorie instanceof Adherent){
            sesCartes.add(carteDeFidelite);
        }
        else{
            System.out.println("Ce client n'est pas adhérent.");
        }
    }

    public void changerMotDePasse(String ancienMotDePasse, String nouveauMotDePasse){
        if(this.motDePasse.equals(ancienMotDePasse)){
            this.motDePasse = nouveauMotDePasse;
        }
        else{
            System.out.println("Mot de passe erroné\n");
        }
    }

    public boolean checkPassword(String motDePasse){
        return this.motDePasse.equals(motDePasse);
    }

    public void connexion(String nom, String mail, String motDePasse){
        this.categorie = BaseDeDonnee.getInstance().compareClient(mail, motDePasse);
    }

    public void deconnexion(){
        categorie = ClientSimple.getInstance();
    }

    public double payer(){
        double res = panier.calculDuPrix(this);
        panier.getListeDesProduits().clear();
        return res;
    }

}
