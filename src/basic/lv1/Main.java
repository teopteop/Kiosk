package basic.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] burgerName = {"ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"};
        double[] price = {6.9, 8.9, 6.9, 5.4};
        String[] burgerDescription = {
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "비프패티를 기반으로 야채가 들어간 기본버거"
        };

        while(true) {

            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgerName.length; i++) {
                System.out.println(
                        (i + 1) + ". " + burgerName[i] + " | W " + price[i] + " | " + burgerDescription[i]
                );
            }
            System.out.println("0. 종료  |  입력 시 종료됩니다.");

            try {
                int choice = sc.nextInt();

                if (choice == 0) {
                    break;
                } else {
                    System.out.println("-------------------------------- ");
                    System.out.println("당신이 선택한 메뉴: " + burgerName[choice-1]);
                    System.out.println(
                            (choice) + ". " + burgerName[choice-1] +
                                    " | W " + price[choice-1] + " | " + burgerDescription[choice-1]
                    );
                    System.out.println("-------------------------------- ");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                System.out.println("-------------------------------- ");
                sc.nextLine(); //버퍼 지우기
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("선택지를 확인하세요.");
                System.out.println("-------------------------------- ");
            }

        }

        sc.close(); //스캐너 종료
    }
}
