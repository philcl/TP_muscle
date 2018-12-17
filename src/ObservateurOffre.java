import java.util.ArrayList;

public class ObservateurOffre  extends Superviseur{

    public ObservateurOffre()  {

    }
    @Override
    public void notify(Object o) {
        Offre offre = (Offre)o;
        ArrayList<? extends Produit> sesProduits = offre.getSesProduits();

        for (Produit p: sesProduits) {
            p.sesOffres.add(offre);
        }
    }
}
