// src/main/java/tamagoshi/BigPlayerTamagoshi.java
package tamagoshi;

/**
 * Classe représentant un Tamagoshi qui aime beaucoup jouer.
 */
public class BigPlayerTamagoshi extends Tamagoshi {

    public BigPlayerTamagoshi(String name) {
        super(name);
    }

    @Override
    public void expressEmotion() {
        if (energy < feedAlertLevel) {
            System.out.println(name + " : je suis affamé !");
        } else if (fun < funAlertLevel) {
            System.out.println(name + " : je m'ennuie à mourir !");
        } else {
            System.out.println(name + " : Tout va bien !");
        }
    }

    @Override
    public void decrementState() {
        energy -= 1;
        fun -= 2; // Perd plus de fun
        age += 1;
    }

    @Override
    public String getType() {
        return "BigPlayer";
    }
}