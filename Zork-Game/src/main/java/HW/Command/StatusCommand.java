package HW.Command;

import HW.Game;

public class StatusCommand extends Command {

    public StatusCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        game.getPlayer().printPlayerStatus();
    }

}
