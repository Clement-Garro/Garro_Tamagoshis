// src/main/java/tamagoshi/Tamagoshi.java
package tamagoshi;

import java.util.Random;

/**
 * Classe de base pour les Tamagoshis.
 */
public abstract class Tamagoshi {
    public static final int AGE_LIMIT = 10;
    protected static final Random random = new Random();

    protected String name;
    protected int age;
    protected int energy;
    protected int maxEnergy;
    protected int feedAlertLevel;
    protected int fun;
    protected int maxFun;
    protected int funAlertLevel;

    public Tamagoshi(String name) {
        this.name = name;
        this.age = 0;
        this.maxEnergy = generateRandomNumberBetween(5, 9);
        this.energy = generateRandomNumberBetween(3, 5);
        this.feedAlertLevel = generateRandomNumberBetween(3, 5);
        this.maxFun = generateRandomNumberBetween(5, 9);
        this.fun = generateRandomNumberBetween(3, 5);
        this.funAlertLevel = generateRandomNumberBetween(3, 5);
    }

    protected int generateRandomNumberBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public abstract void expressEmotion();

    public abstract void decrementState();

    public boolean isAlive() {
        System.out.println("Je suis " + name + " et j'ai " + energy + " d'énergie, " + fun + " de fun et " + age + " ans.");
        return energy > 0 && fun > 0;
    }

    public String feed() {
        boolean wasHungry = energy < feedAlertLevel;
        energy += generateRandomNumberBetween(1, 3);
        if (energy > maxEnergy) {
            energy = maxEnergy;
        }
        return wasHungry ? "Merci !" : "Je n'avais pas très faim...";
    }

    public String play() {
        boolean wasBored = fun < funAlertLevel;
        fun += generateRandomNumberBetween(1, 3);
        if (fun > maxFun) {
            fun = maxFun;
        }
        return wasBored ? "On se marre !" : "Je n'avais pas très envie de jouer...";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getType();
}