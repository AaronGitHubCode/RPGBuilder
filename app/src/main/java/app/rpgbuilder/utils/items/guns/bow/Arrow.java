/**
*    Clase Arrow
*    @author AaronGitHubCode
*    @version 0.1.0
*/

package app.rpgbuilder.utils.items.guns.bow;

import app.rpgbuilder.scene.OnAreaListener;

import app.rpgbuilder.utils.entities.Entity;

import app.rpgbuilder.utils.items.Item;

import java.util.Random;

public class Arrow extends Item {
    private final Bow bindedBow;

    private final int damagePoints;

    public enum ArrowState {
        FAILED,
        SUCCESS
    }

    protected Bow getBindedBow() {
        return bindedBow;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    /**
    *    Constructor objeto Arrow
    *    @param bindedBow Referencia a un objeto de tipo Bow para obtener sus estadísticas.
    *    @param damagePoints Los puntos de daños que puede causar la flecha al acertar el tiro a un enemigo. 
    */
    public Arrow(final Bow bindedBow, final int damagePoints) {
        super(0, "Arrow", "Simple arrow with nothing special");

        this.bindedBow = bindedBow;
        this.damagePoints = damagePoints;
    }

    /**
    *    @param entity
    *    Referencia a la entidad a la que se le está lanzando la flecha.
    *    @return
    *    Devuelve el estado de la flecha.
    */
    public ArrowState throwArrow(final Entity entity) {
        final int rand = new Random().nextInt(100);

        return rand >= 50 ? ArrowState.SUCCESS : ArrowState.FAILED;
    }

    @Override
    public void drop() {
        areaListener.onAreaChanged(this);
    }
}
