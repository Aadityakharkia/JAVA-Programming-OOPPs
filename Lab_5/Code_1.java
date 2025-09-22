import java.util.ArrayList;
import java.util.Scanner;

interface Saveable {
    ArrayList<String> write();
    void read(ArrayList<String> savedValues);
}

class Player implements Saveable {
    private String name;
    private int health;
    private int strength;

    public Player(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public ArrayList<String> write() {
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        values.add(String.valueOf(health));
        values.add(String.valueOf(strength));
        return values;
    }

    public void read(ArrayList<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            name = savedValues.get(0);
            health = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
        }
    }

    public String toString() {
        return "Player{name='" + name + "', health=" + health + ", strength=" + strength + "}";
    }
}

class Monster implements Saveable {
    private String type;
    private int damage;

    public Monster(String type, int damage) {
        this.type = type;
        this.damage = damage;
    }

    public ArrayList<String> write() {
        ArrayList<String> values = new ArrayList<>();
        values.add(type);
        values.add(String.valueOf(damage));
        return values;
    }

    public void read(ArrayList<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            type = savedValues.get(0);
            damage = Integer.parseInt(savedValues.get(1));
        }
    }

    public String toString() {
        return "Monster{type='" + type + "', damage=" + damage + "}";
    }
}

public class Code_1 {
    public static void main(String[] args) {
        Player player = new Player("Hero", 100, 50);
        System.out.println(player);
        saveObject(player);

        ArrayList<String> playerData = new ArrayList<>();
        playerData.add("Warrior");
        playerData.add("120");
        playerData.add("70");
        loadObject(player, playerData);
        System.out.println(player);

        Monster monster = new Monster("Dragon", 200);
        System.out.println(monster);
        saveObject(monster);

        ArrayList<String> monsterData = new ArrayList<>();
        monsterData.add("Goblin");
        monsterData.add("80");
        loadObject(monster, monsterData);
        System.out.println(monster);
    }

    public static void saveObject(Saveable objectToSave) {
        for (String value : objectToSave.write()) {
            System.out.println("Saving " + value);
        }
    }

    public static void loadObject(Saveable objectToLoad, ArrayList<String> values) {
        objectToLoad.read(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter a value (or type 'quit' to finish):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                quit = true;
            } else {
                values.add(input);
            }
        }
        return values;
    }
}