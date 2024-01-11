package app.rpgbuilder.utils.items.potions;

import app.rpgbuilder.R;
import app.rpgbuilder.utils.entities.Entity;
import app.rpgbuilder.utils.items.Item;

public final class Potion extends Item
implements IHealer {

    private final int healthPoints;

    public Potion(int healthPoints) {
        super(R.drawable.potion, "Potion", "Heal 20 health points");

        this.healthPoints = healthPoints;
    }

    @Override
    public void heal(Entity entity) {
        if (entity.isAlive()) {
            entity.setHealth(Math.min(entity.getHealth() + healthPoints, entity.MAX_HEALTH));
        }
    }

    @Override
    public void drop() {
        areaListener.onAreaChanged(this);
    }
}
