package domain;

import java.util.HashMap;
import java.util.Map;

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

    public void clearOrderInfo() {
        this.order.clear();
    }

    public boolean hashOrder() {
        return !this.order.isEmpty();
    }

    public Map<Menu, Quantity> getOrderInfo() {
        return this.order;
    }
}
