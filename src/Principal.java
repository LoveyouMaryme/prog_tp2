/**
 *
 *  Interprète les résultats d’un jeu en analysant la suite d’événements du jeu.
 *
 * Auteur : Love-Mary Victor, Sami Lies Mouzai
 * Code permanent : VICL12599701, MOUS27039501
 */
void main() {

    Scanner clavier = new Scanner(System.in);
    System.out.println(Mssg.ENTREZ_NOM_FICHIER);
    String nomFichier = clavier.nextLine();

    File fichier = new File(nomFichier);
    if (!fichier.exists()) {
        Erreur.OUVRIR_FICHIER.critique();
    }

    Joueur[] joueurs = { new Joueur(0), new Joueur(1) };
    Deque<Carte> pile = new ArrayDeque<>();

    // Lancer les deux phases
    if (chargerEtValider(fichier, joueurs, pile)) {
        calculerResultats(joueurs, pile);
        afficherScores(joueurs);
    }


}

/**
 * Charge et valide un fichier des évènements du jeu.
 *
 * Parcourt chaque ligne du fichier, crée la carte correspondante,
 * vérifie si le joueur peut la jouer, puis met la carte dans la pile
 *
 * @param f le fichier des évènements de jeu à analyser
 * @param js les joueurs qui participent au jeu
 * @param pile la pile de cartes validées à remplir à partir du fichier
 * @return true si toutes les lignes du fichier ont été chargées et validées avec succès, false sinon
 */
public static boolean chargerEtValider(File f, Joueur[] js, Deque<Carte> pile) {
    boolean succes = true;
    int noLigne = 0;

    try (Scanner sc = new Scanner(f)) {
        while (sc.hasNextLine() && succes) {
            noLigne++;
            String ligne = sc.nextLine().trim();

            if (!ligne.isEmpty()) {
                Carte c = parserLigne(ligne, noLigne);
                Joueur jc = js[c.idJoueur];
                Joueur ja = js[1 - c.idJoueur];

                if (c.verifier(jc, ja)) {
                    c.appliquerDepot(jc);
                    c.appliquerEffetType1(jc, ja);
                    pile.push(c);
                } else {
                    System.out.println(Mssg.JEU_INCORRECT + noLigne + Mssg.FIN_DE_PHRASE
                            + Mssg.JOUEUR_SIMPLE + jc.getId() + Mssg.PAS_ASSEZ_DE
                            + c.getRaisonEchec() + Mssg.POUR_JOUER + Mssg.GUILLEMET
                            + c.getNom() + Mssg.GUILLEMET + Mssg.FIN_DE_PHRASE);
                    succes = false;
                }
            }
        }
    } catch (FileNotFoundException e) {
        succes = false;
    }

    return succes;
}

/**
 * Calcule les résultats de la manche à partir de la pile de cartes.
 *
 * Dépile successivement les cartes de la pile et applique
 * les effets de deuxième type sur les joueurs.
 *
 * @param joueurs le tableau des deux joueurs
 * @param pile    la pile des cartes déjà jouées, à traiter en ordre inverse
 */
public static void calculerResultats(Joueur[] joueurs, Deque<Carte> pile) {
    int[] nbRiposte = {0};

    while (!pile.isEmpty()) {
        Carte c = pile.pop();
        // L'effet de type 2 peut modifier la pile
        c.appliquerEffetType2(joueurs, pile, nbRiposte);
    }
}

/**
 * Analyse chaque ligne du fichier des évènements du jeu
 *
 * Valide le numéro du joueur et le nom de la carte,
 * puis crée l'objet Carte correspondant.
 *
 * @param ligne : Une ligne du fichier de suite d'évènements à analyser
 * @param noLigne : Le numéro de la ligne
 * @return La carte représentée par la ligne
 */
public static Carte parserLigne(String ligne, int noLigne) {
    String[] parts = ligne.trim().split("\\s+"); // \\s+ pour si plusieurs espaces

    int id = Integer.parseInt(parts[0]);
    if (id < 0 || id > 1) Erreur.NUMERO_DU_JOUEUR_INCORRECT.critique(Mssg.LIGNE_SIMPLE + noLigne);

    String nom = parts[1];
    Carte c = null;

    // création de l'objet carte correspondant
    switch (nom) {
        // Cartes d'Attaque
        case "BotteSecrete":   c = new BotteSecrete(id); break;
        case "NouvelleEnergie": c = new NouvelleEnergie(id); break;
        case "Illumination":    c = new Illumination(id); break;
        case "CalmeAvantLaTempete": c = new CalmeAvantLaTempete(id); break;
        case "PetitePause":     c = new PetitePause(id); break;
        case "PetitVoleur":     c = new PetitVoleur(id); break;
        case "TousPourUn":      c = new TousPourUn((id)); break;

        // La carte Trance
        case "Trance":
            if (parts.length < 3) Erreur.CARTE_TRANCE.critique(Mssg.LIGNE_SIMPLE + noLigne);
            int n = Integer.parseInt(parts[2]);
            if (n < 0 || n > 4) Erreur.CARTE_TRANCE.critique(Mssg.LIGNE_SIMPLE + noLigne);
            c = new Trance(id, n);
            break;

        // Cartes de Dommage
        case "Fouette":      c = new Fouette(id); break;
        case "CoupDroit":    c = new CoupDroit(id); break;
        case "Fleche":       c = new Fleche(id); break;

        // Cartes d'Expérience
        case "Oups":         c = new Oups(id); break;
        case "JaiCompris":   c = new JaiCompris(id); break;

        // Cartes de Riposte
        case "Inspiration":  c = new Inspiration(id); break;
        case "Esquive":      c = new Esquive(id); break;
        case "Vitesse":      c = new Vitesse(id); break;

        default:
            Erreur.NOM_CARTE_INCORRECT.critique(Mssg.LIGNE_SIMPLE + noLigne + " : " + nom);
    }
    return c;
}

/**
 * Affiche les scores des joueurs.
 *
 * Pour chaque joueur, affiche sur une ligne son identifiant,
 * le dommage reçu et l'expérience obtenue.
 *
 * @param js Les deux joueurs de la partie
 */
public static void afficherScores(Joueur[] js) {
    for (Joueur j : js) {
        System.out.println(Mssg.JOUEUR_SIMPLE + j.getId() + Mssg.DOMMAGE + j.d + Mssg.Experience + j.e);
    }
}
