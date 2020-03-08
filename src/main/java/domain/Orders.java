package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private static final int DISCOUNT_CHICKEN_UNIT_COUNT = 10;
    private static final int DISCOUNT_CHICKEN_UNIT_PRICE = 10_000;
    private static final int DEFAULT_COUNT = 0;
    private static final int EMPTY_COUNT = 0;
    private static final int MAX_ORDER_COUNT = 99;

    private Map<Menu, Integer> orders = new HashMap<>();

    public void addOrder(final Menu menu, final Count count) {
        int addedCount = orders.getOrDefault(menu, DEFAULT_COUNT) + count.getCount();
        checkAddedCountRange(addedCount);
        this.orders.put(menu, addedCount);
    }

    private void checkAddedCountRange(int addedCount) {
        if (addedCount > MAX_ORDER_COUNT){
            throw new IllegalArgumentException("한 메뉴당 최대 주문 수량은 99개 입니다.");
        }
    }

    public int countChickenType() {
        return orders.keySet()
                .stream()
                .filter(Menu::isChickenType)
                .mapToInt(menu -> orders.get(menu))
                .sum();
    }

    public int totalPriceDiscountedByChickenCount() {
        return calculateTotalPrice() - (countChickenType() / DISCOUNT_CHICKEN_UNIT_COUNT) * DISCOUNT_CHICKEN_UNIT_PRICE;
    }

    private int calculateTotalPrice() {
        return orders.keySet()
                .stream()
                .mapToInt(menu -> menu.getPrice() * orders.get(menu))
                .sum();
    }

    public boolean hasOrders() {
        return orders.size() > EMPTY_COUNT;
    }

    public Map<Menu, Integer> getOrders() {
        return orders;
    }
}
