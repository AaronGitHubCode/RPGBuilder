package app.rpgbuilder.utils.items;

public abstract class Item
implements IItemLike {
    protected String id;

    private String name;
    private String description;

    public Item(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    protected void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object other) {
        final Item item = (Item) other;

        return id.equals(item.id);
    }
}
