public class ObservateurClient extends Superviseur {
    public ObservateurClient(){

    }

    @Override
    public void notify(Object o) {
        Client c = (Client)o;
        try {
            if(c.getPanier().calculDuPrix(c) > 100)
                System.out.println("Le panier dépasse 100 €");
        }
        catch(PrixException e) {
            System.err.println("Le prix est négatif");
        }



    }
}
