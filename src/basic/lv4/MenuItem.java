package basic.lv4;

public class MenuItem {
    private String itemName;
    private int itemPrice;
    private String itemDescription;

    MenuItem(String itemName, int itemPrice, String itemDescription){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
