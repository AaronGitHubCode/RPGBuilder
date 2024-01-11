package app.rpgbuilder.utils.items.guns.bow;

import app.rpgbuilder.R;

import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.guns.Gun;

public class Bow extends Gun {

    public static final int BOW_ICON = R.drawable.bow;

    private static final int TEST_DAMAGE_POINTS = 4;

    public record BowProperties(int aim, int speed) {}

    private final BowProperties properties;

    protected int munition;
    protected final Arrow[] arrows;

    /**
     * @param bow The linked bow for all arrows.
     * @return Static array with ten arrow objects.
     * */
    private static Arrow[] initializeArrows(final Bow bow) {
        final Arrow[] arrows = new Arrow[10];

        for (var i = 0; i < arrows.length; i++)
            arrows[i] = new Arrow(bow, TEST_DAMAGE_POINTS);

        return arrows;
    }

    /**
     * @param properties The properties of a Bow.
     * */
    public Bow(final BowProperties properties) {
        super(0, "Arrow", "Arrow description");

        this.properties = properties;

        arrows = initializeArrows(this);

        munition = arrows.length;
    }

    public int getMunition() {
        return munition;
    }

    public int getAim() {
        return properties.aim();
    }

    public int getSpeed() {
        return properties.speed();
    }

    protected BowProperties getProperties() {
        return properties;
    }

    protected void looseArrow() {
        if (munition-- < 0)
            munition = 0;
    }

    public boolean isMunitionEmpty() {
        return munition == 0;
    }

    /**
     * @param entity The attacked entity.
     * */
    @Override
    public void shoot(final Entity entity) {
        if (! isMunitionEmpty()) {
            if (arrows[munition - 1].throwArrow(entity) == Arrow.ArrowState.SUCCESS) {
                entity.takeDamage(arrows[munition - 1].getDamagePoints());
                arrows[munition - 1] = null;
            }

            looseArrow();
        }
    }

    /**
     * Drops the bow into the item container of a Area.
     * */
    @Override
    public void drop() {
        areaListener.onAreaChanged(this);
    }
}
