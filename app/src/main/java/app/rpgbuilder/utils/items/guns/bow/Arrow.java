package app.rpgbuilder.utils.items.guns.bow;

import app.rpgbuilder.utils.entities.Entity;

import java.util.Random;

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
        final int rand = new Random().nextInt(100);

        return rand >= 50 ? ArrowState.SUCCESS : ArrowState.FAILED;
    }

}
