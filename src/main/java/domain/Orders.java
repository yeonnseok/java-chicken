package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculateMenuPrice)
                .sum();
    }
}
