package domain;

import java.util.Objects;

public class OrderedMenu {
    private static final int MIN_QUANTITY = 0;
    private static final int MAX_QUANTITY = 99;

    private Menu menu;
    private int quantity;

    public OrderedMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        checkMaxQuantity(quantity);
        this.quantity += quantity;
    }

    private void checkMaxQuantity(int quantity) {
        if (this.quantity + quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(String.format("한 메뉴에 대해 최대 99개까지 주문가능합니다. 현재 주문량 : %d", this.quantity));
        }
    }

    public int calculateMenuPriceSum() {
        return menu.calculateMenuPriceSum(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedMenu that = (OrderedMenu) o;
        return quantity == that.quantity &&
                Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, quantity);
    }
}
