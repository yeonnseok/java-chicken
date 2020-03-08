package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private static final int DISCOUNT_CHICKEN_UNIT_COUNT = 10;
    private static final int DISCOUNT_CHICKEN_UNIT_PRICE = 10_000;
    private static final int EMPTY_COUNT = 0;

    private Map<Menu, Quantity> orders = new HashMap<>();

    public void addOrder(final Menu menu, final Quantity quantity) {
        Quantity addedQuantity = orders.getOrDefault(menu, new Quantity()).addQuantity(quantity.getQuantity());
        this.orders.put(menu, addedQuantity);
    }

    public int countChickenType() {
        return orders.keySet()
                .stream()
                .filter(Menu::isChickenType)
                .mapToInt(menu -> orders.get(menu).getQuantity())
                .sum();
    }

    public int totalPriceDiscountedByChickenCount() {
        return calculateTotalPrice() - (countChickenType() / DISCOUNT_CHICKEN_UNIT_COUNT) * DISCOUNT_CHICKEN_UNIT_PRICE;
    }

    private int calculateTotalPrice() {
        return orders.keySet()
                .stream()
                .mapToInt(menu -> menu.getPrice() * orders.get(menu).getQuantity())
                .sum();
    }

    public boolean hasOrders() {
        return orders.size() > EMPTY_COUNT;
    }

    public Map<Menu, Quantity> getOrders() {
        return orders;
    }
}
