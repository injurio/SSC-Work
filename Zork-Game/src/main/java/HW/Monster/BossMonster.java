package HW.Monster;

import HW.Item.Item;

public class BossMonster extends Monster {
    private final int superAttack;

    public BossMonster() {
        this.setHealthMax(200);
        this.setHostile(true);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public BossMonster(String name){
        this.setHealthMax(200);
        this.setHostile(true);
        this.setName(name);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public BossMonster(String name, String info) {
        this.setHealthMax(200);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
    }

    public BossMonster(String name, String info, Item drop) {
        this.setHealthMax(200);
        this.setHostile(true);
        this.setName(name);
        this.setInfo(info);
        this.setAttack(30);
        this.setHealth(200);
        this.superAttack = 80;
        this.drop = drop;
    }

    public int getSuperAttack() {
        return superAttack;
    }
}