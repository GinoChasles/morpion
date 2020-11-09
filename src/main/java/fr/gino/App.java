package fr.gino;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Grille morpion = new Grille(3, 3);
        // morpion.printBoard();

        Joueur joueur1 = new Joueur(new Pion('X'), "joueur1");
        joueur1.askName();
        Joueur joueur2 = new Joueur(new Pion('O'), "joueur2");
        joueur2.askName();

        Game partie = new Game(morpion, joueur1, joueur2, joueur1);
        // joueur1.jouerPion('X', morpion);
        // morpion.afficherGrille();
        // joueur2.jouerPion('O', morpion);
        // morpion.afficherGrille();
        // joueur1.jouerPion('X', morpion);
        // morpion.afficherGrille();
        // joueur2.jouerPion('O', morpion);
        // morpion.afficherGrille();
        // joueur1.jouerPion('X', morpion);
        // morpion.afficherGrille();
        // joueur1.checkVictory();

        // morpion.afficherGrille();
        partie.game(morpion, joueur1, joueur2);
    }
}
