package basic.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kiosk hamburger = new Kiosk();
        hamburger.addMenuItem(new MenuItem("ShackBurger", 6.9,
                        "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("SmokeShack", 8.9,
                "베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("Cheeseburger", 6.9,
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburger.addMenuItem(new MenuItem("Hamburger", 5.4,
                "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {

            System.out.println("[ SHAKESHACK MENU ]");
            int cnt = 1;
            for(MenuItem m : hamburger.menuItemList){
                System.out.println(cnt + ". " + m.menuName + " | W "+ m.price + " | "+ m.menuDescription);
                cnt++;
            }
            System.out.println("0. 종료  |  입력 시 종료됩니다.");

            try {
                int choice = sc.nextInt();

                if (choice == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("--------------------------------");
                    MenuItem choose = hamburger.menuItemList.get(choice-1);
                    System.out.println("당신이 선택한 메뉴: " + choose.menuName +
                            ". " + choose.menuName +
                            " | W " + choose.price +
                            " | " + choose.menuDescription
                    );
                    System.out.println("--------------------------------");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                System.out.println("--------------------------------");
                sc.nextLine(); //버퍼 지우기
            } catch (IndexOutOfBoundsException e){
                System.out.println("선택지를 확인하세요.");
                System.out.println("--------------------------------");
            }

        }

        sc.close(); //스캐너 종료
    }
}
