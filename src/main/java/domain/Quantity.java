package domain;

public class Quantity {
    private static final int MAX_QUANTITY = 99;

    private int quantity;

    Quantity(int quantity) {
        this.quantity = validateFirstQuantity(quantity);
    }

    private int validateFirstQuantity(int quantity) {
        if (this.quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("한 메뉴에 대해 최대 99개까지 주문가능합니다.");
        }
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += checkMaxQuantity(quantity);
    }

    private int checkMaxQuantity(int quantity) {
        if (this.quantity + quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(String.format("한 메뉴에 대해 최대 99개까지 주문가능합니다. " +
                    "현재 주문량 : %d", this.quantity));
        }
        return quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int calculateMenuPriceSum(Menu menu) {
        return menu.calculateMenuPriceSum(this.quantity);
    }

    public int getChickenCategoryQuantity(Menu menu) {
        if (menu.isChickenCategory()) {
            return this.quantity;
        }
        return 0;
    }
}
