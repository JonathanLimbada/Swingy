package controller;

import model.Character;
import model.Enemy;
import model.Map;
import views.Console;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import static controller.Database.saveHero;
import static views.Console.*;

public class Game {
    private static Character Hero = null;
    private static Map Map = null;
    private static Enemy bad = null;

    public static void makeHero (String Name, String Race) throws IOException {
        Hero = new Character();
        Hero.setName(Name);
        Hero.setRace(Race);
        Map = new Map(Hero);
        saveHero(Hero, Map);
        game(Hero);
    }

    public static void game (Character Hero) throws IOException {
        printStats(Hero);
        instructions();
        move(Hero);
    }

    public static void movement (String direction, Character Hero) throws IOException {
        fight(Hero);
        if (direction.equals("south")){
            Hero.setPosY(Hero.getPosY() - 1);
        }
        else if (direction.equals("west")){
            Hero.setPosX(Hero.getPosX() - 1);
        }
        else if (direction.equals("east")){
            Hero.setPosX(Hero.getPosX() + 1);
        }
        else if (direction.equals("north")){
            Hero.setPosY(Hero.getPosY() + 1);
        }
        if (Hero.getPosX() == Map.getSize() || Hero.getPosX() < 0 || Hero.getPosY() == Map.getSize() || Hero.getPosY() < 0) {
            Map = new Map(Hero);
            newMap();
        }
        saveHero(Hero, Map);
        move(Hero);
    }

    public static void retreat (Character Hero) throws IOException {
        int Enemy = new Random().nextInt(100);
        if (Enemy < 50) {
            retreatFail();
        }
        else {
            retreatNice();
            move(Hero);
        }
    }

    public static void battle (Character Hero, Enemy Bad) throws IOException {
        ArrayList<String> war = new ArrayList<String>();
        while (Hero.getHealthPoints() > 0 && Bad.getHealth() > 0) {
            Bad.setHealth(Bad.getHealth() - Hero.getAttack());
            war.add("you have dealt " + Hero.getAttack() + " damage to the enemy");
            Hero.setHealthPoints(Hero.getHealthPoints() - Bad.getAttack());
            war.add("you have lost " + Bad.getAttack() + " points of health");
        }
        win(war);
        if (Hero.getHealthPoints() < 1) {
            System.out.println("your have been killed, your hero and Map have been reset");
            String Name = Hero.getName();
            String Race = Hero.getRace();
            Hero = new Character();
            Hero.setName(Name);
            Hero.setRace(Race);
            Map = new Map(Hero);
            saveHero(Hero, Map);
            Console console = new Console();
            console.Welcome();
        }
        System.out.println("you have won the battle");

    }

    public static void fight (Character Hero) throws IOException {
        int Enemy = new Random().nextInt(100);
        int Enemytype = new Random().nextInt(100);
        int art = new Random().nextInt(3) - 1;
        bad = new Enemy();
        if (Enemy < 20) {
            if (Enemytype < 60) {
                bad.badMan(Hero);
                encounter(1, Hero);
                Hero.setExpPoints(Hero.getExpPoints() + 300);
                battle(Hero, bad);
            }
            else if (Enemytype > 40) {
                bad.veryBadMan(Hero);
                encounter(2, Hero);
                battle(Hero, bad);
                Hero.setExpPoints(Hero.getExpPoints() + 400);
            }
            if (Enemy < 11) {
                if (art == 0 && sword().equals("yes"))
                    Hero.Weapon(bad);
                else if (art == 1 && helm().equals("yes"))
                    Hero.Helmet(bad);
                else if (art == 2 && arm().equals("yes"))
                    Hero.Armor(bad);
            }
        }
        if(Hero.getLevel() == 1 ) {
            if (Hero.getExpPoints() > 1000) {
                Hero.setLevel(2);
                System.out.println("you have leveled up");
            }}
            else if(Hero.getLevel() == 2 ) {
                if (Hero.getExpPoints() > 2450) {
                    Hero.setLevel(3);
                    System.out.println("you have leveled up");
                }
            }
            else if(Hero.getLevel() == 3 ) {
                if (Hero.getExpPoints() > 4000) {
                    Hero.setLevel(4);
                    System.out.println("you have leveled up");
                }
            }
            else if(Hero.getLevel() == 4 ) {
                if (Hero.getExpPoints() > 8050) {
                    Hero.setLevel(5);
                    System.out.println("you have leveled up");
                }
            }
            else if(Hero.getLevel() == 5 ) {
                if (Hero.getExpPoints() > 12200) {
                    Hero.setLevel(6);
                    System.out.println("you have leveled up");
                }
            }
    }
}
