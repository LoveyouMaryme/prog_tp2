import java.util.Deque;

/**
 * Implémente la carte CalmeAvantLaTempete.
 */
public class CalmeAvantLaTempete extends CarteAttaque {

    public CalmeAvantLaTempete(int idJoueur) {
        super("CalmeAvantLaTempete", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = 0;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += 3;
    }
}