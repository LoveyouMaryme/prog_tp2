/**
 * Représente la carte d'expérience « J'ai compris ».
 *
 * Octroie 2 points d'expérience au joueur qui l.utilise
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