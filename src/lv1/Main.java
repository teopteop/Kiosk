package lv1;

public class Main {
    public static void main(String[] args) {
        MenuItem cheesBurger = new MenuItem("치즈버거", 5400, "치즈가 두 장 들어간 기본 버거");
        MenuItem chikenBurger = new MenuItem("치킨버거", 6200, "두툼한 치킨 패티가 들어간 버거");
        Menu hamburger = new Menu();
        hamburger.addMenuList(cheesBurger);
        hamburger.addMenuList(chikenBurger);

        System.out.println(hamburger.getMenuList().toString());
    }
}
