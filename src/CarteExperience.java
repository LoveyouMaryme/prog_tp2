import java.util.Deque;


/**
 * Représente l'abstraction d'une Carte Expérience du jeu.
 *
 *  Définit les règles de vérification et d'application
 *  des cartes de type Expérience
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
public abstract class CarteExperience extends Carte {
    private int valeurXp;

    /**
     * Construit une carte de type Expérience
     *
     * @param nom nom de la carte
     * @param idJoueur Id du joueur qui utilise cette carte
     * @param valeurXp Nombre de points d'expérience que cette carte procure
     */
    public CarteExperience(String nom, int idJoueur, int valeurXp) {
        super(nom, idJoueur);
        this.valeurXp = valeurXp;
    }

    /**
     * Vérifie plusieurs conditions :
     * <ul>
     *   <li>le joueur courant a au moins une carte en main</li>
     * </ul>
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     * @return true si la carte peut être jouée, false sinon
     */
    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        boolean valide = true;
        if (jc.m <= 0) {
            this.raisonEchec = Mssg.CARTES_MAIN;
            valide = false;
        }
        return valide;
    }

    /**
     * Applique les effets de premier type propres à cette carte d'expérience.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    /**
     * Applique les effets de deuxième type :
     * Octroie de l'expérience au joueur courant
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Jc.e = Jc.e + valeurXp
        Joueur jc = joueurs[this.idJoueur];
        jc.e += this.valeurXp;
    }
}