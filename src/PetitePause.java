import java.util.Deque;

public class PetitePause extends CarteAttaque {
    public PetitePause(int idJoueur){
        super("PetitePause", idJoueur);
    }

    @Override
    public void appliquerEffetType1(Joueur jc, Joueur ja){
        jc.m = jc.m + 1;
        ja.m = ja.m + 1;
    }

    @Override
    public void appliquerEffetType2(Joueur[] joueurs, Deque<Carte> pile, int[] nbRiposte){
        //aucun effet
    }

}
