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

    public Client (String nom, String mail, String motDePasse){
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.panier = new Panier();
        this.categorie = ClientSimple.getInstance();
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
        //todo retirer le instanceof
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
//todo expliquer pourquoi c'est fait comme ça
    public void connexion(String mail, String motDePasse, Categorie categorie){
        if(this.mail.equals(mail) && this.motDePasse.equals(motDePasse)){
            this.categorie = categorie.connexion(); //si bd pour check -> this.categorie = new <Categorie lue dans la BD>.connexion();
        }
    }

    public void deconnexion(){
        categorie = categorie.deconnexion();
    }

    public void payer(){
        //todo on calcule le prix du panier puis on applique le rabais de la categorie
    }

}
