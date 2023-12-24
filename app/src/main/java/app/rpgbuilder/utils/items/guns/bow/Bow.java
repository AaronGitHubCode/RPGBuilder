package app.rpgbuilder.utils.items.guns.bow;

import app.rpgbuilder.utils.items.guns.Gun;

public final class Bow extends Gun {
    private int aim;

    private final Arrow[] arrows;

    private static Arrow[] initializeArrows(final Bow bow) {
        final Arrow[] arrows = new Arrow[10];

        for (var i = 0; i < arrows.length; i++)
            arrows[i] = new Arrow(bow, 10);

        return arrows;
    }

    public Bow(final int aim) {
        this.aim = aim;

        arrows = initializeArrows(this);
    }

    int getAim() {
        return aim;
    }

}
