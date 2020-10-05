package model;

public abstract class Weapon {
    public static void weapon(Character Hero) {
        Hero.setAttack(Hero.getAttack() + 5);
    }
}