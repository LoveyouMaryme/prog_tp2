import java.util.Deque;

public class TousPourUn extends CarteAttaque {

    public TousPourUn(int idJoueur) {
        super("TousPourUn", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = jc.m + 1;
        jc.a = jc.a + 1;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Aucun effet
    }
}