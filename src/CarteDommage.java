import java.util.Deque;


/**
 * Représente l'abstraction d'une Carte Dommage du jeu.
 *
 *  Définit les règles de vérification et d'application
 *  des cartes de type Dommage
 */

public abstract class CarteDommage extends Carte {
    private int valeurDegats;


    /**
     * Construit une carte de type Dommage
     *
     * @param nom nom de la carte
     * @param idJoueur Id du joueur qui utilise cette carte
     * @param valeurDegats Nombre de points de dégât que cette carte inflige au joueur adverse
     */
    public CarteDommage(String nom, int idJoueur, int valeurDegats) {
        super(nom, idJoueur);
        this.valeurDegats = valeurDegats;
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

        if (jc.m <= 0) {
            this.raisonEchec = Mssg.CARTES_MAIN;
            return false;
        }
        return true;
    }

    /**
     * Applique les effets de premier type propres à cette carte de dommage.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {

    }


    /**
     * Applique les effets de deuxième type :
     * Inflige les points de dégâts au joueur adverse
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {

        Joueur ja = joueurs[1 - this.idJoueur];
        ja.d += this.valeurDegats;
    }
}