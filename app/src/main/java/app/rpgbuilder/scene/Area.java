package app.rpgbuilder.scene;

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

    protected List<Item> getAreaItems() {
        return areaItems;
    }

    /*TODO: Area should be delete a item of areaItems every 3 minutes...*/
    @Override
    public void onAreaChanged(Item item) {
        if (item != null)
            initializeAreaListener(item);

        for (final Item it : areaItems) {
            if (it.getItemSpawnedTime().getTime() >= areaCreationDate.getTime()) {
                areaItems.remove(areaItems.size() - 1);
                final Calendar time = Calendar.getInstance();
                time.set(Calendar.MINUTE, Calendar.MINUTE + 3);

                areaCreationDate = time.getTime();

                break;
            }
        }
    }
}
