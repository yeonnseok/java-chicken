package domain;

import java.util.Map;

public class Calculator {
    private Calculator() {
    }

    public static int calculate(Table table, PaymentType paymentType) {
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();

        int allMenuPrice = calculateAllMenuSum(orderInfo);
        DiscountByCategory chickenDiscountStrategy = ChickenDiscountStrategy.create();
        int chickenDiscountPrice = chickenDiscountStrategy.discountByCategory(table);
        allMenuPrice = allMenuPrice - chickenDiscountPrice;

        int discountAmount = PaymentTypeDiscountStrategy.discountByPaymentType(allMenuPrice, paymentType);
        return discountAmount;
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
        return price * count;
    }
}
