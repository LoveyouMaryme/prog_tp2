import java.util.Deque;

/**
 * Représente la carte d'attaque « Illumination ».
 *
 * Augmente le nombre de cartes en main du joueur courant
 * jusqu'à 7, puis lui donne autant de points d'expérience
 * qu'il y a de cartes de riposte déjà jouées.
 */
public class Illumination extends CarteAttaque {

    /**
     * Construit une carte « Illumination »
     *
     * @param idJoueur ID du joueur qui l'utilise

     */
    public Illumination(int idJoueur) {
        super("Illumination", idJoueur);
    }

    /**
     * Applique les effets de premier type :
     * augmente jusqu'à 7 le nombre de cartes en main
     * du joueur courant.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = Math.max(jc.m, 7);
    }


    /**
     * Applique les effets de deuxième type :
     * le joueur courant gagne autant de points d'expérience
     * qu'il y a de cartes de riposte déjà jouées.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += nbRiposte[0];
    }
}