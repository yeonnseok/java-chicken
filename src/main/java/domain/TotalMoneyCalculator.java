package domain;

public class TotalMoneyCalculator {
    private static final int CHICKEN_DISCOUNT_MONEY = 10000;
    public static final int CHICKEN_DISCOUNT_DIVIDER = 10;

    public int calculateTotalMoney(Tables tables, int tableNumber, PaymentWay paymentWay) {
        int totalMoney = tables.calculateTotalMoney(tableNumber);
        totalMoney = applyChickenCategoryDiscount(totalMoney, tables, tableNumber);

        return totalMoney;
    }

    private int applyChickenCategoryDiscount(int totalMoney, Tables tables, int tableNumber) {
        int chickenAmount = tables.countChickenMenu(tableNumber);
        int chickenDiscountAmount = chickenAmount / CHICKEN_DISCOUNT_DIVIDER;
        return totalMoney - chickenDiscountAmount * CHICKEN_DISCOUNT_MONEY;
    }
}
