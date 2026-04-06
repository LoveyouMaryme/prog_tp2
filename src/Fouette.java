/**
 * Représente la carte de dommage « Fouette ».
 *
 * Inflige 2 points de dommage au joueur adverse.
 */

public class Fouette extends CarteDommage {

    /**
     * Construit une carte « Fouette »
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public Fouette(int idJoueur) {
        super("Fouette", idJoueur, 2);
    }
}