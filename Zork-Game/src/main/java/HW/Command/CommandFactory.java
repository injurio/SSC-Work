package HW.Command;

import HW.Game;

import java.util.*;

public class CommandFactory {
    Game game;

    public CommandFactory(Game game) {
        this.game = game;
    }

    private final Map<String, Command> commandMap = new HashMap<>();
    {
        commandMap.put("exit", new ExitCommand(game));
        commandMap.put("move", new MoveCommand(game));
        commandMap.put("take", new TakeCommand(game));
        commandMap.put("drop", new DropCommand(game));
        commandMap.put("attack", new AttackCommand(game));
        commandMap.put("use", new UseCommand(game));
        commandMap.put("status", new StatusCommand(game));
        commandMap.put("look", new LookCommand(game));
        commandMap.put("help", new HelpCommand(game));
    }

    public Command getCommand(String cmd) {
        return commandMap.get(cmd);
    }

    public boolean isCommand(String cmd) {
        return commandMap.containsKey(cmd);
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}