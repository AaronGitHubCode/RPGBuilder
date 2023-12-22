package app.rpgbuilder.utils.entities;

import app.rpgbuilder.math.Vector2;

import java.util.Random;

public class Enemy extends Entity
implements IBattler {

    private int level;

    private int strength;
    private int magic;

    public Enemy(final int health, final String name, final Vector2 position, final int critical) {
        super(health, name, position);
    }

    @Override
    public void attack(final Entity entity) {
        entity.setHealth(Math.min(entity.getHealth() - strength, 0));
    }

    @Override
    public void deffend() {

    }
}
