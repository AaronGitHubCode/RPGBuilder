package app.rpgbuilder.utils.items;

import app.rpgbuilder.utils.entities.Entity;

public class Potion extends Item
implements IHealerItem {
    private Entity entity;

    private final int healthPoints;

    public Potion(final int healthPoints) {
        super("", "");

        this.healthPoints = healthPoints;

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
