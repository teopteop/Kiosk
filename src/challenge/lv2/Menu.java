package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItemList = new ArrayList<>();

    Menu(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public MenuItem getMenuItem(int choice) {
        return menuItemList.get(choice - 1);
    }

}
