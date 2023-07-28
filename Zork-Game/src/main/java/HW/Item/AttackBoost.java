package HW.Item;
import HW.Entity.Player;

public class AttackBoost extends UpgradeItem {
    int addDamage;

    public AttackBoost(String newName, int addDamage) {
        super(newName);
        this.addDamage = addDamage;
    }

    @Override
    public void itemEffect(Player player) {
        player.weapon.addDamage(addDamage);
    }

    @Override
    public void printEffect() {
        System.out.println("Upgrade Player attack by " + this.addDamage);
    }
}