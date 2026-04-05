import java.util.Deque;

public class PetitVoleur extends CarteAttaque {
    public PetitVoleur(int idJoueur) {
        super("PetitVoleur", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Ja.m = max(0, Ja.m - 3)
        ja.m = Math.max(0, ja.m - 3);
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += 1;
    }
}