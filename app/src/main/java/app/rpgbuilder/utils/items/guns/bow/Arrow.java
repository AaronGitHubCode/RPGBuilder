/**
*    Clase Arrow
*    @author AaronGitHubCode
*    @version 0.1.0
*/

package app.rpgbuilder.utils.items.guns.bow;

import app.rpgbuilder.utils.entities.Entity;

import java.util.Random;

public class Arrow {
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
    *    @param bindedArrow Referencia a un objeto de tipo Bow para obtener sus estadísticas.
    *    @param damagePoints Los puntos de daños que puede causar la flecha al acertar el tiro a un enemigo. 
    */
    public Arrow(final Bow bindedBow, final int damagePoints) {
        this.bindedBow = bindedBow;
        this.damagePoints = damagePoints;
    }

    /**
    *    @params entity
    *    Referencia a la entidad a la que se le está lanzando la flecha.
    *    @return
    *    Devuelve el estado de la flecha.
    */
    public ArrowState throwArrow(final Entity entity) {
        final int rand = new Random().nextInt(100);

        return rand >= 50 ? ArrowState.SUCCESS : ArrowState.FAILED;
    }

}
