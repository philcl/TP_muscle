import java.util.ArrayList;

public class ObservateurOffre  extends Superviseur{

    public ObservateurOffre()  {

    }
    @Override
    public void notify(Object o) {
        Offre offre = (Offre)o;
        Produit p = offre.getSesProduits().get(offre.getSesProduits().size()-1);

        p.sesOffres.add(offre);
    }
}
