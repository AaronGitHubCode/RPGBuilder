package app.rpgbuilder.utils.items;

import app.rpgbuilder.utils.entities.Entity;

public class Potion extends Item
implements IHealerItem {
    private Entity entity;

    private static final int healthPoints = 10;

    public Potion() {
        super("Potion", "A simple potion to restore a little portion of health.");

        id = "POTION_ITEM";
    }

    @Override
    public void heal() {
        entity.setHealth(Math.min(entity.getHealth() + healthPoints, entity.MAX_HEALTH));
    }

    @Override
    public void asItem() {

    }
}
