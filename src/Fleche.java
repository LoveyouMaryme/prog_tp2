/**
 * Représente la carte de dommage « Flèche ».
 *
 * Inflige 3 points de dommage au joueur adverse.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
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
