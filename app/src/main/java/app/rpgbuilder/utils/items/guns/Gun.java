package app.rpgbuilder.utils.items.guns;

import app.rpgbuilder.utils.items.Item;

import app.rpgbuilder.utils.entities.Entity;

public abstract class Gun extends Item {
    public Gun(int imageResource, String name, String description) {
        super(imageResource, name, description);
    }

    public abstract void shoot(Entity entity);
}
