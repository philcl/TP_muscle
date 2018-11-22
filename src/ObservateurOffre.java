import java.util.ArrayList;

public class ObservateurOffre  extends Superviseur{

    public ObservateurOffre()  {

    }

    public void notify(Offre o) {
        ArrayList<? extends Produit> sesProduits = o.getSesProduits();

        for (Produit p: sesProduits) {
            p.sesOffres.add(o);
        }
    }
}
