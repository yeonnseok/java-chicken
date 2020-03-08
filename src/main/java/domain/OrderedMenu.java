package domain;

import java.util.Objects;

public class OrderedMenu {
    private Menu menu;
    private Quantity quantity;

    public OrderedMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = new Quantity(quantity);
    }

    public void addQuantity(int quantity) {
        this.quantity.addQuantity(quantity);
    }

    public boolean isMatchMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    public int calculateMenuPriceSum() {
        return quantity.calculateMenuPriceSum(menu);
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }

    public int getChickenCategoryQuantity() {
        return quantity.getChickenCategoryQuantity(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderedMenu that = (OrderedMenu) o;
        return Objects.equals(menu, that.menu) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, quantity);
    }

    @Override
    public String toString() {
        return menu.getName() + " " +
                this.quantity.getQuantity() + " " +
                quantity.calculateMenuPriceSum(menu);
    }
}
