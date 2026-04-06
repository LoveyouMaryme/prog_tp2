import java.util.Deque;

/**
 * Représente l'abstraction d'une Carte du jeu.
 *
 * Sert de gabarit de base pour toutes les cartes
 * <ul>
 *     <li> attague </li>
 *     <li> dommage </li>
 *     <li> riposte </li>
 *     <li> experience </li>
 * </ul>
 *  en définissant les opérations communes de vérification
 *  et d'application des effets.
 */
public abstract class Carte {

    protected String nom;
    protected int idJoueur;
    protected String raisonEchec = "";

    public boolean estAttaque() { return false; }
    public boolean estDommage() { return false; }
    public boolean estRiposte() { return false; }
    public boolean estExperience() { return false; }

    /**
     * Crée une carte jouée par un joueur
     *
     * @param nom le nom de la carte
     * @param idJoueur le ID du joueur qui utilise la carte
     */
    public Carte(String nom, int idJoueur){
        this.nom = nom;
        this.idJoueur = idJoueur;
    }

    /**
     * Retourne le nom de la carte
     *
     * @return le nom de la carte jouée
     */
    public String getNom() {
        return this.nom;
    }


    /**
     * Vérifie si les conditions d'un jeu de carte sont remplies.
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adversaire, celui qui ne joue pas la carte
     * @return true si la carte est valide, false sinon
     */
    public abstract boolean verifier(Joueur jc, Joueur ja);

    /**
     * Retire une carte jouée dans la main du joueur courant
     *
     * @param jc joueur courant, celui qui joue la carte
     */
    public void appliquerDepot(Joueur jc){
        jc.m --;
    }

    /**
     * Applique les effets de premier type
     * de ce type de carte sur le joueur désigné
     *
     * @param jc joueur courant, celui qui joue la carte
     * @param ja joueur adverse, celui qui ne joue pas la carte
     */
    public abstract void appliquerEffetType1(Joueur jc, Joueur ja);

    /**
     * Applique les effets de deuxième type de cette carte si applicable
     *
     * @param joueurs   le tableau des deux joueurs
     * @param pile      la pile de cartes jouées
     * @param nbRiposte compteur du nombre de cartes de riposte déjà jouées
     */
    public abstract void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte);

    public String getRaisonEchec() {
        return raisonEchec;
    }



}
