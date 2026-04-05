import java.util.Deque;

public class Illumination extends CarteAttaque {

    public Illumination(int idJoueur) {
        super("Illumination", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = Math.max(jc.m, 7);
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += nbRiposte[0];
    }
}