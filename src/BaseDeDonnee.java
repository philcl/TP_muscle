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
}
