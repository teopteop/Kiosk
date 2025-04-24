package basic.lv5;

public class MenuItem {
    private String itemName;
    private double itemPrice;
    private String itemDescription;

    MenuItem(String itemName, double itemPrice, String itemDescription){
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
}
