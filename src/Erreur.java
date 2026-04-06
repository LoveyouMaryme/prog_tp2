

/**
 * Ce type énuméré contient les différents messages d'erreur possible pour le logiciel.
 * Chaque message est associé a un code d'erreur.
 *
 * Les méthodes {@code affiche} vont s'occuper d'afficher le message d'erreur sur le canal d'erreur standard :
 * {@code System.err}.
 *
 * Les méthodes {@code critique} vont s'occuper d'afficher le message d'erreur et de termine l'exécution du programme.
 */
public enum Erreur {
    OUVRIR_FICHIER( Mssg.ERREUR_OUVRIR_FICHIER, -1 ),
    NUMERO_DU_JOUEUR_INCORRECT( Mssg.ERREUR_NUMERO_JOUEUR_INCORRECT, -10 ),
    NOM_CARTE_INCORRECT( Mssg.ERREUR_NOM_CARTE_INCORRECT, -11 ),
    CARTE_TRANCE( Mssg.ERREUR_CARTE_TRANCE, -12 ),
    ;

    private String mssg;
    private int no;

    /**
     * Construit un message d'erreur
     * @param mssg message d'erreur
     * @param no numero de l'erreur
     */
    private Erreur( String mssg, int no ) {
        this.mssg = mssg;
        this.no = no;
    }

    /**
     * Affiche le message d'erreur avec un message supplémentaire.
     * @param ajout le message supplémentaire.
     */
    public void afficher( String ajout ) {
        System.err.println( mssg + Mssg.SEPARATEUR_MESSAGE + ajout + Mssg.FIN_DE_PHRASE );
    }

    /**
     * Affiche le message d'erreur.
     */
    public void afficher() {
        System.err.println( mssg + Mssg.FIN_DE_PHRASE );
    }

    /**
     * Affiche le message d'erreur avec un message supplémentaire.  Ensuite, le programme termine avec le code
     * d'erreur du message.
     * @param ajout le message supplémentaire.
     */
    public void critique( String ajout ) {
        afficher( ajout );
        System.exit( no );
    }

    /**
     * Affiche le message d'erreur.
     * Ensuite, le programme termine avec le code d'erreur du message.
     */
    public void critique() {
        afficher();
        System.exit( no );
    }
}
