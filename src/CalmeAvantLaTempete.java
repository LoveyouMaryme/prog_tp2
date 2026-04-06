import java.util.Deque;

/**
 * Représente une carte attaque « CalmeAvantLaTempete ».
 *
 * Enlève toutes les cartes en main du joueur courant
 * lui donne 3 points d'expérience
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class CalmeAvantLaTempete extends CarteAttaque {

    /**
     * Construit une carte « CalmeAvantLaTempete ».
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public CalmeAvantLaTempete(int idJoueur) {
        super("CalmeAvantLaTempete", idJoueur);
    }


    /**
     * Applique les effets de premier type:
     * Retire toutes les cartes du joueur courant
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = 0;
    }

    /**
     * Applique les effets de deuxième type:
     *
     * Donne 3 points d'expérience au joueur ciblé
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += 3;
    }
}