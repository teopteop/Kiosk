package challenge.lv2;

public class MenuItem {
    private final String itemName;
    private final double itemPrice;
    private final String itemDescription;

    MenuItem(String itemName, double itemPrice, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() { //간결한 출력을 위한 toString 메서드 오버라이딩
        return itemName + " | W " + itemPrice + " | " + itemDescription;
    }

}
