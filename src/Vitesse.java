import java.util.Deque;

public class Vitesse extends CarteRiposte {
    public Vitesse(int idJoueur) {
        super("Vitesse", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    @Override
    public void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // La carte au sommet est doublée
        if (!pile.isEmpty()) {
            pile.push(pile.peek());
        }
    }
}