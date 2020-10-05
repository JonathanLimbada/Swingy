package model;

public class Map {
    static private int		size;
    static private int	map[][];

    private static void createMap(Character character) {
        size = (character.getLevel() - 1) * 5 + 10 - (character.getLevel() % 2);
        character.setPosX(size / 2);
        character.setPosY(size / 2);
        loadMap(size);
    }

    public Map(Character character) {
            createMap(character);
    }

    public static void loadMap(int size) {
        map = new int[size][size];
    }

    public void expandMap(Character character) {
        createMap(character);
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Map.size = size;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

}