package app.rpgbuilder.utils.items.guns.bow;

import static java.lang.Math.round;
import static java.lang.Math.random;

import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.guns.Gun;

public class Arrow {
    private final Bow bindedBow;

    private final int damagePoints;

    public enum ArrowState {
        FAILED,
        SUCCESS
    }

    protected Bow getBindedBow() {
        return bindedBow;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public Arrow(final Bow bindedBow, final int damagePoints) {
        this.bindedBow = bindedBow;
        this.damagePoints = damagePoints;
    }

    public ArrowState throwArrow(final Entity entity) {
        final var rand = (int) round(random() * 100);

        if (bindedBow.getAim() >= rand) {
            entity.takeDamage(damagePoints);
            return ArrowState.SUCCESS;
        }

        return ArrowState.FAILED;
    }

}
