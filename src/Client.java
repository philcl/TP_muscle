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
        //todo mettre une exception
        if (categorie == Adherent.getInstance()){
            sesCartes.add(carteDeFidelite);
        }
        else{
            System.out.println("Ce client n'est pas adhérent.");
        }
    }

    public void ajoutPointsFidelite(int nombreDePoints){
        int nbPts = nombreDePoints;
        while (nbPts > 0){
            for (CarteDeFidelite cf : sesCartes){
                nbPts = cf.ajouterDesPoints(nbPts);
                if(nbPts == 0) break;
            }
            if(nbPts>0){ //toutes les cartes sont pleines
                sesCartes.add(new CarteDeFidelite());
            }
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
        try {
            this.categorie = BaseDeDonnee.getInstance().compareClient(mail, motDePasse);
        }
        catch (CategorieException e) {
            e.getMessage();
        }
    }

    public void deconnexion(){
        categorie = ClientSimple.getInstance();
    }

    public double payer() {
        try {
            double res = panier.calculDuPrix(this);
            panier.getListeDesProduits().clear();
            return res;
        }
        catch(PrixException e) {
            System.err.println("Le prix est négatif");
        }
        return 0;
    }

}
