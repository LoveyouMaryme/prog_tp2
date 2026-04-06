import java.util.Deque;


/**
 * Représente la carte d'attaque « Petit Voleur ».
 *
 * Diminue le nombre de cartes en main du joueur adverse
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class PetitVoleur extends CarteAttaque {
    public PetitVoleur(int idJoueur) {
        super("PetitVoleur", idJoueur);
    }


    /**
     * Applique les effets de deuxième type :
     * augmente de 1 le nombre de points d'expérience
     * du joueur courant.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Ja.m = max(0, Ja.m - 3)
        ja.m = Math.max(0, ja.m - 3);
    }

    /**
     * Applique les effets de premier type :
     * Augmente le nombre d'expériences du joueur ciblé d'un point
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        joueurs[this.idJoueur].e += 1;
    }
}