package HW.Entity;

import HW.Item.Item;
import HW.Item.Weapon;

import java.util.ArrayList;
import java.util.List;


public class Player extends Entity {
    private List<Item> inventory = new ArrayList<>();
    public Weapon weapon;

    public Player(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDamage() {
        return this.weapon.getDamage();
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void printHealth() {
        System.out.printf("Player Health: %d/%d\n", this.getHealth(), this.getHealthMax());
    }

    public void printDamage() {
        System.out.printf("Current Weapon Damage: %d\n", this.weapon.getDamage());
    }

    public void printInventory() {
        if (inventory.size() == 0) {
            System.out.println("You are not carry anything");
        } else {
            StringBuilder inv = new StringBuilder();
            for (Item item : inventory) {
                inv.append(item.getName()).append(" ");
            }
            System.out.println("You are carrying:");
            System.out.println(inv);
        }
    }

    public void printPlayerStatus() {
        this.printHealth();
        this.printDamage();
        this.printInventory();
    }


}