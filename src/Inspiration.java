import java.util.Deque;

public class Inspiration extends Carte {

    public Inspiration(int idJoueur) {
        super("Inspiration", idJoueur);
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        return jc.m > 0;
    }

    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc);
        //jc.m--;
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja) {
        jc.m++;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte) {
        nbRiposte[0]++;

        //vérifie si la carte en dessous est une carte d'Attaque
        if (!pile.isEmpty() && pile.peek().estAttaque()) {
            joueurs[this.idJoueur].e += 1;
        }
    }
}
