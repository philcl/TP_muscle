/**
 * Classe CarteDeFidelite.
 */
public class CarteDeFidelite {

    private static int identifiantCompteur = 0;
    private int identifiant, nombreDePoints;
    private double rabais;

    public CarteDeFidelite(){
        this.identifiant = ++ identifiantCompteur;
        this.nombreDePoints = 0;
        this.rabais = 0.00;
    }

    public int getNombreDePoints(){
        return this.nombreDePoints;
    }
    public int getIdentifiant(){
        return this.identifiant;
    }

    public double getRabais() {
        return rabais;
    }

    public int ajouterDesPoints(int nombreDePoints){
        if(this.nombreDePoints < 100) {
            int nombreManquant = 100-this.nombreDePoints;
            if(nombreDePoints <= nombreManquant) {
                this.nombreDePoints += nombreDePoints;
                this.calculRabais();
                return 0;
            }
            else {
                this.nombreDePoints = 100;
                this.calculRabais();
                return nombreDePoints-nombreManquant;
            }
        }
        else {
            return nombreDePoints;
        }
    }

    public void reinitialisePoints(){
        this.nombreDePoints = 0;
        this.calculRabais();
    }

    private void calculRabais(){
        if(nombreDePoints < 20){
            rabais = 0.00;
        }
        if(20 <= nombreDePoints && nombreDePoints < 40){
            rabais = 0.01;
        }
        if(40 <= nombreDePoints && nombreDePoints < 60){
            rabais = 0.02;
        }
        if(60 <= nombreDePoints && nombreDePoints < 80){
            rabais = 0.03;
        }
        if(80 <= nombreDePoints && nombreDePoints < 100){
            rabais = 0.04;
        }
        if(100 <= nombreDePoints){
            rabais = 0.05;
        }
    }
}
