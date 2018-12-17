public class ObservateurClient extends Superviseur {
    public ObservateurClient(){

    }

    @Override
    public void notify(Object o) {
        Client c = (Client)o;
        if(c.getPanier().calculDuPrix(c) > 100)
            System.out.println();


    }
}
