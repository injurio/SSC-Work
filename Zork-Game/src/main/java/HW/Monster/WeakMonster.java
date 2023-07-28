package HW.Monster;

import HW.Item.Item;
public class WeakMonster extends Monster {

    public WeakMonster() {
        this.setHealthMax(20);
        this.setHostile(false);
        this.setAttack(5);
        this.setHealth(20);
    }

    public WeakMonster(String name){
        this.setHealthMax(20);
        this.setHostile(false);
        this.setName(name);
        this.setAttack(5);
        this.setHealth(20);
    }

    public WeakMonster(String name, String info) {
        this.setHealthMax(20);
        this.setHostile(false);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(5);
        this.setHealth(20);
    }

    public WeakMonster(String name, String info, Item drop) {
        this.setHealthMax(20);
        this.setHostile(false);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(5);
        this.setHealth(20);
        this.drop = drop;
    }
}