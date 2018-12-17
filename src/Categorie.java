/**
 * Classe abstraite {@link Categorie}.
 * Représente les différentes catégories de {@link Client}.
 */
public abstract class Categorie {

    public abstract double getRabais(Client client);

    @Override
    public abstract boolean equals(Object o);
}
