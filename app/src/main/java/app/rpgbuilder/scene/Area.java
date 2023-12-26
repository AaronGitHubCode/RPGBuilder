package app.rpgbuilder.scene;

import app.rpgbuilder.utils.entities.Entity;
import app.rpgbuilder.utils.items.IItemLike;
import app.rpgbuilder.utils.items.Item;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Area
implements OnAreaListener {
    private Date areaCreationDate;

    private final List<Item> areaItems;

    private void initializeAreaListener(Item item) {
        item.setOnAreaListener(this);
        areaItems.add(item);
    }

    public Area() {
        final Calendar areaCreationDate = Calendar.getInstance();
        areaCreationDate.set(Calendar.MINUTE, Calendar.MINUTE + 3);

        this.areaCreationDate = areaCreationDate.getTime();
        areaItems = new ArrayList<>();
    }

    public void addItemToAreaContainer(Item item) {
        areaItems.add(item);
    }

    protected List<Item> getAreaItems() {
        return areaItems;
    }

    /*TODO: Area should be delete a item of areaItems every 3 minutes...*/
    @Override
    public boolean onAreaChanged(Item it) {
        boolean checker = false;

        for (final Item item : areaItems) {
            if (item.areaListener != null) {
                checker = true;
                break;
            }
        }

        if (it.getItemSpawnedTime().getTime() > areaCreationDate.getTime()) {

        }

        return checker;
    }
}
