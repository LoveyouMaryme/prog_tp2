import java.util.Deque;

/**
 * Représente la carte Botte Secrète
 *
 * Coûte 1 point d'attaque au joueur courant,
 * lui inflige 1 point de dommage, inflige 2 points
 * de dommage à l'adversaire et lui donne 1 point
 * d'expérience.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */

public class BotteSecrete extends Carte {


    /**
     * Construit une carte « BotteSecrete ».
     *
     * @param idJoueur l'identifiant du joueur qui l'utilise
     */
    public BotteSecrete(int idJoueur) {
        super("BotteSecrete", idJoueur);
    }


    /**
     * Vérifie plusieurs conditions :
     * <ul>
     *   <li>le joueur courant a au moins une carte en main</li>
     *   <li>le joueur courant a assez de points d'attaque</li>
     * </ul>
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     * @return true si la carte peut être jouée, false sinon
     */
    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > 0 && jc.a > 0;
    }

    /**
     * Réduit d'un point le nombre de points d'attaque
     * restant du joueur.
     *
     * @param jc le joueur courant, celui qui joue la carte
     */
    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc);
        jc.a--; // Coûte 1pts d'attaque
    }

    /**
     * Applique les effets de premier type :
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // aucun effet
    }

    /**
     * Applique les effets de deuxième type :
     * ajoute 1 point de dommage au joueur courant,
     * 2 points de dommage à l'adversaire et
     * 1 point d'expérience à l'adversaire.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile des cartes déjà jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà rencontrées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        Joueur jc = joueurs[this.idJoueur];
        Joueur ja = joueurs[1 - this.idJoueur];

        jc.d += 1;
        ja.d += 2;
        ja.e += 1;
    }
}
