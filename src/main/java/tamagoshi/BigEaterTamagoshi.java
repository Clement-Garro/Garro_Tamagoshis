// src/main/java/tamagoshi/BigEaterTamagoshi.java
package tamagoshi;

/**
 * Classe représentant un Tamagoshi qui consomme beaucoup d'énergie.
 */
public class BigEaterTamagoshi extends Tamagoshi {

    public BigEaterTamagoshi(String name) {
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
        energy -= 2; // Consomme plus d'énergie
        fun -= 1;
        age += 1;
    }

    @Override
    public String getType() {
        return "BigEater";
    }
}