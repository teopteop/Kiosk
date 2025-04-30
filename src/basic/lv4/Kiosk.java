package basic.lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public void start(List<Menu> menus) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int cnt = 1; //반복 사용할 카운트 변수
                System.out.println("[ MAIN MENU ]");

                for (Menu m : menus) {
                    System.out.println(cnt + ". " + m.category);
                    cnt++;
                }

                cnt = 1; // 카운트 초기화
                System.out.println("0. 종료  |  입력 시 종료됩니다.");

                int choice = sc.nextInt();
                Menu chooseMenu;

                if (choice == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("--------------------------------");
                    chooseMenu = menus.get(choice - 1);
                    System.out.println("[ " + chooseMenu.category.toUpperCase() + " MENU ]");

                    for (MenuItem m : chooseMenu.menuItemList) {
                        System.out.println(cnt + ". " + m.itemName + " | W " +
                                m.itemPrice + " | " + m.itemDescription);
                        cnt++;
                    }

                    System.out.println("0. 뒤로가기  |  입력 시 처음으로 돌아갑니다.");
                    System.out.println("--------------------------------");
                }

                choice = sc.nextInt();
                MenuItem chooseMenuItem;

                if (choice == 0) {
                    System.out.println("처음으로 돌아갑니다.");
                    System.out.println("--------------------------------");
                } else {
                    System.out.println("--------------------------------");
                    chooseMenuItem = chooseMenu.menuItemList.get(choice - 1);
                    System.out.println("당신이 선택한 메뉴: " + chooseMenuItem.itemName +
                            " | W " + chooseMenuItem.itemPrice +
                            " | " + chooseMenuItem.itemDescription
                    );
                    System.out.println("--------------------------------");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                System.out.println("--------------------------------");
                sc.nextLine(); //버퍼 지우기
            } catch (IndexOutOfBoundsException e) {
                System.out.println("선택지를 확인하세요.");
                System.out.println("--------------------------------");
            }

        }
        sc.close(); //스캐너 종료
    }
}


