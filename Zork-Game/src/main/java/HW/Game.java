package HW;

import HW.Map.Map;
import HW.Map.Area;
import HW.Command.*;
import HW.Entity.*;
import HW.Item.*;
import HW.Monster.BossMonster;
import HW.Monster.Monster;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
    Map map;
    Player player;
    Monster target;
    Area currentArea;
    CommandFactory commandFactory;
    Parser parser;
    boolean finished = false;
    Archives archives = new Archives();
    List<String> mapFiles = new ArrayList<>();
    {
        mapFiles.add("D1.txt");
    }

    Game() {
        start();
        try {
            String input = inputMap();
            initialize(input);
        } catch (InputMismatchException i) {
            System.out.println("Unknown Map Name");
            i.printStackTrace();
        }
    }

    Game(String path) {
        start();
        initialize(path);
    }

    void initialize(String mapPath) {
        player = new Player(new Weapon(10));
        map = new Map(mapPath);
        currentArea = map.getArea("Camp");
        commandFactory = new CommandFactory(this);
        parser = new Parser(this.commandFactory);
    }

    String inputMap() {
        System.out.println("Please Input your Map.");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String map = scanner.nextLine();
        for (String mappath : mapFiles) {
            if (mappath.contains(map))
                return mappath;
        }
        throw new InputMismatchException();
    }

    public void start() {
        try {
            titleScreen();
            TimeUnit.SECONDS.sleep(2);
            printWelcome();
        } catch (InterruptedException ignored) {
        }
    }

    public void play() {
        map.printIntro();
        map.printDescription();
        System.out.println(this.currentArea.getAreaInfo());
        while (!finished) {
            if (!player.isAlive()) {
                printDeadbyMonster();
                finished = true;
                continue;
            } else if (player.getInventory().stream().anyMatch(o -> o.getClass().equals(VictoryItem.class))) {
                printDungeonClear();
                finished = true;
                continue;
            }
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.isUnknown()) {
                System.out.println("Unknown Command input!");
                continue;
            }
            if (commandLine.getCommandWord().equals("attack") && target == null) {
                String targetname = commandLine.getSecondWord();
                setTarget(currentArea.getMonster(targetname));
                if (this.target.getClass().getName().contains("Dragon")) {
                    System.out.println("Begin battle with " + target.getName());
                    bossCombat(this.player, (BossMonster) this.target);
                } else {
                    System.out.println("Begin battle with " + target.getName());
                    monsterCombat(this.player, this.target);
                }
                currentArea.removeDeathMonster();
            } else {
                Command command = commandFactory.getCommand(commandLine.getCommandWord());
                command.execute(commandLine.getSecondWord());
            }

        }
        System.out.println("Thank You For Playing");

    }

    void monsterCombat(Player player, Monster monster) {
        while (player.isAlive() && monster.isAlive()) {
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.isUnknown()) {
                System.out.println("Unknown Command input!");
                continue;
            }
            if (commandLine.getCommandWord().equals("go")) {
                System.out.println("You try to Run Away from Monster.");
                Command command = commandFactory.getCommand(commandLine.getCommandWord());
                command.execute(commandLine.getSecondWord());
                this.target = null;
                break;
            }
            Command command = commandFactory.getCommand(commandLine.getCommandWord());
            command.execute(commandLine.getSecondWord());
            System.out.println(target.getName() + " is attack you!");
            player.setHealth(player.getHealth() - monster.getAttack());
            player.printHealth();
            if (player.getHealth() <= 0) {
                player.dead();
            } else if (monster.getHealth() <= 0) {
                System.out.println(monster.getName() + " has been kill!");
                monster.dead();
                if (!monster.getDrop().getClass().getName().contains("Healitem")) {
                    System.out.println("You obtain " + monster.getDrop().getName() + "from killing " + monster.getName());
                    monster.getDrop().printEffect();
                    monster.getDrop().itemEffect(this.player);
                } else {
                    player.getInventory().add(monster.getDrop());
                }
            }

        }
        setTarget(null);
    }

    void bossCombat(Player player, BossMonster boss) {
        Random random = new Random();
        while (player.isAlive() && boss.isAlive()) {
            CommandLine commandLine = parser.getCommandLine();
            if (commandLine.getCommandWord().equals("go")) {
                System.out.println("Cannot run away from the Dragon!!!!.");
                continue;
            }
            Command command = commandFactory.getCommand(commandLine.getCommandWord());
            command.execute(commandLine.getSecondWord());
            if (random.nextInt(4) == 3) {
                System.out.println(boss.getName() + " is using super attack!");
                player.setHealth(player.getHealth() - boss.getSuperAttack());
                player.printHealth();

            }
            System.out.println(boss.getName() + " is attack you!");
            player.setHealth(player.getHealth() - boss.getAttack());
            player.printHealth();
            if (player.getHealth() <= 0) {
                player.dead();
            } else if (boss.getHealth() <= 0) {
                System.out.println(boss.getName() + " has been slay!");
                boss.dead();
                player.getInventory().add(boss.getDrop());
            }

        }
        setTarget(null);
    }

    public void titleScreen() {
        System.out.println("===============================");
        System.out.println("|                             |");
        System.out.println("|       Fantasy Zork!         |");
        System.out.println("|                             |");
        System.out.println("===============================");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Fantasy Zork!");
        System.out.println("In this game you will fight monsters.");
        System.out.println("And explore the dungeon map.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("Please Choose your Map.\n");
    }

    public Area getCurrentArea() {

        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {

        this.currentArea = currentArea;
    }

    public Map getMap() {

        return map;
    }

    public void finished() {

        this.finished = true;
    }

    public Player getPlayer() {

        return player;
    }

    public CommandFactory getCommandFactory() {

        return commandFactory;
    }

    public Monster getTarget() {
        return target;
    }

    public void setTarget(Monster target) {

        this.target = target;
    }

    public Archives getArchive() {

        return archives;
    }

    void printDungeonClear() {
        try {
            System.out.println("You slay the Boss Monster!!!!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println();
            System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            System.out.println("O                             O");
            System.out.println("O        Dungeon Clear!       O");
            System.out.println("O                             O");
            System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void printDeadbyMonster() {
        try {
            System.out.println("You been kill by the monster!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println();
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("X                             X");
            System.out.println("X        You are Dead!        X");
            System.out.println("X                             X");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}