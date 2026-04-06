/**
 * Représente la carte de dommage « Flèche ».
 *
 * Inflige 3 points de dommage au joueur adverse.
 */
public class Fleche extends CarteDommage{

    /**
     * Construit une carte « Flèche »
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public Fleche(int idJoueur){
        super("Fleche", idJoueur, 3);
    }
}
