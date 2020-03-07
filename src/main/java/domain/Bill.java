package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bill {
    private static final int NO_QUANTITY = 0;

    private final List<OrderedMenu> orderList = new ArrayList<>();

    public void registerMenu(Menu menu, int quantity) {
        if (quantity == NO_QUANTITY) {
            return;
        }
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

    public void initOrderList() {
        orderList.clear();
    }

    public List<OrderedMenu> getOrderedMenus() {
        return orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bill bill1 = (Bill) o;
        return Objects.equals(orderList, bill1.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }
}
