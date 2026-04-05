import java.util.Deque;

public class Esquive extends CarteRiposte {
    public Esquive(int idJoueur) {
        super("Esquive", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    @Override
    public void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // dépile la carte au sommet
        if (!pile.isEmpty()) {
            pile.pop();
        }
    }
}