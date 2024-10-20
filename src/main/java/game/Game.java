// src/main/java/game/Game.java
package game;

import tamagoshi.BigEaterTamagoshi;
import tamagoshi.BigPlayerTamagoshi;
import tamagoshi.Tamagoshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale pour gérer le jeu de Tamagoshis.
 */
public class Game {
    private List<Tamagoshi> tamagoshis;
    private BufferedReader reader;

    /**
     * Constructeur de la classe Game.
     * Initialise la liste des tamagoshis et le lecteur de l'entrée standard.
     */
    public Game() {
        tamagoshis = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Démarre le jeu en demandant le nombre de tamagoshis et leurs noms.
     * Gère les tours de jeu jusqu'à la fin de la partie.
     *
     * @throws IOException si une erreur d'entrée/sortie se produit
     */
    public void start() throws IOException {
        System.out.println("Entrez le nombre de tamagoshis désiré !");
        int numberOfTamagoshis = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfTamagoshis; i++) {
            System.out.println("Entrez le nom du tamagoshi numéro " + (i + 1) + " :");
            String name = reader.readLine();
            Tamagoshi tamagoshi;
            if (i % 2 == 0) {
                tamagoshi = new BigEaterTamagoshi(name);
            } else {
                tamagoshi = new BigPlayerTamagoshi(name);
            }
            tamagoshis.add(tamagoshi);
        }

        int turn = 1;
        boolean gameOver = false;
        while (!gameOver && turn <= Tamagoshi.AGE_LIMIT) {
            System.out.println("\n------------ Tour n°" + turn + " -------------");
            for (Tamagoshi tamagoshi : tamagoshis) {
                tamagoshi.expressEmotion();
            }

            interactWithTamagoshis();

            for (Tamagoshi tamagoshi : tamagoshis) {
                tamagoshi.decrementState();
                if (!tamagoshi.isAlive() && tamagoshi.getAge() < Tamagoshi.AGE_LIMIT) {
                    gameOver = true;
                    break;
                }
            }

            turn++;
        }

        endGame();
    }

    /**
     * Permet d'interagir avec les tamagoshis en les nourrissant et en jouant avec eux.
     *
     * @throws IOException si une erreur d'entrée/sortie se produit
     */
    private void interactWithTamagoshis() throws IOException {
        System.out.println("\nNourrir quel tamagoshi ?");
        for (int i = 0; i < tamagoshis.size(); i++) {
            System.out.println("(" + i + ") " + tamagoshis.get(i).getName());
        }
        int choice = Integer.parseInt(reader.readLine());
        System.out.println(tamagoshis.get(choice).getName() + " : " + tamagoshis.get(choice).feed());

        System.out.println("\nJouer avec quel tamagoshi ?");
        for (int i = 0; i < tamagoshis.size(); i++) {
            System.out.println("(" + i + ") " + tamagoshis.get(i).getName());
        }
        choice = Integer.parseInt(reader.readLine());
        System.out.println(tamagoshis.get(choice).getName() + " : " + tamagoshis.get(choice).play());
    }

    /**
     * Termine le jeu et affiche le bilan de la partie.
     */
    private void endGame() {
        System.out.println("\n--------- fin de partie !! ----------------");
        System.out.println("\n------------- bilan ------------");
        for (Tamagoshi tamagoshi : tamagoshis) {
            if (tamagoshi.isAlive()) {
                System.out.println(tamagoshi.getName() + " qui était un " + tamagoshi.getType() + " a survécu et vous remercie :)");
            } else {
                System.out.println(tamagoshi.getName() + " qui était un " + tamagoshi.getType() + " n'est pas arrivé au bout et ne vous félicite pas :(");
            }
        }

        int totalAge = tamagoshis.stream().mapToInt(Tamagoshi::getAge).sum();
        int maxAge = tamagoshis.size() * Tamagoshi.AGE_LIMIT;
        double score = (double) totalAge / maxAge * 100;
        System.out.println("\nniveau de difficulté : " + tamagoshis.size() + ", score obtenu : " + score + "%");
    }

    /**
     * Méthode statique pour lancer le jeu.
     *
     * @throws IOException si une erreur d'entrée/sortie se produit
     */
    public static void launchGame() throws IOException {
        Game game = new Game();
        game.start();
    }
}