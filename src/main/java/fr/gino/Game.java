package fr.gino;

import java.util.Scanner;

public class Game {
    Grille morpion;
    Joueur joueur1;
    Joueur joueur2;
    Joueur currentlyPlayer;
    int pionsJoues = 0;
    int pionsMax = 9;
    Scanner scanner;
    int x;
    int y;

    public Game(Grille morpion, Joueur joueur1, Joueur joueur2, Joueur currentlyPlayer) {
        this.morpion = morpion;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.currentlyPlayer = joueur1;
    }

    public void turn() {
        if (currentlyPlayer == joueur1) {
            joueur1.jouerPion('X', morpion);
            currentlyPlayer = joueur2;
        } else if (currentlyPlayer == joueur2) {
            joueur2.jouerPion('O', morpion);
            currentlyPlayer = joueur1;
        }
    }

    public void game(Grille morpion, Joueur joueur1, Joueur joueur2) {
        morpion.afficherGrille();
        while ((pionsJoues != pionsMax) || !(victory() == false)) {
            turn();

            morpion.afficherGrille();
            victory();
        }
    }

    public boolean victory() {
        if (((morpion.plateau[0][0] == morpion.plateau[0][1]) && (morpion.plateau[0][1] == morpion.plateau[0][2]))
                || ((morpion.plateau[0][1] == morpion.plateau[1][1])
                        && (morpion.plateau[1][1] == morpion.plateau[2][1]))
                || ((morpion.plateau[1][0] == morpion.plateau[1][1])
                        && (morpion.plateau[1][1] == morpion.plateau[1][2]))
                || ((morpion.plateau[2][0] == morpion.plateau[2][1])
                        && (morpion.plateau[2][1] == morpion.plateau[2][2]))
                || ((morpion.plateau[0][0] == morpion.plateau[1][0])
                        && (morpion.plateau[1][0] == morpion.plateau[2][0]))
                || ((morpion.plateau[0][2] == morpion.plateau[1][2])
                        && (morpion.plateau[1][2] == morpion.plateau[2][2]))
                || ((morpion.plateau[0][0] == morpion.plateau[1][1])
                        && (morpion.plateau[1][1] == morpion.plateau[2][2]))
                || ((morpion.plateau[0][2] == morpion.plateau[1][1])
                        && (morpion.plateau[1][1] == morpion.plateau[2][0])))
            System.out.println("victory");
        return true;

    }

}
