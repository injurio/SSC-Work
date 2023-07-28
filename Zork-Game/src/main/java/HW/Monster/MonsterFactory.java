package HW.Monster;

import HW.Item.Item;
import HW.Item.ItemFactory;
import HW.Archives;
public class MonsterFactory {
    Archives archives = new Archives();

    public enum MonsterType {
        WeakMonster, EliteMonster, BossMonster
    }

    public Monster createMonster(MonsterType type) {
        switch (type) {
            case WeakMonster:
                return new WeakMonster();
            case EliteMonster:
                return new EliteMonster();
            case BossMonster:
                return new BossMonster();
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }

    public Monster createMonster(MonsterType type, String name) {
        switch (type) {
            case WeakMonster:
                return new WeakMonster(name, archives.getWeakMonsterBook().get(name).getKey());
            case EliteMonster:
                return new EliteMonster(name, archives.getEliteMonsterBook().get(name).getKey());
            case BossMonster:
                return new BossMonster(name, archives.getBossMonsterBook().get(name).getKey());
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }

    public Monster createMonster(MonsterType type, String name, String info) {
        switch (type) {
            case WeakMonster:
                return new WeakMonster(name, info);
            case EliteMonster:
                return new EliteMonster(name, info);
            case BossMonster:
                return new BossMonster(name, info);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }
    public Monster createMonster(MonsterType type, String name, String info, Item drop) {
        switch (type) {
            case WeakMonster:
                return new WeakMonster(name, info, drop);
            case EliteMonster:
                return new EliteMonster(name, info, drop);
            case BossMonster:
                return new BossMonster(name, info, drop);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }
}

