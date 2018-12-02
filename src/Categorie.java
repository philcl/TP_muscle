/**
 * Classe abstraite {@link Categorie}.
 * Représente les différentes catégories de {@link Client}.
 */
public abstract class Categorie {

    public abstract Categorie connexion();
    public abstract Categorie deconnexion();
    public abstract double getRabais(Client client);
}
