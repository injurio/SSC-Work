package HW.Command;

import HW.Game;

public class AppraisingCommand extends Command {
    public AppraisingCommand(Game game){
        super(game);
    }
    @Override
    public void execute(String arg) {
        game.getPlayer().printPlayerStatus();
    }
}
