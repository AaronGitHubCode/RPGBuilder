package app.rpgbuilder.utils.items.guns.bow.crossbow;

import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.guns.bow.Bow;

import java.util.List;

/**
 * @author AaronGitHubCode
 * @version 0.2.1
 * */
public class CrossBow extends Bow {

    public CrossBow(BowProperties properties) {
        super(properties);
    }

    /**
     * <h1>#multipleShoot</h1>
     * <hr/><br/>
     * Shoot a arrow to all entities marked.
     * @param entities The attacked entities.
     * */
    public void multipleShoot(Entity... entities) {
        if (entities.length > 3)
            return;

        List.of(entities).forEach(this::shoot);
    }
}
