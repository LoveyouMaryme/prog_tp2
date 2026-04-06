/**
 * Représente un joueur de la partie.
 *
 * Chaque joueur commence une partie avec:
 * <ul>
 *     <li>5 cartes en main</li>
 *     <li>1 point d'attaque (peut attaquer une fois)</li>
 *     <li>0 point de dommage reçu</li>
 *     <li>0 point d'expérience</li>
 * </ul>
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public class Joueur {

    private int id;
    //cartes en main
    public int m = 5;
    //nbr permis d'attaques
    public int a = 1;
    //dommage reçu
    public int d = 0;
    //points d'exp
    public int e = 0;

    /**
     * Construit un joueur avec des statistiques de base
     *
     * @param id ID du joueur
     */
    public Joueur(int id) {
        this.id = id;
    }

    /**
     * Retourne le ID du joueur
     *
     * @return ID du joueur
     */
    public int getId() {
        return this.id;
    }
}
