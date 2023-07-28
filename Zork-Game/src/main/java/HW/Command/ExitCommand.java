package HW.Command;

import HW.Game;

public class ExitCommand extends Command{

    public ExitCommand(Game game){
        super(game);
    }

    @Override
    public void execute(String arg) {
        game.finished();

    }
}