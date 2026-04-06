
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

public static boolean chargerEtValider(File f, Joueur[] js, Deque<Carte> pile) {
    int noLigne = 0;
    try (Scanner sc = new Scanner(f)) {
        while (sc.hasNextLine()) {
            noLigne++;
            String ligne = sc.nextLine();
            if (ligne.isEmpty()) continue;

            Carte c = parserLigne(ligne, noLigne); // Méthode pour créer la carte
            Joueur jc = js[c.idJoueur];
            Joueur ja = js[1 - c.idJoueur];

            if (!c.verifier(jc, ja)) {
                String raisonEchec = c.getRaisonEchec();

                StringBuilder sb = new StringBuilder();
                sb.append(Mssg.JEU_INCORRECT).append(noLigne).append(Mssg.FIN_DE_PHRASE)
                                .append(Mssg.JOUEUR_SIMPLE).append(jc.getId())
                                .append(Mssg.PAS_ASSEZ_DE).append(raisonEchec)
                                .append(Mssg.POUR_JOUER).append(Mssg.GUILLEMET)
                                .append(c.getNom()).append(Mssg.GUILLEMET)
                                .append(Mssg.FIN_DE_PHRASE);

                System.out.println(sb);
                return false;
            }
            c.appliquerDepot(jc);
            c.appliquerEffetType1(jc, ja);
            pile.push(c);
        }
    } catch (FileNotFoundException e) { return false; }
    return true;
}

public static void calculerResultats(Joueur[] joueurs, Deque<Carte> pile) {
    int[] nbRiposte = {0};

    while (!pile.isEmpty()) {
        Carte c = pile.pop();
        // L'effet de type 2 peut modifier la pile
        c.appliquerEffetType2(joueurs, pile, nbRiposte);
    }
}

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

public static void afficherScores(Joueur[] js) {
    for (Joueur j : js) {
        System.out.println(Mssg.JOUEUR_SIMPLE + j.getId() + Mssg.DOMMAGE + j.d + Mssg.Experience + j.e);
    }
}
