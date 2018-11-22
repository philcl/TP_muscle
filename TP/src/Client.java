/**
 * Classe Client.
 */
public class Client {

    private String nom, mail, motDePasse;
    private Categorie categorie;
    private Panier panier;

    public Client (){
        this("","","", new ClientSimple());
    }

    public Client (String nom, String mail, String motDePasse, Categorie categorie){
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.categorie = categorie;
        this.panier = new Panier();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Panier getPanier(){
        return this.panier;
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

}
