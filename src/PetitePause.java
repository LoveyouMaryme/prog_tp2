import java.util.Deque;

/**
 * Représente la carte d'attaque « Petite Pause ».
 *
 * Modifie le nombre de cartes en main des deux joueurs :
 * <ol>
 *  <ul>Un de plus pour le joueur courant.</ul>
 *  <ul>Un de moins pour le joueur adverse.</ul>
 * </ol>
 */
public class PetitePause extends CarteAttaque {

    /**
     * Construit une carte « Petite Pause »
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public PetitePause(int idJoueur){
        super("PetitePause", idJoueur);
    }

    /**
     * Applique les effets de premier type :
     * ajuste le nombre de cartes en main des deux joueurs.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja){
        jc.m = jc.m + 1;
        ja.m = ja.m - 1;
    }

    /**
     * Applique les effets de premier type :
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte){
        //aucun effet
    }

}
