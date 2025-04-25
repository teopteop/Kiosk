package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> orders = new ArrayList<>();

    public void addOrder(MenuItem menuItem){
        orders.add(menuItem);
    }

    public List<MenuItem> getOrders() {
        return orders;
    }
}
