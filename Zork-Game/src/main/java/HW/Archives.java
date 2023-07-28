package HW;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Archives {
    private Map<String, Pair<String, String>> weakMonsterBook = new HashMap<>();
    private Map<String, Pair<String, String>> eliteMonsterBook = new HashMap<>();
    private Map<String, Pair<String, String>> bossMonsterBook = new HashMap<>();
    private Map<String, Integer> potionBook = new HashMap<>();
    private List<String> fullRestoreBook = new ArrayList<>();
    private List<String> healthboostBook = new ArrayList<>();
    private List<String> attackboostBook = new ArrayList<>();
    private List<String> victoryItem = new ArrayList<>();
    private File monsterData = new File("mapdata\\MonsterLibrary.txt");
    private File itemsData = new File("mapdata\\ItemLibrary.txt");

    public Archives() {
        writeAllMonsterBook();
        writeAllItemBook();
    }

    public Map<String, Pair<String, String>> getWeakMonsterBook() {

        return weakMonsterBook;
    }

    public Map<String, Pair<String, String>> getEliteMonsterBook() {

        return eliteMonsterBook;
    }

    public Map<String, Pair<String, String>> getBossMonsterBook() {

        return bossMonsterBook;
    }

    public Map<String, Integer> getPotionBook() {

        return potionBook;
    }
    public List<String> getFullRestoreBook() {

        return fullRestoreBook;
    }
    public List<String> getHealthboostBook() {

        return healthboostBook;
    }

    public List<String> getAttackboostBook() {

        return attackboostBook;
    }

    public List<String> getVictoryItem() {

        return victoryItem;
    }

    public void listBookEntry(List<String> book) {
        System.out.println(book.toString());
    }

    public void listBookEntry(Map<String, ?> book) {
        System.out.println(book.keySet().toString());
    }

    void writeAllMonsterBook() {
        try {
            Scanner scanner = new Scanner(monsterData);
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                if (current.contains("WeakMonster:")) {
                    writeMonsterBook(current, scanner, weakMonsterBook);
                } else if (current.contains("EliteMonster:")) {
                    writeMonsterBook(current, scanner, eliteMonsterBook);
                } else if (current.contains("BossMonster:")) {
                    writeMonsterBook(current, scanner, bossMonsterBook);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeMonsterBook(String current, Scanner scanner, Map<String, Pair<String, String>> monstersBook) {
        String name;
        String info;
        String drop;
        int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
        for (int i = 0; i < amount; i++) {
            current = scanner.nextLine();
            name = current.substring(current.indexOf(":") + 1);
            current = scanner.nextLine();
            info = current.substring(current.indexOf(":") + 1).replaceAll("\\.", ".\n");
            current = scanner.nextLine();
            drop = current.substring(current.indexOf("=") + 1);
            monstersBook.put(name, new Pair<>(info, drop));
        }
    }

    void writeAllItemBook() {
        try {
            Scanner scanner = new Scanner(itemsData);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (current.contains("Heal:")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        String heal = scanner.next();
                        if (heal.contains("max")) {
                            healthboostBook.add(name);
                        } else {
                            int healnum = Integer.parseInt(heal.replaceAll("[\\D]", ""));
                            potionBook.put(name, healnum);
                        }
                    }
                } else if (current.contains("HealthBoost:")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        healthboostBook.add(name);
                    }
                } else if (current.contains("AttackBoost")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        attackboostBook.add(name);
                    }
                } else if (current.contains("Victory")) {
                    int amount = Integer.parseInt(current.replaceAll("[\\D]", ""));
                    for (int i = 0; i < amount; i++) {
                        String name = scanner.next();
                        victoryItem.add(name);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}