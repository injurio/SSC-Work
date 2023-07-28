package HW.Command;

import HW.Game;
import HW.Map.Area;

public class MoveCommand extends Command {
    public MoveCommand(Game game){
        super(game);
    }
    @Override
    public void execute(String arg) {
        System.out.println("Move " + arg);
        moveRoom(arg);
    }

    private void moveRoom(String direction) {
        Area nextArea = game.getCurrentArea().getExit(direction);
        if (nextArea == null) {
            System.out.println("There is no exit!");
        } else {
            game.setCurrentArea(nextArea);
            System.out.println(nextArea.getAreaInfo());
        }
    }
}