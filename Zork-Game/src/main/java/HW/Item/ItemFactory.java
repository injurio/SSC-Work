package HW.Item;

import HW.Archives;

public class ItemFactory {
    Archives archives = new Archives();

    public Item createItem(ItemType type, String name) {
        switch (type) {
            case Potion:
                return new Potion(name, archives.getPotionBook().get(name));
            case FullRestore:
                return new FullRestore(name);
            case HealthBoost:
                return new HealthBoost(name, 50);
            case AttackBoost:
                return new AttackBoost(name, 50);
            case VictoryItem:
                return new VictoryItem(name);
        }
        throw new IllegalArgumentException("Unknown Monster Type");
    }
    public Item createItem(String name) {
        if (archives.getPotionBook().containsKey(name)) {
            return createItem(ItemType.Potion, name);
        } else if (archives.getFullRestoreBook().contains(name)) {
            return createItem(ItemType.FullRestore, name);
        } else if (archives.getHealthboostBook().contains(name)) {
            return createItem(ItemType.HealthBoost, name);
        } else if (archives.getAttackboostBook().contains(name)) {
            return createItem(ItemType.AttackBoost, name);
        } else if (archives.getVictoryItem().contains(name)) {
            return createItem(ItemType.VictoryItem, name);
        }
        throw new IllegalArgumentException("Unknown Item Type");
    }
}