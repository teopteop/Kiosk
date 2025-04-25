package challenge.lv2;

public enum Grade {
    VETERAN(0.1), SOLDIER(0.05), STUDENT(0.03), BASIC(0);

    private double discountPercent;

    Grade(double discountPercent){
        this.discountPercent = discountPercent;
    }

}
