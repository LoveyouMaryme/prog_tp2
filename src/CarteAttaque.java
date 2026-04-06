/**
 * Représente l'abstraction d'une Carte Attaque du jeu.
 *
 *  Définit les règles de vérification et d'application
 *  des cartes de type Attaque
 *
 */

public abstract class CarteAttaque extends Carte {

    /**
     * Construit une carte de type Attaque
     * @param nom nom de la carte
     * @param idJoueur Id du joueur qui utilise cette carte
     */
    public CarteAttaque(String nom, int idJoueur){
        super(nom, idJoueur);
    }

    /**
     * Vérifie plusieurs conditions :
     * <ul>
     *   <li>le joueur courant a au moins une carte en main</li>
     *   <li>le joueur courant a assez de points d'attaque</li>
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
        } else if (jc.a <= 0) {
            this.raisonEchec = Mssg.POINT_ATTAQUE;
            valide = false;
        }
        return valide;
    }

    /**
     * Réduit d'un point le nombre de points d'attaque
     * restant du joueur courant
     * @param jc joueur courant, celui qui joue la carte
     */

    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc);
        jc.a--;
    }

    /**
     * Valide que la carte est bel et bien une d'attaque
     * @return true si la carte est de type Attaque sinon, false
     */
    @Override
    public boolean estAttaque()  {
        return true;
    }
}
