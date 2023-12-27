package app.rpgbuilder.utils.items;

import app.rpgbuilder.scene.OnAreaListener;

import java.util.Calendar;
import java.util.Date;

public abstract class Item
implements IItemLike {

    private final Date itemSpawnedTime;

    private int imageResource;

    protected String id;

    private String name;
    private String description;

    /*TODO: Better implementation of that interface*/
    public OnAreaListener areaListener;

    public Item(final int imageResource, final String name, final String description) {
        this.itemSpawnedTime = Calendar.getInstance().getTime();
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
    }

    public final int getImageResource() {
        return imageResource;
    }

    public final void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public final String getName() {
        return name;
    }

    protected final void setName(final String name) {
        this.name = name;
    }

    public final Date getItemSpawnedTime() {
        return itemSpawnedTime;
    }

    public final String getDescription() {
        return description;
    }

    protected final void setDescription(final String description) {
        this.description = description;
    }

    public void setOnAreaListener(OnAreaListener areaListener) {
        this.areaListener = areaListener;
    }
}
