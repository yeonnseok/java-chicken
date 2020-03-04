package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private Map<Menu, Quantity> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void addMenu(Menu menu, Quantity quantity) {
        if (!this.order.containsKey(menu)) {
            this.order.put(menu, quantity);
            return;
        }
        Quantity originalQuantity = this.order.get(menu);
        originalQuantity.addQuantity(quantity);
        this.order.put(menu, originalQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order1 = (Order) o;
        return Objects.equals(order, order1.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }
}
