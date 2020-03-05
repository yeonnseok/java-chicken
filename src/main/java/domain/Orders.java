package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private static final int DISCOUNT_CHICKEN_UNIT_COUNT = 10;
    private static final int DISCOUNT_CHICKEN_UNIT_PRICE = 10_000;
    private static final int DEFAULT_COUNT = 0;

    private Map<Menu, Integer> orders = new HashMap<>();

    public void addOrder(Menu menu, Count count) {
        this.orders.put(menu, orders.getOrDefault(menu, DEFAULT_COUNT) + count.getCount());
    }

    public int calculateTotalPrice() {
        return orders.keySet()
                .stream()
                .mapToInt(menu -> menu.getPrice() * orders.get(menu))
                .sum();
    }

    public int countChickenType() {
        return orders.keySet()
                .stream()
                .filter(Menu::isChickenType)
                .mapToInt(menu -> orders.get(menu))
                .sum();
    }

    public int totalPriceDiscountedByChickenCount(int totalPrice) {
        return totalPrice - (countChickenType() / DISCOUNT_CHICKEN_UNIT_COUNT) * DISCOUNT_CHICKEN_UNIT_PRICE;
    }

    public Map<Menu, Integer> getOrders() {
        return orders;
    }
}
