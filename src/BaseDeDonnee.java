import java.util.ArrayList;

public class BaseDeDonnee {

    private static BaseDeDonnee instance = null;
    private ArrayList<Client> sesClients;

    public BaseDeDonnee(){ sesClients = new ArrayList<>(); }



    public static BaseDeDonnee getInstance(){
        if(instance == null){
            instance = new BaseDeDonnee();
        }
        return instance;
    }

    public void addClient(Client c){ sesClients.add(c); }

    public Categorie compareClient(String mail, String password) throws CategorieException {
        for (Client clients : sesClients) {
            if ((clients.getMail().equals(mail)) && (clients.checkPassword(password))) {
                return clients.getCategorie();
            }
        }
        throw new CategorieException();
    }
}
