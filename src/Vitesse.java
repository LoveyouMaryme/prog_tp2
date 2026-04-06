import java.util.Deque;

/**
 * Représente une carte de type riposte « Vitesse »
 *
 * Double la carte du dessus de la pile de cartes déjà jouées
 */
public class Vitesse extends CarteRiposte {

    /**
     * Construit une carte Vitesse
     *
     * @param idJoueur Id du joueur ciblé
     */
    public Vitesse(int idJoueur) {
        super("Vitesse", idJoueur);
    }

    /**
     * Applique les effets de premier type :
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    /**
     * Applique les effets de deuxième type :
     * Double la carte au début de la pile.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // La carte au sommet est doublée
        if (!pile.isEmpty()) {
            pile.push(pile.peek());
        }
    }
}