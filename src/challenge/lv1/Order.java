package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> orders = new ArrayList<>();

    public List<MenuItem> getOrders() {
        return orders;
    }

    public void addOrder(int choice, MenuItem menuItem){
        if (choice == 1) {
            orders.add(menuItem);
            System.out.println(menuItem.getItemName() + " 메뉴가 주문목록에 추가되었습니다.");
        }

        if (choice == 2) {
            System.out.println("주문이 취소되었습니다. 처음으로 돌아갑니다.");
        }
    }

    public int orderMenu(int i){
        System.out.println("\n[ ORDER MENU ]");
        System.out.println((i+1) + ". Orders    | 장바구니를 확인 후 주문합니다.");
        System.out.println((i+2) + ". cancel    | 진행중인 주문을 취소합니다.");
        return i+2;
    }

    public void printOrders(){
        System.out.println("\n[ ORDERS ]");
        for(MenuItem m : orders){
            System.out.println(m.getItemName() + " | W " + m.getItemPrice() + " | " + m.getItemDescription());
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(MenuItem m : orders){
            totalPrice += m.getItemPrice();
        }
        return totalPrice;
    }

}
