package challenge.lv1;

public class MenuItem {
    private final String itemName;
    private final double itemPrice;
    private final String itemDescription;

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

    public void printMenuItem(){
        System.out.println("당신이 선택한 메뉴: " + itemName +
                " | W " + itemPrice +
                " | " + itemDescription +
                "\n위 메뉴를 추가하시겠습니까?\n1. 확인  |  2. 취소");
    }

}
