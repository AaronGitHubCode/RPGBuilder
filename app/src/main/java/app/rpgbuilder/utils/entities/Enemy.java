package app.rpgbuilder.utils.entities;

public class Enemy extends Entity {
    private int level;

    private int strength;
    private int magic;

    public Enemy(final int health, final String name, final int critical) {
        super(health, name);
    }

    public void attack(final Entity entity) {
        entity.setHealth(Math.min(entity.getHealth() - strength, 0));
    }

    public int getLevel() {
        return level;
    }

    public String getFormattedLevel() {
        return "Lvl.".concat(level < 10 ? "00".concat(String.valueOf(level)) : level < 100 ? "0".concat(String.valueOf(level)) : String.valueOf(level));
    }
}
