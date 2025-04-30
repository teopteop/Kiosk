package basic.lv3;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    List<MenuItem> menuItemList = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }
}
