/**
 * Classe CarteDeFidelite.
 */
public class CarteDeFidelite {

    private static int identifiantCompteur = 0;
    private int identifiant, nombreDePoints;
    private float rabais;

    public CarteDeFidelite(){
        this.identifiant = ++ identifiantCompteur;
        this.nombreDePoints = 0;
        this.rabais = 0;
    }

    public int getNombreDePoints(){
        return this.nombreDePoints;
    }
    public int getIdentifiant(){
        return this.identifiant;
    }

    public float getRabais() {
        return rabais;
    }

    public void ajouterDesPoints(int nombreDePoints){
        this.nombreDePoints += nombreDePoints;
        this.calculRabais();
    }

    public void reinitialisePoints(){
        this.nombreDePoints = 0;
        this.calculRabais();
    }

    private void calculRabais(){
        if(nombreDePoints < 20){
            rabais = 0;
        }
        if(20 <= nombreDePoints && nombreDePoints < 40){
            rabais = 5;
        }
        if(40 <= nombreDePoints && nombreDePoints < 60){
            rabais = 10;
        }
        if(60 <= nombreDePoints && nombreDePoints < 80){
            rabais = 15;
        }
        if(80 <= nombreDePoints && nombreDePoints < 100){
            rabais = 20;
        }
        if(100 <= nombreDePoints){
            rabais = 25;
        }
    }
}
