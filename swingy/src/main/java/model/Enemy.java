package model;

public class Enemy {
    private String			name;
    private	int				health;
    private int				level;
    private int				attack;

    public Enemy() {
        name = null;
        health = 20;
        level = 0;
        attack = 5;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public void setHealth (int Health) {
        this.health = Health;
    }

    public void setAttack (int Attack) {
        this.attack = Attack;
    }

    public void setLevel (int level) {
        this.level = level;
    }

    public int getLevel () {
        return (level);
    }

    public int getHealth () {
        return (health);
    }

    public int getAttack () {
        return (attack);
    }

    public String getName () {
        return (name);
    }

    public void badMan (Character Hero) {
        setLevel(Hero.getLevel());
        setHealth(20 * getLevel());
        setName("bad man");
        setAttack(2 * getLevel());
    }

    public void veryBadMan (Character Hero) {
        setLevel(Hero.getLevel());
        setHealth(30 * getLevel());
        setName("very bad man");
        setAttack(5 * getLevel());
    }
}
