package app.rpgbuilder.utils.items.guns.bow.crossbow;

import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.guns.bow.Arrow;
import app.rpgbuilder.utils.items.guns.bow.Bow;

public class CrossBow extends Bow {
    public CrossBow(BowProperties properties) {
        super(properties);
    }

    public void multipleShoot(Entity... entities) {
        for (final Entity entity : entities) {
            if (isMunitionEmpty()) {
                if (arrows[munition - 1].throwArrow(entity) == Arrow.ArrowState.SUCCESS) {
                    entity.takeDamage(arrows[munition - 1].getDamagePoints());
                    arrows[munition - 1] = null;
                }

                looseArrow();
            }
        }
    }
}
