package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItemList = new ArrayList<>();

    Menu(String category){
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

    public MenuItem getMenuItem(int choose) {
        return menuItemList.get(choose-1);
    }

    public static void printMenuItemList(Menu menu) {
        System.out.println("[ " + menu.getCategory().toUpperCase() + " MENU ]");
        for (int i = 0; i < menu.getMenuItemList().size(); i++) {
            System.out.println((i+1) + ". " +
                    menu.getMenuItemList().get(i).getItemName() + " | W " +
                    menu.getMenuItemList().get(i).getItemPrice() + " | " +
                    menu.getMenuItemList().get(i).getItemDescription()
            );
        }
    }

}
