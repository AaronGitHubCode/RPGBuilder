package app.rpgbuilder.utils;

import java.util.List;
import java.util.ArrayList;

import app.rpgbuilder.utils.items.Item;

public final class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(final Item item) {
        items.add(item);
    }

    public Item getItem(final int position) {
        return items.get(position);
    }

    public int size() {
        return items.size();
    }
}
