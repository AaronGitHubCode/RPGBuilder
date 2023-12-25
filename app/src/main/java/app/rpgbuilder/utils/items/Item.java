package app.rpgbuilder.utils.items;

public abstract class Item
implements IItemLike {
    private int imageResource;

    protected String id;

    private String name;
    private String description;

    public Item(final int imageResource, final String name, final String description) {
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

    public final String getDescription() {
        return description;
    }

    protected final void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object other) {
        final Item item = (Item) other;

        return id.equals(item.id);
    }
}
