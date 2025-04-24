package basic.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String category;
    List<MenuItem> menuItemList = new ArrayList<>();

    Menu(String category){
        this.category = category;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }
}
