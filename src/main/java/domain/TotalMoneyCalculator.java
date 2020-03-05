package domain;

public class TotalMoneyCalculator {
    private static final int CHICKEN_DISCOUNT_MONEY = 10000;
    private static final int CHICKEN_DISCOUNT_DIVIDER = 10;
    private static final double CASH_DISCOUNT_RATIO = 0.95;

    public int calculateTotalMoney(Tables tables, int tableNumber, PaymentWay paymentWay) {
        double totalMoney = tables.calculateTotalMoney(tableNumber);
        totalMoney = applyChickenCategoryDiscount(totalMoney, tables, tableNumber);
        totalMoney = applyPaymentWayDiscount(totalMoney, paymentWay);
        return (int) totalMoney;
    }

    private double applyChickenCategoryDiscount(double totalMoney, Tables tables, int tableNumber) {
        int chickenAmount = tables.countChickenMenu(tableNumber);
        int chickenDiscountAmount = chickenAmount / CHICKEN_DISCOUNT_DIVIDER;
        return totalMoney - chickenDiscountAmount * CHICKEN_DISCOUNT_MONEY;
    }

    private double applyPaymentWayDiscount(double totalMoney, PaymentWay paymentWay) {
        if (paymentWay.isCash()) {
            totalMoney = totalMoney * CASH_DISCOUNT_RATIO;
        }
        return totalMoney;
    }
}
