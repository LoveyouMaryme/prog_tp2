import java.util.Deque;

public abstract class Carte {

    protected String nom;
    protected int idJoueur;

    public boolean estAttaque() { return false; }
    public boolean estDommage() { return false; }
    public boolean estRiposte() { return false; }
    public boolean estExperience() { return false; }

    public Carte(String nom, int idJoueur){
        this.nom = nom;
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return this.nom;
    }

    /** Vérifie si les conditions (m > 0, a > 0) sont remplies. */
    public abstract boolean verifier(Joueur jc, Joueur ja);

    public void appliquerDepot(Joueur jc){
        jc.m --;
    }

    public abstract void appliquerEffetType1(Joueur jc, Joueur ja);

    public abstract void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte);



}
