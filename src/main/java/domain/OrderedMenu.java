package domain;

public class OrderedMenu {
    private static final int MIN_QUANTITY = 0;
    private static final int MAX_QUANTITY = 99;

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
        checkNegativeNumber(quantity);
        checkMaxQuantity(quantity);
        this.quantity += quantity;
    }

    private void checkNegativeNumber(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException(String.format("수량은 0이상의 수를 입력해야 합니다. 입력한 수 : %d", quantity));
        }
    }

    private void checkMaxQuantity(int quantity) {
        if (this.quantity + quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(String.format("한 메뉴에 대해 최대 99개까지 주문가능합니다. 현재 주문량 : %d", this.quantity));
        }
    }

    public int getQuantity() {
        return this.quantity;
    }
}
