import java.util.Deque;

/**
 * Représente l'abstraction d'une Carte Inspiration du jeu.
 *
 * Permet de piocher une carte supplémentaire et, en
 * deuxième type, peut donner de l'expérience si la
 * carte précédente est une attaque.
 */

public class Inspiration extends Carte {

    /**
     * Construit une carte de type Dommage
     *
     * @param idJoueur Id du joueur qui utilise cette carte
     */
    public Inspiration(int idJoueur) {
        super("Inspiration", idJoueur);
    }

    /**
     * Vérifie plusieurs conditions :
     * <ul>
     *   <li>le joueur courant a au moins une carte en main</li>
     * </ul>
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     * @return true si la carte peut être jouée, false sinon
     */
    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > 0;
    }

    /**
     * Retire une carte jouée dans la main du joueur courant
     * @param jc joueur courant, celui qui joue la carte
     */
    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc);
    }

    /**
     * Applique les effets de premier type des cartes de type Inspiration :
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
     * Applique les effets de deuxième type des cartes de type Inspiration :
     * Augmente de un le nombre de carte riposte dans le paquet de cartes jouées
     * et si la carte du dessous est une carte d'attaque, augmente l'expérience
     * du joueur courant de 1 point
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        nbRiposte[0]++;

        //vérifie si la carte en dessous est une carte d'Attaque
        if (!pile.isEmpty() && pile.peek().estAttaque()) {
            joueurs[this.idJoueur].e += 1;
        }
    }
}
