package HW.Monster;

import HW.Item.Item;
public class EliteMonster extends Monster {

    public EliteMonster() {
        this.setHealthMax(50);
        this.setHostile(true);
        this.setAttack(15);
        this.setHealth(50);
    }

    public EliteMonster(String name){
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(15);
        this.setHealth(50);
    }

    public EliteMonster(String name, String info) {
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(15);
        this.setHealth(50);
    }

    public EliteMonster(String name, String info, Item drop) {
        this.setHealthMax(50);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(15);
        this.setHealth(50);
        this.drop = drop;
    }
}