import java.util.Deque;

/**
 * Représente la carte d'attaque « Trance ».
 *
 * Permet au joueur courant d'enlever n cartes de ses mains
 * supplémentaires de sa main.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class Trance extends CarteAttaque {
    private int n; // Le nombre d'unités de trance (0 à 4)

    /**
     * Construit une carte « Trance »
     *
     * @param idJoueur ID du joueur qui l'utilise
     * @param n le nombre de cartes supplémentaires à retirer (entre 0 et 4)
     */
    public Trance(int idJoueur, int n) {
        super("Trance", idJoueur);
        this.n = n;
    }

    /**
     * Vérifie que le nombre de cartes en main
     * est plus grand que le nombre de cartes en Trance
     * et que le joueur a assez de point d'attaque
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     * @return true si la carte peut être jouée, false sinon
     */
    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        boolean valide = true;
        if (jc.m <= n) {
            this.raisonEchec = Mssg.CARTES_MAIN;
            valide = false;
        } else if (jc.a <= 0) {
            this.raisonEchec = Mssg.POINT_ATTAQUE;
            valide = false;
        }
        return valide;
    }

    /**
     * Applique les effets de premier type :
     * retire n cartes supplémentaires de la main du joueur courant.
     *
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = jc.m - n;
    }

    /**
     * Applique les effets de deuxième type : Aucun effet pour cette carte
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