package challenge.lv2;

public enum Grade {
    VETERAN(0.1), SOLDIER(0.05), STUDENT(0.03), BASIC(0);

    private double discountPercent;

    Grade(double discountPercent){
        this.discountPercent = discountPercent;
    }

    public double discountPrice(double price){
        return price - (price*discountPercent);
    }

    public static Grade gradeChoice(int input){
        switch (input){
            case 1:
                return Grade.VETERAN;
            case 2:
                return Grade.SOLDIER;
            case 3:
                return Grade.STUDENT;
            case 4:
                return Grade.BASIC;
            default:
                throw new IllegalArgumentException("선택지를 확인하세요");
        }
    }

}
