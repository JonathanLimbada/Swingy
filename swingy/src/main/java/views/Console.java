package views;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Character;
import model.Enemy;

import static controller.Database.loadHero;
import static controller.Game.*;

public class Console {
    private final static Scanner scanner = new Scanner(System.in);

    public static void retreatFail() {
        System.out.println("you're attempt to retreat was unsuccessful, you must now fight");
    }

    public static void win(ArrayList<String> fight) {
        for(int i = 0; i < fight.size(); i++) {
            System.out.println(fight.get(i));
        }
    }

    public static void retreatNice () {
        System.out.println("retreat successful");
    }

    public static void Welcome() throws IOException {
        System.out.println("Welcome to Swingy!");
        System.out.println("press '1' to Create a hero");
        System.out.println("press '2' to Select a previously created hero");
        String input = scanner.nextLine();
        if (input.equals("quit"))
            System.exit(0);
        if (input.equals("1"))
            newHero();
        else if (input.equals("2"))
            oldHero();
        else {
            Welcome();
        }
    }

    public static void newHero () throws IOException {
        System.out.println("Enter your characters name");
        System.out.print("Name: ");
        String Name = scanner.nextLine();
        System.out.println("Enter your characters race");
        System.out.print("Race: ");
        String Race = scanner.nextLine();
        makeHero(Name, Race);
    }

    public static void oldHero () throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./save.txt"));
            String line = null;
            try {
                line = reader.readLine();
                System.out.println("SAVED HERO");
                String name = line.split(" ")[1];
                System.out.println(name);
                System.out.println("Select a saved hero");
                String load = scanner.nextLine();
                if (load.equals("quit"))
                    System.exit(0);
                if (!load.equals(name)) {
                    System.out.println("that hero does not exist");
                    oldHero();
                }
                else {
                    loadHero(name);
                }
            } catch (IOException e) {
                System.out.println("there are no saved heros");
                Welcome();
            }
            System.out.println(line.split(" ")[1]);
        } catch (FileNotFoundException e) {
            System.out.println("there are no saved heros");
            Welcome();
        }


    }

    public static void move (Character Hero) throws IOException {
        System.out.println("please pick a direction to move");
        String move = scanner.nextLine();
        if (move.equals("quit"))
            System.exit(0);
        if (!move.equalsIgnoreCase("north") && !move.equals("west") && !move.equals("east") && !move.equals("south")) {
            move(Hero);
        }
        movement(move, Hero);
    }

    public static String sword() {
        System.out.println("you have acquired a weapon artifact, This will increase your attack");
        System.out.println("please type 'yes' to keep it or 'no' to discard it");
        String yes = scanner.nextLine();
        if (yes.equals("quit"))
            System.exit(0);
        if (yes.equals("yes") || yes.equals("no"))
           return (yes);
        sword();
        return ("idk");
    }

    public static String helm() {
        System.out.println("you have acquired a helmet artifact, This will increase your health");
        System.out.println("please type 'yes' to keep it or 'no' to discard it");
        String yes = scanner.nextLine();
        if (yes.equals("quit"))
            System.exit(0);
        if (yes.equals("yes") || yes.equals("no"))
            return (yes);
        helm();
        return ("idk");
    }

    public static String arm() {
        System.out.println("you have acquired a weapon artifact, This will increase your defence");
        System.out.println("please type 'yes' to keep it or 'no' to discard it");
        String yes = scanner.nextLine();
        if (yes.equals("quit"))
            System.exit(0);
        if (yes.equals("yes") || yes.equals("no"))
            return (yes);
        arm();
        return ("idk");
    }

    public static void instructions() {
        System.out.println("Swingy is a Fantsy role playing game");
        System.out.println("Type commands to move your character 'north', 'east', 'west', and 'south'");
        System.out.println("when encountering an enemy use the command 'fight' to battle and 'run' to retreat");
        System.out.println("to close the game, use the command 'quit");
    }

    public static void encounter(int i, Character Hero) throws IOException {
        if (i == 1)
            System.out.println("you have encountered a bad man, he will try and do bad things to you 'fight' to battle the foe, type 'run' to attempt to retreat");
        if (i == 2)
            System.out.println("you have encountered a very bad man, he will try and do really bad things to you 'fight' to battle the foe, type 'run' to attempt to retreat");
        String battle = scanner.nextLine();
        if (battle.equals("quit"))
            System.exit(0);
        if (!battle.equals("fight") && !battle.equals("run"))
            encounter(i, Hero);
        else if (battle.equals("run")) {
            retreat(Hero);
        }
    }

    public static void newMap () throws IOException {
        System.out.println("your character has reached the edge of the map and completed the level");
        System.out.println("your character is now entering a new map");
        System.out.println("Type commands to move your character 'north', 'east', 'west', and 'south'");
    }

    public static void printStats(Character Hero) {
        System.out.println("Your heros stats are ...");
        System.out.print("Name:      ");
        System.out.println(Hero.getName());
        System.out.print("Race:      ");
        System.out.println(Hero.getRace());
        System.out.print("Level:     ");
        System.out.println(Hero.getLevel());
        System.out.print("XP points: ");
        System.out.println(Hero.getExpPoints());
        System.out.print("Attack:    ");
        System.out.println(Hero.getAttack());
        System.out.print("Defence:   ");
        System.out.println(Hero.getDefence());
        System.out.print("Health:    ");
        System.out.println(Hero.getHealthPoints());
    }
}
