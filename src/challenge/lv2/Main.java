package challenge.lv2;

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

        drink.addMenuItem(new MenuItem("coke", 1.5,
                "톡 쏘는 탄산이 일품인 콜라"));
        drink.addMenuItem(new MenuItem("cherryCoke", 1.7,
                "체리향이 첨가된 탄산음료"));
        drink.addMenuItem(new MenuItem("Sprite", 1.3,
                "탄산이 가득한 사이다"));
        drink.addMenuItem(new MenuItem("zeroCoke", 1.5,
                "대체당을 이용해 칼로리를 낮춘 다이어터를 위한 콜라"));

        dessert.addMenuItem(new MenuItem("potato", 2.0,
                "바로 튀겨낸 바삭바삭한 후렌치 포테이토"));
        dessert.addMenuItem(new MenuItem("cheeseStick", 2.8,
                "통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 대표메뉴"));
        dessert.addMenuItem(new MenuItem("Coleslaw", 1.9,
                "아삭한 양상추와 상큼한 드레싱이 조화로운 간편 샐러드"));
        dessert.addMenuItem(new MenuItem("SquidRing", 2.8,
                "통오징어로 리얼한 식감과 풍미가 가득한 디저트"));

        Kiosk kiosk = new Kiosk();
        kiosk.start(menus);
    }
}
