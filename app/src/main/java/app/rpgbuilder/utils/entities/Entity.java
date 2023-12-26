package app.rpgbuilder.utils.entities;

import app.rpgbuilder.math.Vector2;
import app.rpgbuilder.scene.OnAreaListener;

public abstract class Entity {
    public final int MAX_HEALTH;

    private int health;

    private final String name;

    private Vector2 position;

    public Entity(final int health, final String name) {
        MAX_HEALTH = health;

        this.health = health;
        this.name = name;
    }

    public Entity(final int health, final String name, final Vector2 position) {
        MAX_HEALTH = health;

        this.health = health;
        this.name = name;
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(final int damagePoints) {
        if (health - damagePoints >= 0)
            health -= damagePoints;
        else
            health = 0;
    }

    public String getName() {
        return name;
    }

    public int x() {
        return position.getX();
    }

    public int y() {
        return position.getY();
    }
}
