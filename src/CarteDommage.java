import java.util.Deque;


public abstract class CarteDommage extends Carte {
    private int valeurDegats;

    public CarteDommage(String nom, int idJoueur, int valeurDegats) {
        super(nom, idJoueur);
        this.valeurDegats = valeurDegats;
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {

        if (jc.m <= 0) {
            this.raisonEchec = Mssg.CARTES_MAIN;
            return false;
        }
        return true;
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        // Aucun effet
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {

        // Ja.d = Ja.d + valeurDegats
        Joueur ja = joueurs[1 - this.idJoueur];
        ja.d += this.valeurDegats;
    }
}