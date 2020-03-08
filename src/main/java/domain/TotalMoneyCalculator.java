package domain;

public class TotalMoneyCalculator {
    private static final int CHICKEN_DISCOUNT_MONEY = 10_000;
    private static final int CHICKEN_DISCOUNT_DIVIDER = 10;

    public static int calculateTotalMoney(Tables tables, int tableNumber, PaymentWay paymentWay) {
        double totalMoney = tables.calculateTotalMoney(tableNumber);
        totalMoney = applyChickenCategoryDiscount(totalMoney, tables, tableNumber);
        totalMoney = applyPaymentWayDiscount(totalMoney, paymentWay);
        return (int) totalMoney;
    }

    private static double applyChickenCategoryDiscount(double totalMoney, Tables tables, int tableNumber) {
        int chickenAmount = tables.countChickenMenu(tableNumber);
        int chickenDiscountAmount = chickenAmount / CHICKEN_DISCOUNT_DIVIDER;
        return totalMoney - chickenDiscountAmount * CHICKEN_DISCOUNT_MONEY;
    }

    private static double applyPaymentWayDiscount(double totalMoney, PaymentWay paymentWay) {
        return paymentWay.applyPaymentWayDiscount(totalMoney);
    }
}
