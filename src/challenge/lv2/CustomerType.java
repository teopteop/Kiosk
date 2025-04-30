package challenge.lv2;

public enum CustomerType {
    VETERAN(0.1), SOLDIER(0.05), STUDENT(0.03), BASIC(0);

    private double discountPercent;

    CustomerType(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double discountPrice(double price) {
        return price - (price * discountPercent);
    }

    public static CustomerType gradeChoice(int input) {
        switch (input) {
            case 1:
                return CustomerType.VETERAN;
            case 2:
                return CustomerType.SOLDIER;
            case 3:
                return CustomerType.STUDENT;
            case 4:
                return CustomerType.BASIC;
            default:
                throw new IllegalArgumentException("선택지를 확인하세요");
        }
    }

}
