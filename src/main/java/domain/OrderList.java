package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderList {
    private final List<OrderedMenu> orderList = new ArrayList<>();

    public void registerMenu(Menu menu, int quantity) {
        if (hasSameMenu(menu)) {
            orderList.stream()
                    .filter(o -> o.isMatchMenu(menu))
                    .forEach(o -> o.addQuantity(quantity));
        }
        if (!hasSameMenu(menu)) {
            orderList.add(new OrderedMenu(menu, quantity));
        }
    }

    private boolean hasSameMenu(Menu menu) {
        return orderList.stream()
                .anyMatch(o -> o.isMatchMenu(menu));
    }

    public List<OrderedMenu> getOrderedMenus() {
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

    public void initOrderList() {
        orderList.clear();
    }
}
