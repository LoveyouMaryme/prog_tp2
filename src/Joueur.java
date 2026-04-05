public class Joueur {

    private int id;
    //cartes en main
    public int m = 5;
    //nbr permis d'attaques
    public int a = 1;
    //dommage reçu
    public int d = 0;
    //points d'exp
    public int e = 0;

    public Joueur(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
