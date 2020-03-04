package domain;

import java.util.ArrayList;
import java.util.List;

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
}
