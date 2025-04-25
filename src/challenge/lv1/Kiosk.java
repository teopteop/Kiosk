package challenge.lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public void start(List<Menu> menus){
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        while(true) {
            try {
                int cnt = 1; //반복 사용할 카운트 변수
                int choice; //선택지를 입력받을 변수
                System.out.println("[ MAIN MENU ]");

                for (Menu m : menus) {
                    System.out.println(cnt + ". " + m.getCategory());
                    cnt++;
                }

                System.out.println("0. 종료  |  입력 시 종료됩니다.");
                Menu chooseMenu = null;

                if(!order.getOrders().isEmpty()){ //주문목록이 있을때 진행흐름
                    int orderChoice = cnt++;
                    int cancleChoice = cnt;
                    System.out.println("--------------------------------");
                    System.out.println("[ ORDER MENU ]");
                    System.out.println(orderChoice + ". Orders    | 장바구니를 확인 후 주문합니다.");
                    System.out.println(cancleChoice + ". cancel    | 진행중인 주문을 취소합니다.");
                    System.out.println("--------------------------------");

                    choice = sc.nextInt();

                    if (choice == 0) {
                        System.out.println("프로그램을 종료합니다.");
                        System.out.println("--------------------------------");
                        break;
                    } else if(choice == orderChoice) {
                        System.out.println("[ ORDERS ]");
                        System.out.println("--------------------------------");
                        double totalPrice = 0;

                        for(MenuItem m : order.getOrders()){
                            System.out.println(m.getItemName() + " | W " +
                                    m.getItemPrice() + " | " + m.getItemDescription());
                            totalPrice += m.getItemPrice();
                        }

                        System.out.println("[ TOTAL ]");
                        System.out.println("W " + totalPrice);
                        System.out.println("--------------------------------");
                        System.out.println("해당 주문내역과 같이 주문하시겠습니까?");
                        System.out.println("1. 주문    |    2. 메뉴판");

                        choice = sc.nextInt();

                        if(choice ==1){
                            System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                            break;
                        } else if(choice == 2) {
                            System.out.println("--------------------------------");
                            System.out.println("처음으로 돌아갑니다.");
                            System.out.println("--------------------------------");
                            continue;
                        }
                    } else if(choice == cancleChoice) {
                        order.getOrders().clear();
                        System.out.println("--------------------------------");
                        System.out.println("처음으로 돌아갑니다.");
                        System.out.println("--------------------------------");
                        continue;
                    } else {
                        System.out.println("--------------------------------");
                        chooseMenu = menus.get(choice-1);
                        System.out.println("[ " + chooseMenu.getCategory().toUpperCase() + " MENU ]");

                        for (int i = 0; i < chooseMenu.getMenuItemList().size(); i++) {
                            System.out.println((i+1) + ". " +
                                    chooseMenu.getMenuItemList().get(i).getItemName() + " | W " +
                                    chooseMenu.getMenuItemList().get(i).getItemPrice() + " | " +
                                    chooseMenu.getMenuItemList().get(i).getItemDescription()
                            );
                        }

                        System.out.println("0. 뒤로가기  |  입력 시 처음으로 돌아갑니다.");
                        System.out.println("--------------------------------");
                    }
                } else { //주문목록이 비어있을때 진행흐름
                    choice = sc.nextInt();

                    if (choice == 0) {
                        System.out.println("--------------------------------");
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    } else {
                        System.out.println("--------------------------------");
                        chooseMenu = menus.get(choice-1);
                        System.out.println("[ " + chooseMenu.getCategory().toUpperCase() + " MENU ]");

                        for (int i = 0; i < chooseMenu.getMenuItemList().size(); i++) {
                            System.out.println((i+1) + ". " +
                                    chooseMenu.getMenuItemList().get(i).getItemName() + " | W " +
                                    chooseMenu.getMenuItemList().get(i).getItemPrice() + " | " +
                                    chooseMenu.getMenuItemList().get(i).getItemDescription()
                            );
                        }

                        System.out.println("0. 뒤로가기  |  입력 시 처음으로 돌아갑니다.");
                        System.out.println("--------------------------------");
                    }
                }

                choice = sc.nextInt();
                MenuItem chooseMenuItem;

                if (choice == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("처음으로 돌아갑니다.");
                    System.out.println("--------------------------------");
                    continue;
                } else {
                    System.out.println("--------------------------------");
                    chooseMenuItem = chooseMenu.getMenuItemList().get(choice-1);
                    System.out.println("당신이 선택한 메뉴: " + chooseMenuItem.getItemName() +
                                    " | W " + chooseMenuItem.getItemPrice() +
                                    " | " + chooseMenuItem.getItemDescription()
                    );
                }

                while(true) {
                    System.out.println("선택한 메뉴를 주문목록에 추가하시겠습니까?");
                    System.out.println("1. 확인    |    2. 취소");
                    System.out.println("--------------------------------");

                    choice = sc.nextInt();

                    if (choice == 1) {
                        order.addOrder(chooseMenuItem);
                        System.out.println(chooseMenuItem.getItemName() + " 메뉴가 주문목록에 추가되었습니다.");
                        System.out.println("--------------------------------");
                        break;
                    } else if (choice == 2) {
                        break;
                    } else {
                        System.out.println("선택지를 확인하세요.");
                        System.out.println("--------------------------------");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("--------------------------------");
                System.out.println("숫자만 입력해주세요.");
                System.out.println("--------------------------------");
                sc.nextLine(); //버퍼 지우기
            } catch (IndexOutOfBoundsException e){
                System.out.println("--------------------------------");
                System.out.println("선택지를 확인하세요.");
                System.out.println("--------------------------------");
            }

        }
        sc.close(); //스캐너 종료
    }
}


