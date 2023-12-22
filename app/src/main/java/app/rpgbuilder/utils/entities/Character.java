package app.rpgbuilder.utils.entities;

import app.rpgbuilder.utils.Inventory;

public class Character extends Entity {
    private final Inventory inventory;

    public Character(final int health, final String name) {
        super(health, name);

        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
