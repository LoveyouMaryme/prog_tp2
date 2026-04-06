/**
 * Représente la carte de dommage « Fouette ».
 *
 * Inflige 2 points de dommage au joueur adverse.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
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