import java.util.Deque;

public class Trance extends CarteAttaque {
    private int n; // Le nombre d'unités de transe (0 à 4)

    public Trance(int idJoueur, int n) {
        super("Trance", idJoueur);
        this.n = n;
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > n && jc.a > 0;
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = jc.m - n;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Aucun effet
    }
}