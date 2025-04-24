package lv1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<List<MenuItem>> menuLists = new ArrayList<>();
    private List<MenuItem> menuList = new ArrayList<>();

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void addMenuList(MenuItem menuItem) {
        menuList.add(menuItem);
    }


}
