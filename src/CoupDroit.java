/**
 * Représente la carte de dommage « Coup droit ».
 *
 * Inflige 1 point de dommage au joueur adverse.
 */
public class CoupDroit extends CarteDommage {
    public CoupDroit(int idJoueur){
        super("CoupDroit", idJoueur, 1);
    }
}
