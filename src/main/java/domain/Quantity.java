package domain;

public class Quantity {
    private static final int MIN_QUANTITY_RANGE = 1;
    private static final int MAX_QUANTITY_RANGE = 99;

    private int quantity;

    public Quantity(int quantity) {
        validateQuantityRange(quantity);
        this.quantity = quantity;
    }

    private void validateQuantityRange(int quantity) {
        if (quantity < MIN_QUANTITY_RANGE || quantity > MAX_QUANTITY_RANGE) {
            throw new IllegalArgumentException("잘못된 메뉴 수량을 입력하였습니다.");
        }
    }

    public void addQuantity(Quantity quantity) {
        validateQuantitySum(quantity);
        this.quantity = this.quantity + quantity.quantity;
    }

    private void validateQuantitySum(Quantity quantity) {
        if (this.quantity + quantity.quantity > MAX_QUANTITY_RANGE) {
            throw new IllegalArgumentException("메뉴 수량의 합이 99개 이상입니다.");
        }
    }

    public int getQuantity() {
        return this.quantity;
    }
}
