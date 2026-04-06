import java.util.Deque;

/**
 * Représente la carte d'attaque « Nouvelle énergie ».
 *
 * Augmente le nombre de cartes en main du joueur courant
 * jusqu'à 7, puis lui donne autant de points d'expérience
 * qu'il y a de cartes de riposte déjà jouées.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */

public class NouvelleEnergie extends CarteAttaque {
    public NouvelleEnergie(int idJoueur) {
        super("NouvelleEnergie", idJoueur);
    }

    /**
     * Construit une carte « Nouvelle énergie »
     * Augmente de 2 points d'attaque ceux du joueur courant
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.a = jc.a + 2;
    }

    /**
     * Applique les effets de premier type pour ce type précis de carte d'Attaque
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Aucun effet
    }
}