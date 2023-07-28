package HW.Command;

import HW.Game;
import HW.Item.Item;

public class TakeCommand extends Command {
    public TakeCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        pickItem(arg);
    }

    void pickItem(String item) {
        Item getItem = game.getCurrentArea().getItem(item);

        if (getItem == null) {
            System.out.println("That item is not here!");
        } else {
            game.getPlayer().getInventory().add(getItem);
            game.getCurrentArea().removeItem(item);
            System.out.println("Pick up " + item);
        }
    }
}
