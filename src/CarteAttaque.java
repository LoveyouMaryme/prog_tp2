public abstract class CarteAttaque extends Carte {

    public CarteAttaque(String nom, int idJoueur){
        super(nom, idJoueur);
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        //regle commune: main > 0 et pts attaque > 0
        return jc.m > 0 && jc.a > 0;
    }

    @Override
    public void appliquerDepot(Joueur jc) {
        super.appliquerDepot(jc); //jc.m--
        jc.a--; //coute 1 attaque
    }

    @Override
    public boolean estAttaque()  {
        return true;
    }
}
