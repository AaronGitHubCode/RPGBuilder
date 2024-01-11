package app.rpgbuilder.mod.example;

import app.rpgbuilder.annotations.Mod;

import app.rpgbuilder.utils.items.guns.bow.Bow;

import app.rpgbuilder.utils.items.guns.bow.crossbow.CrossBow;

import java.util.Optional;

/**
 * Example of a mod for RPGBuilder
 *
 * TODO: Learn how to add mods with the use of .jar files.
 * Big problem, is Android OS. I need to learn how to add mods.
 *
 * @author AaronGitHubCode
 * @version 0.2.1
 * */

@Mod(author = "AaronGitHubCode",
        id = "Example.CrossBow",
        name = "CustomizedCrossBow",
        description = "Customized crossbow")

public class AutoFormBow extends CrossBow {

    public enum GunForm {
        CROSSBOW,
        SIMPLE_BOW
    }

    public AutoFormBow(Bow.BowProperties bowProperties) {
        super(bowProperties);
    }

    public Optional<Bow> getBowForm(GunForm form) {
        assert form != null;

        return form == GunForm.CROSSBOW
                ? Optional.of((CrossBow) this)
                : form == GunForm.SIMPLE_BOW
                ? Optional.of((Bow) this)
                : Optional.empty();
    }
}
