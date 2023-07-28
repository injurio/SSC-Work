package HW.Item;

import HW.Entity.Player;
public class FullRestore extends Potion {
    public FullRestore(String newName) {
        super(newName);
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealth(player.getHealthMax());
    }

    @Override
    public void printEffect() {
        System.out.println("Heal to full health");
    }
}
