import java.util.Deque;


/**
 * Représente la carte d'attaque « TousPourUn ».
 *
 * Augmente d'un point le nombre de cartes en main pour les deux joeuurs
 */
public class TousPourUn extends CarteAttaque {

    /**
     * Construit une carte « Tous Pour Un »
     *
     * @param idJoueur ID du joueur qui l'utilise

     */
    public TousPourUn(int idJoueur) {
        super("TousPourUn", idJoueur);
    }

    /**
     * Applique les effets de premier type :
     * ajuste le nombre de cartes en main des deux joueurs.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m = jc.m + 1;
        jc.a = jc.a + 1;
    }


    /**
     * Applique les effets de premier type :
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Aucun effet
    }
}