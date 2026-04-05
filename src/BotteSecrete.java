import java.util.Deque;

public class BotteSecrete extends Carte {

    public BotteSecrete(int idJoueur) {
        super("BotteSecrete", idJoueur);
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > 0 && jc.a > 0;
    }

    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc);
        jc.a--; // Coûte 1pts d'attaque
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // aucun effet
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        Joueur jc = joueurs[this.idJoueur];
        Joueur ja = joueurs[1 - this.idJoueur];

        jc.d += 1;
        ja.d += 2;
        ja.e += 1;
    }
}
