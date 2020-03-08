package domain;

public class Quantity {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 99;

    private int quantity;

    Quantity(int quantity) {
        this.quantity = validateQuantityRange(quantity);
    }

    private int validateQuantityRange(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("주문 수량은 1개 이상 99개 이하여야합니다.");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }
}
