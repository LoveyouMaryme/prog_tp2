import java.util.Deque;

/**
 * Représente la carte de riposte « Esquive »
 *
 * Ajoute 1 au compteur de riposte et retire la carte au sommet de la pile.
 */
public class Esquive extends CarteRiposte {

    /**
     * Construit une carte « Esquive »
     * @param idJoueur ID du joueur qui l'utilise
     */
    public Esquive(int idJoueur) {
        super("Esquive", idJoueur);
    }

    /**
     * Applique les effets de type 1 de la carte Esquive
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    /**
     * Applique les effets de deuxième type spécifiques à Esquive :
     * Retire la carte au sommet du paquet de cartes jouées
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        if (!pile.isEmpty()) {
            pile.pop();
        }
    }
}