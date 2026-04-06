import java.util.Deque;

/**
 * Représente une Carte Inspiration du jeu.
 *
 * Permet de piocher une carte supplémentaire et, en
 * deuxième type, peut donner de l'expérience si la
 * carte précédente est une attaque.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */

public class Inspiration extends CarteRiposte {

    /**
     * Construit une carte Inspiration
     *
     * @param idJoueur Id du joueur qui utilise cette carte
     */
    public Inspiration(int idJoueur) {
        super("Inspiration", idJoueur);
    }

    /**
     * Applique les effets de premier type :
     * Augmente d'un point le nombre de cartes dans les mains du joueur courant.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m++;
    }

    /**
     * Applique l'effet spécifique de deuxième type :
     * si la carte au sommet de la pile est une attaque,
     * augmente l'expérience du joueur courant de 1 point.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà rencontrées
     */
    @Override
    public void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        if (!pile.isEmpty() && pile.peek().estAttaque()) {
            joueurs[this.idJoueur].e += 1;
        }
    }
}
