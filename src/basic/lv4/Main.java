package basic.lv4;

public class Main {
    public static void main(String[] args) {
        Menu hamburger = new Menu();
        Menu drink = new Menu();
        hamburger.addMenuList(new MenuItem("치즈버거", 5400, "찐득한 치즈가 두 장 들어간 버거"));
        hamburger.addMenuList(new MenuItem("치킨버거", 6200, "두툼한 치킨 패티가 들어간 버거"));

        hamburger.printMenuList(hamburger);
    }
}
