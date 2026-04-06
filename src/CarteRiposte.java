import java.util.Deque;

/**
 * Représente l'abstraction d'une Carte Riposte du jeu.
 *
 *  Définit les règles de vérification et d'application
 *  des cartes de type Riposte
 */
public abstract class CarteRiposte extends Carte {

    /**
     * Construit une carte de type Riposte
     *
     * @param nom nom de la carte
     * @param idJoueur Id du joueur qui utilise cette carte
     */
    public CarteRiposte(String nom, int idJoueur) {
        super(nom, idJoueur);
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
     * Applique les effets de premier type propres à cette carte de riposte.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Effet commun pour toutes les cartes de type riposte
        nbRiposte[0]++;

        appliquerEffetSpecifiqueType2(joueurs, pile, nbRiposte);
    }

    /**
     * Applique les effets de deuxième type propres à cette carte de riposte.
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    public abstract void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte);
}