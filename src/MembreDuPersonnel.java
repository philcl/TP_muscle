/**
 * Classe MembreDuPersonnel.
 * Une {@link Categorie} de {@link Client}.
 */
public class MembreDuPersonnel extends Categorie {

    public MembreDuPersonnel(){

    }

    private static MembreDuPersonnel instance = null;

    public static MembreDuPersonnel getInstance(){
        if(instance == null){
            instance = new MembreDuPersonnel();
        }
        return instance;
    }

    public double getRabais(Client client){
        return 0.05;
    }

    @Override
    public boolean equals(Object o)
    {
        return(this == o);
    }
}
