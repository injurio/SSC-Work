package HW.Item;

import HW.Entity.Player;
public class Potion extends Item {
    int health;


    public Potion(String newName, int health) {
        super(newName);
        this.health = health;
    }

    public Potion(String newName) {
        super(newName);
    }


    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void printEffect() {
        System.out.printf("Heal %d health when used\n", health);
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealth(player.getHealth() + health);
    }
}
