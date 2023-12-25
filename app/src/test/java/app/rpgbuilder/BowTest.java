package app.rpgbuilder;

import org.junit.Test;

import app.rpgbuilder.math.Vector2;

import app.rpgbuilder.utils.entities.Enemy;
import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.guns.bow.Bow;

public class BowTest {
    @Test
    public void bowArrowCanDamageEntity() {
        final Bow bow = new Bow(new Bow.BowProperties(5, 2));
        final Entity enemy = new Enemy(10, "Pepe", new Vector2(0, 0), 0);

        bow.shoot(enemy);
        bow.shoot(enemy);
        bow.shoot(enemy);

        System.out.println(bow.getMunition());
        System.out.println(enemy.getHealth());
    }
}
