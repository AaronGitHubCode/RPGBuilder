package app.rpgbuilder.utils;

import app.rpgbuilder.math.Vector2;

public abstract class Entity {
    private String name;

    private final Vector2 screenPosition;

    public Entity(final Vector2 initialScreenPosition) {
        screenPosition = initialScreenPosition;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    protected Vector2 getScreenPosition() {
        return screenPosition;
    }

    public int x() {
        return screenPosition.getX();
    }

    public int y() {
        return screenPosition.getY();
    }
}
