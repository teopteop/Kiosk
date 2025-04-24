package basic.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuList = new ArrayList<>();

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void addMenuList(MenuItem menuItem) {
        menuList.add(menuItem);
    }

    public void printMenuList(Menu menu){
        int cnt = 1;
        for(MenuItem m : menu.getMenuList()){
            System.out.println(cnt + ". " + m.getItemName()+" | W "+m.getItemPrice()+" | "+m.getItemDescription());
            cnt++;
        }
    }

}
