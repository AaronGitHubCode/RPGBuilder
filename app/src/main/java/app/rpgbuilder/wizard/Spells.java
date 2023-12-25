package app.rpgbuilder.wizard;

import app.rpgbuilder.utils.entities.Entity;

public enum Spells {
    FIRE,
    ICE;

    public void magicAttack(Entity entity) {
        switch (this) {
            case FIRE, ICE -> entity.takeDamage(4);
        }
    }
}
