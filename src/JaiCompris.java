/**
 * Représente la carte de dommage « J'ai compris ».
 *
 * Octroie 2 points d'expérience au joueur
 */
public class JaiCompris extends CarteExperience {


    /**
     * Construit une carte « J'ai compris »
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public JaiCompris(int idJoueur) {
        super("JaiCompris", idJoueur, 2);
    }
}