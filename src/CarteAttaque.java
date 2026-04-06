public abstract class CarteAttaque extends Carte {

    public CarteAttaque(String nom, int idJoueur){
        super(nom, idJoueur);
    }

    @Override
    public boolean verifier(Joueur jc, Joueur ja) {
        //regle commune: main > 0 et pts attaque > 0
        if (jc.m <= 0) {
            this.raisonEchec = Mssg.CARTES_MAIN;
            return false;
        }
        if (jc.a <= 0) {
            this.raisonEchec = Mssg.POINT_ATTAQUE;
            return false;
        }
        return true;
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
