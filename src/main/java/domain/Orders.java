package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static final int DISCOUNT_CHICKEN_UNIT_COUNT = 10;
    private static final int DISCOUNT_CHICKEN_UNIT_PRICE = 10_000;

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculateMenuPrice)
                .sum();
    }

    public int countChickenType() {
        return (int) orders.stream()
                .filter(Order::isChickenTypeMenu)
                .mapToInt(Order::getCount)
                .sum();
    }

    public int totalPriceDiscountedByChickenCount(int totalPrice) {
        return totalPrice - (countChickenType() / DISCOUNT_CHICKEN_UNIT_COUNT) * DISCOUNT_CHICKEN_UNIT_PRICE;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
