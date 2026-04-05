import java.util.Deque;

public class NouvelleEnergie extends CarteAttaque {
    public NouvelleEnergie(int idJoueur) {
        super("NouvelleEnergie", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.a = jc.a + 2;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Aucun effet
    }
}