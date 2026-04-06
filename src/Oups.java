
/**
 * Représente la carte d'expérience « Oups »
 *
 * Octroie 2 points d'expérience au joueur qui l'utilise
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class Oups extends CarteExperience {

    /**
     * Construit une carte « Oups »
     *
     * @param idJoueur ID du joueur qui l'utilise
     */
    public Oups(int idJoueur) {
        super("Oups", idJoueur, 1);
    }
}