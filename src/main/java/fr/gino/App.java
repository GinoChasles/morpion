package fr.gino;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    public static void main(String[] args) {

        Grille morpion = new Grille(3, 3);

        Joueur joueur1 = new Joueur(new Pion('X'), "joueur1");
        joueur1.askName();
        Joueur joueur2 = new Joueur(new Pion('O'), "joueur2");
        joueur2.askName();

        Game partie = new Game(morpion, joueur1, joueur2, joueur1);

        partie.game(morpion, joueur1, joueur2);
    }
}
