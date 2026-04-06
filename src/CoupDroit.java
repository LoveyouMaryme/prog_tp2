/**
 * Représente la carte de dommage « Coup droit ».
 *
 * Inflige 1 point de dommage au joueur adverse.
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
