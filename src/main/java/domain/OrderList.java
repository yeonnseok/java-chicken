package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderList {
    private final List<OrderedMenu> orderList = new ArrayList<>();

    public void registerMenu(Menu menu, int quantity) {
        orderList.add(new OrderedMenu(menu, quantity));
    }

    public List<OrderedMenu> getOrderList() {
        return orderList;
    }

    public int calculateMenuPriceSum() {
        return orderList.stream()
                .mapToInt(o -> o.calculateMenuPriceSum())
                .sum();
    }

    public int countChickenMenu() {
        return orderList.stream()
                .mapToInt(OrderedMenu::getChickenCategoryQuantity)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderList orderList1 = (OrderList) o;
        return Objects.equals(orderList, orderList1.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }
}
