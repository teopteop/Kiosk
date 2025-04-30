package challenge.lv1;

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

    public void printMenuItemList() {
        System.out.println("[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItemList.size(); i++) {
            System.out.println((i + 1) + ". " +
                    menuItemList.get(i).getItemName() + " | W " +
                    menuItemList.get(i).getItemPrice() + " | " +
                    menuItemList.get(i).getItemDescription()
            );
        }
        System.out.println("0  |  뒤로가기");
    }

}
