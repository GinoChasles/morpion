package fr.gino;

public class Grille {

    char plateau[][];
    int x;
    int y;

    public Grille(int x, int y) {
        this.x = x;
        this.y = y;
        this.plateau = new char[x][y];
        initialBoard();
    }

    public void afficherGrille() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(plateau[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void initialBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plateau[i][j] = ' ';
            }
        }
    }
}
