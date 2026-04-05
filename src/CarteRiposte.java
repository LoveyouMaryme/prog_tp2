import java.util.Deque;

public abstract class CarteRiposte extends Carte {

    public CarteRiposte(String nom, int idJoueur) {
        super(nom, idJoueur);
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > 0;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        // Effet commun pour toutes les cartes de type riposte
        nbRiposte[0]++;

        appliquerEffetSpecifiqueType2(joueurs, pile, nbRiposte);
    }

    /**
     * Méthode pour les effets uniques.
     */
    public abstract void appliquerEffetSpecifiqueType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte);
}