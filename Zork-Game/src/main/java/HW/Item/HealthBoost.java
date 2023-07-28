package HW.Item;

import HW.Entity.Player;

public class HealthBoost extends UpgradeItem {
    int addHealth;

    public HealthBoost(String newName, int addHealth) {
        super(newName);
        this.addHealth = addHealth;
    }

    public HealthBoost(String newName, String info, int addHealth) {
        super(newName, info);
        this.addHealth = addHealth;
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealthMax(player.getHealthMax() + addHealth);
    }

    @Override
    public void printEffect() {
        System.out.println("Upgrade Player health by " + this.addHealth);
    }
}