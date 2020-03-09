package domain;

import java.util.Map;

public class ChickenDiscountStrategy implements DiscountByCategory {
    private static final int CHICKEN_DISCOUNT_STANDARD = 10;
    private static final int DISCOUNT_PAYMENT = 10_000;

    private ChickenDiscountStrategy() {
    }

    public static ChickenDiscountStrategy create() {
        return new ChickenDiscountStrategy();
    }

    @Override
    public int discountByCategory(Table table) {
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();

        int chickenMenuCount = countChickenMenu(orderInfo);
        return calculateDiscountPrice(chickenMenuCount);
    }

    private int countChickenMenu(Map<Menu, Quantity> orderInfo) {
        int chickenMenuCount = 0;
        for(Map.Entry<Menu, Quantity> entry : orderInfo.entrySet()) {
            Menu menu = entry.getKey();
            chickenMenuCount = plusChickenMenu(chickenMenuCount, entry, menu);
        }
        return chickenMenuCount;
    }

    private int plusChickenMenu(int chickenMenuCount, Map.Entry<Menu, Quantity> entry, Menu menu) {
        if (menu.isChicken()) {
            Quantity quantity = entry.getValue();
            chickenMenuCount = chickenMenuCount + quantity.getQuantity();
        }
        return chickenMenuCount;
    }

    private int calculateDiscountPrice(int chickenMenuCount) {
        return (chickenMenuCount / CHICKEN_DISCOUNT_STANDARD) * DISCOUNT_PAYMENT;
    }
}
