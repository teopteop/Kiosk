package challenge.lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private static final Scanner sc = new Scanner(System.in);

    public void start(List<Menu> menus) {
        Order order = new Order();
        Menu chooseMenu;
        MenuItem chooseMenuItem;
        int choice = 0; //입력값을 받기 위한 변수

        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료  |  입력 시 종료됩니다.");

            if (order.getOrders().isEmpty()) { //첫실행, 주문 목록이 비어있을때
                choice = getInput(0, menus.size()); //카테고리 선택
            } else { //주문 목록이 있을때
                order.orderMenu(menus.size()); //주문메뉴 출력
                choice = getInput(0, menus.size() + 2); //카테고리, 주문메뉴 항목 인덱스 +2
            }

            if (choice == 0) {
                break;
            } else if (choice <= menus.size()) {
                chooseMenu = menus.get(choice - 1);
                chooseMenu.printMenuItemList();
                chooseMenuItem = chooseMenu.getMenuItem(getInput(1, chooseMenu.getMenuItemList().size()));
                chooseMenuItem.printMenuItem();
                order.addOrder(getInput(1, 2), chooseMenuItem);
                continue;
            } else if (choice == menus.size() + 1) {
                order.printOrders();
                System.out.println("[ Total ]\nW " + order.getTotalPrice() + "\n\n1. 주문  |  2. 메뉴판");
            }

            choice = getInput(1, 2);
            if (choice == 1) {
                System.out.println("주문이 완료되었습니다. 금액은 W " + order.getTotalPrice() + " 입니다.");
                break;
            }
        }
    }

    public static int getInput(int firstIndex, int lastIndex) {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input < firstIndex || input > lastIndex) {
                    throw new IndexOutOfBoundsException();
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요");
                sc.nextLine(); //버퍼비우기 안비우면 큰일남
            } catch (IndexOutOfBoundsException e) {
                System.out.println("선택지를 확인해주세요");
            }
        }
    }
}








