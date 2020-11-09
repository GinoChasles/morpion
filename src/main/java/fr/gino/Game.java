package fr.gino;

import java.util.Scanner;

public class Game {
    protected Grille morpion;
    protected Joueur joueur1;
    protected Joueur joueur2;
    protected Joueur currentlyPlayer;
    protected int pionsJoues = 0;
    protected int pionsMax = 9;
    Scanner scan;

    protected Game(Grille morpion, Joueur joueur1, Joueur joueur2, Joueur currentlyPlayer) {
        this.morpion = morpion;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.currentlyPlayer = joueur1;
    }

    private void turn() {
        if (currentlyPlayer == joueur1) {
            joueur1.jouerPion('X', morpion);
            pionsJoues++;
            if (checkVictory()) {
                System.out.println(String.format("Bravo %s, tu as gagné !", joueur1.name));
            }
            currentlyPlayer = joueur2;
        } else if (currentlyPlayer == joueur2) {
            joueur2.jouerPion('O', morpion);
            pionsJoues++;
            if (checkVictory()) {
                System.out.println(String.format("Bravo %s, tu as gagné !", joueur2.name));
            }
            currentlyPlayer = joueur1;
        }
    }

    protected void game() {

        while ((pionsJoues != pionsMax) && (checkVictory() == false)) {
            morpion.afficherGrille();
            turn();
        }
    }

    private boolean checkline() {
        return (((morpion.plateau[0][0] == 'X') && (morpion.plateau[0][1] == 'X') && (morpion.plateau[0][2] == 'X'))
                || ((morpion.plateau[1][0] == 'X') && (morpion.plateau[1][1] == 'X') && (morpion.plateau[1][2] == 'X'))
                || ((morpion.plateau[2][0] == 'X') && (morpion.plateau[2][1] == 'X') && (morpion.plateau[2][2] == 'X'))
                || ((morpion.plateau[0][0] == 'O') && (morpion.plateau[0][1] == 'O') && (morpion.plateau[0][2] == 'O'))
                || ((morpion.plateau[1][0] == 'O') && (morpion.plateau[1][1] == 'O') && (morpion.plateau[1][2] == 'O'))
                || ((morpion.plateau[2][0] == 'O') && (morpion.plateau[2][1] == 'O')
                        && (morpion.plateau[2][2] == 'O')));
    }

    private boolean checkcolonne() {
        return (((morpion.plateau[0][0] == 'X') && (morpion.plateau[1][0] == 'X') && (morpion.plateau[2][0] == 'X'))
                || ((morpion.plateau[0][1] == 'X') && (morpion.plateau[1][1] == 'X') && (morpion.plateau[2][1] == 'X'))
                || ((morpion.plateau[0][2] == 'X') && (morpion.plateau[1][2] == 'X') && (morpion.plateau[2][2] == 'X'))
                || ((morpion.plateau[0][0] == 'O') && (morpion.plateau[1][0] == 'O') && (morpion.plateau[2][1] == 'O'))
                || ((morpion.plateau[0][1] == 'O') && (morpion.plateau[1][1] == 'O') && (morpion.plateau[2][1] == 'O'))
                || ((morpion.plateau[0][2] == 'O') && (morpion.plateau[1][2] == 'O')
                        && (morpion.plateau[2][2] == 'O')));

    }

    private boolean checkDiagonal() {
        return (((morpion.plateau[0][0] == 'X') && (morpion.plateau[1][1] == 'X') && (morpion.plateau[2][2] == 'X'))
                || ((morpion.plateau[0][0] == 'O') && (morpion.plateau[1][1] == 'O') && (morpion.plateau[2][2] == 'O'))
                || ((morpion.plateau[2][0] == 'X') && (morpion.plateau[1][1] == 'X') && (morpion.plateau[0][2] == 'X'))
                || ((morpion.plateau[2][0] == 'O') && (morpion.plateau[1][1] == 'O')
                        && (morpion.plateau[0][2] == 'O')));

    }

    private boolean checkVictory() {
        if (checkDiagonal() || checkcolonne() || checkline()) {
            System.out.println("Victory !");
            return true;
        } else
            return false;
    }
}