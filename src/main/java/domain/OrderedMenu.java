package domain;

public class OrderedMenu {
    private Menu menu;
    private int quantity;

    public OrderedMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int calculateMenuPriceSum() {
        return menu.calculateMenuPriceSum(quantity);
    }

    public void addQuantity(int quantity) {
        checkMaxQuantity(quantity);
        this.quantity += quantity;
    }

    private void checkMaxQuantity(int quantity) {
        if (this.quantity + quantity > 99) {
            throw new IllegalArgumentException(String.format("한 메뉴에 대해 최대 99개까지 주문가능합니다. 현재 주문량 : %d", this.quantity));
        }
    }

    public int getQuantity() {
        return this.quantity;
    }
}
