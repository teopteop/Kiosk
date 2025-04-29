package challenge.lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private static final Scanner sc = new Scanner(System.in);

    public void start(List<Menu> menus){
        Order order = new Order();
        Menu chooseMenu = null;
        MenuItem chooseMenuItem = null;
        int check = 0; //반복문의 상태를 조절하기 위한 변수
        int choice = 0; //선택을 위한 변수

        while(true){
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i+1) + ". " + menus.get(i).getCategory());
            } System.out.println("0. 종료  |  입력 시 종료됩니다.");

            if(order.getOrders().isEmpty()){ //첫실행, 주문목록이 비어있을때 흐름
                choice = getInput(0, menus.size()); //카테고리 선택
                if(choice == 0) {
                    break;
                } else {
                    chooseMenu = menus.get(choice-1);
                    chooseMenu.printMenuItemList();
                    chooseMenuItem = chooseMenu.getMenuItem(getInput(1, chooseMenu.getMenuItemList().size()));
                    chooseMenuItem.printMenuItem();
                    order.addOrder(getInput(1, 2), chooseMenuItem);
                    continue;
                }
            }

            //주문목록이 있을때 흐름
            order.orderMenu(menus.size());

            choice = getInput(0, menus.size()+2); //카테고리 선택
            if(choice == 0) {
                break;
            } else {
                chooseMenu = menus.get(choice-1);
                chooseMenu.printMenuItemList();
                chooseMenuItem = chooseMenu.getMenuItem(sc.nextInt());
                chooseMenuItem.printMenuItem();
                order.addOrder(sc.nextInt(), chooseMenuItem);
                continue;
            }


        }
    }

    public static int getInput(int firstIndex, int lastIndex){
        while (true) {
            try {
                int input = sc.nextInt();
                if (input < firstIndex || input > lastIndex){
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








