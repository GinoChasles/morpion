package fr.gino;

import java.util.Scanner;

public class Joueur {

    String name;
    Pion neutre;
    Grille morpion;
    Scanner scanner;
    int pionsJoues = 0;
    int pionsMax = 9;

    // char grille[][];
    // char grille[][] = new char[3][3];

    public Joueur(Pion neutre, String name) {
        this.neutre = neutre;
        this.name = name;
        scanner = new Scanner(System.in);
    }

    public void askName() {
        String oldName = name;
        System.out.println(String.format("Quel est le nom du %s ?", name));

        name = scanner.next();
        System.out.println(String.format("Le nom du %s est %s et joue les pions X", oldName, name));
    }

    public void jouerPion(char neutre, Grille morpion) {
        boolean good;
        do {
            System.out.println(
                    String.format("%s, veuillez saisir la ligne dans laquelle vous désirer mettre votre pion", name));
            int li = scanner.nextInt();

            System.out.println(
                    String.format("%s, veuillez saisir la colonne dans laquelle vous désirer mettre votre pion", name));
            int col = scanner.nextInt();

            if (morpion.plateau[li][col] == ' ') {
                morpion.plateau[li][col] = neutre;
                good = true;

            } else {
                System.out.println("La case est déjà utilisé");
                good = false;
            }
        } while (good == false);
    }
}
