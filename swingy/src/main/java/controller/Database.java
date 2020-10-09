package controller;

import java.io.*;
import java.util.Set;

import model.*;
import model.Character;

import static controller.Game.game;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Database {
    public static PrintWriter writer;

    public static void saveHero (Character Hero, Map map) throws IOException {
        writer = new PrintWriter(new FileWriter("./save.txt"));
        writer.println("NAME " + Hero.getName());
        writer.println("RACE " + Hero.getRace());
        writer.println("DEFENCE " + Hero.getDefence());
        writer.println("HEALTH " + Hero.getHealthPoints());
        writer.println("XP " + Hero.getExpPoints());
        writer.println("ATTACK " + Hero.getAttack());
        writer.println("LEVEL " + Hero.getLevel());
        writer.println("POSX " + Hero.getPosX());
        writer.println("POSY " + Hero.getPosY());
        writer.println("MAP " + map.getSize());
        writer.println("END");
        writer.close();
    }

    public static void loadHero(String Name) throws IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        BufferedReader reader = new BufferedReader(new FileReader("./save.txt"));
        String line = reader.readLine();
        Character Hero = null;
        Hero = new Character();
        Map map = null;
        map = new Map(Hero);
        while (!line.equals("END")) {
            if (line.split(" ")[0].equals("NAME"))
                Hero.setName(line.split(" ")[1]);
            if (line.split(" ")[0].equals("RACE"))
                Hero.setRace(line.split(" ")[1]);
            if (line.split(" ")[0].equals("DEFENCE"))
                Hero.setDefence(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("HEALTH"))
                Hero.setHealthPoints(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("XP"))
                Hero.setExpPoints(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("ATTACK"))
                Hero.setAttack(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("LEVEL"))
                Hero.setLevel(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("POSX"))
                Hero.setPosX(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("POSY"))
                Hero.setPosY(Integer.parseInt(line.split(" ")[1]));
            if (line.split(" ")[0].equals("MAP"))
                Map.setSize(Integer.parseInt(line.split(" ")[1]));
            line = reader.readLine();
        }
        Set<ConstraintViolation<Character>> constraintViolations = validator.validate(Hero);

        for (ConstraintViolation<Character> violation : constraintViolations)
            System.out.println("oof");
        Map.loadMap(Map.getSize());
        game(Hero);
    }
}
