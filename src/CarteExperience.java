import java.util.Deque;

public abstract class CarteExperience extends Carte {
    private int valeurXp;

    public CarteExperience(String nom, int idJoueur, int valeurXp) {
        super(nom, idJoueur);
        this.valeurXp = valeurXp;
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
        // Jc.e = Jc.e + valeurXp
        Joueur jc = joueurs[this.idJoueur];
        jc.e += this.valeurXp;
    }
}