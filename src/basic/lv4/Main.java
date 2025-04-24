package basic.lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        Menu hamburger = new Menu("Burgers");
        Menu drink = new Menu("Drinks");
        Menu dessert = new Menu("Desserts");

        menus.add(hamburger);
        menus.add(drink);
        menus.add(dessert);

        hamburger.addMenuItem(new MenuItem("ShackBurger", 6.9,
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("SmokeShack", 8.9,
                "베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("Cheeseburger", 6.9,
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("Hamburger", 5.4,
                "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk();
        kiosk.start(menus);
    }
}
