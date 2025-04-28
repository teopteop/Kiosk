package challenge.lv1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public void start(List<Menu> menus){
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        Menu chooseMenu = null;
        MenuItem chooseMenuItem = null;
        boolean checkStop = true; //반복문을 멈출 변수
        int choice = 0; //선택을 위한 변수

        while(checkStop){

            printMenus(menus);

            if(order.getOrders().isEmpty()){

                chooseMenu = menus.get(sc.nextInt()-1);
                Menu.printMenuItemList(chooseMenu);

                chooseMenuItem = chooseMenu.getMenuItem(sc.nextInt());
                order.addOrder(sc.nextInt(),chooseMenuItem);
            }

            checkStop = false;
        }
        //스캐너 종료
    }

    public static void printMenus(List<Menu> menus){
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료  |  입력 시 종료됩니다.");
    }



}


