package com.iim.golf.model;

import java.util.Random;

public class Game {

    private final Random random = new Random();

    public String jouer(Golfer joueur1, Golfer joueur2, Terain terain) {

        int coups1 = terain.parTotal() + random.nextInt(11);
        int coups2 = terain.parTotal() + random.nextInt(11);

        String debut = "Sur le terrain " + terain.nom + " (par " + terain.parTotal() + ") : "
                + joueur1.nom + " a fait " + coups1 + " coups, "
                + joueur2.nom + " a fait " + coups2 + " coups. ";

        if (coups1 == coups2) {
            return debut + "Egalite, personne ne gagne !";
        }

        String gagnant = coups1 < coups2 ? joueur1.nom : joueur2.nom;
        return debut + "Le gagnant est " + gagnant + " !";
    }
}
