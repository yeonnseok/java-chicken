package domain;

import java.util.Map;

public class Calculator {
    private static final double DISCOUNT_RATE = 0.95;
    private static final int CHICKEN_DISCOUNT_STANDARD = 10;
    private static final int DISCOUNT_PAYMENT = 10000;

    private Calculator() {
    }

    public static int calculate(Table table, PaymentType paymentType) {
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrder();
        int amount = calculateAllMenuSum(orderInfo);
        amount = discountByCash(paymentType, amount);
        return amount;
    }

    private static int discountByCash(PaymentType paymentType, int amount) {
        if (PaymentType.isCash(paymentType)) {
            amount = (int) (amount * DISCOUNT_RATE);
        }
        return amount;
    }

    private static int calculateAllMenuSum(Map<Menu, Quantity> orderInfo) {
        int amount = 0;
        for (Map.Entry<Menu, Quantity> entry : orderInfo.entrySet()) {
            Menu menu = entry.getKey();
            Quantity quantity = entry.getValue();
            amount = amount + calculateMenuSum(menu, quantity);
        }
        return amount;
    }

    private static int calculateMenuSum(Menu menu, Quantity quantity) {
        int price = menu.getPrice();
        int count = quantity.getQuantity();
        int chickenDiscount = discountByChickenCount(menu, count);
        return (price * count) - chickenDiscount;
    }

    private static int discountByChickenCount(Menu menu, int count) {
        if (menu.isChicken() && count >= CHICKEN_DISCOUNT_STANDARD) {
            return (count / CHICKEN_DISCOUNT_STANDARD) * DISCOUNT_PAYMENT;
        }
        return 0;
    }
}
