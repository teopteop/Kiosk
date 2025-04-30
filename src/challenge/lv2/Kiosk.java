package challenge.lv2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;

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
                //toUpperCase() 메서드로 카테고리 필드 활용
                System.out.println("[ " + chooseMenu.getCategory().toUpperCase() + " MENU ]");

                //menuItem 조회, 출력 반환값이 없기에 Consumer 사용
                //forEach만 사용시 인덱스에 접근이 불가하다(선택지번호)-> IntStream 사용
                Consumer<List<MenuItem>> myConsumer1 = menuItemList -> {
                    IntStream.range(0, menuItemList.size()).forEach(i -> {
                        MenuItem m = menuItemList.get(i);
                        System.out.println((i + 1) + ". " + m.toString());
                    });
                };
                myConsumer1.accept(chooseMenu.getMenuItemList());
                System.out.println("0.  뒤로가기");

                chooseMenuItem = chooseMenu.getMenuItem(getInput(1, chooseMenu.getMenuItemList().size()));

                //선택한 item 출력
                Consumer<MenuItem> myConsumer2 = m ->
                        System.out.println("당신이 선택한 메뉴: " + m.toString() +
                                "\n위 메뉴를 추가하시겠습니까?\n1. 확인  |  2. 취소");

                myConsumer2.accept(chooseMenuItem);
                order.addOrder(getInput(1, 2), chooseMenuItem);
                continue;
            } else if (choice == menus.size() + 1) {
                order.printOrders();
                System.out.println("[ Total ]\nW " + order.getTotalPrice() +
                        "\n1. 주문  |  2. 주문목록 삭제  |  3. 메뉴판 ");
            }

            choice = getInput(1, 3);
            if (choice == 1) {
                //할인 기능 적용
                System.out.println("할인 정보를 입력해주세요.\n" + "1. 국가유공자  :  10% \n" +
                        "2. 군인  :  5%\n" + "3. 학생  :  3%\n" + "4. 일반  :  0%");
                CustomerType customerType = CustomerType.gradeChoice(getInput(1, 4));
                //부동소수점 출력을 제한 10원단위까지는 결제가 가능하기에 소수 2번째자리까지 표시
                System.out.printf("주문이 완료되었습니다. 금액은 W %.2f 입니다.\n",
                        customerType.discountPrice(order.getTotalPrice()));
                break;
            } else if (choice == 2) {
                //삭제 기능 적용 boolean으로 리턴값을 받기위해 BiFunction 사용
                BiFunction<String, List<MenuItem>, Boolean> myFunction1 = (inputString, orders) ->
                        orders.removeIf(m -> inputString.equals(m.getItemName()));
                sc.nextLine();//다음입력이 nextLine 이기에 버퍼 비우기
                while (true) {
                    System.out.println("삭제할 메뉴의 이름을 입력하세요.(대소문자 구분)");
                    if (myFunction1.apply(sc.nextLine(), order.getOrders())) {
                        System.out.println("삭제 완료");
                        break;
                    }
                    System.out.println("입력한 메뉴명을 확인해주세요.");
                }
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








