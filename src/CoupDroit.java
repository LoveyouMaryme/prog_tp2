/**
 * Représente la carte de dommage « Coup droit ».
 *
 * Inflige 1 point de dommage au joueur adverse.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class CoupDroit extends CarteDommage {

    /**
     * Construit une carte Coup droit
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public CoupDroit(int idJoueur){
        super("CoupDroit", idJoueur, 1);
    }
}
