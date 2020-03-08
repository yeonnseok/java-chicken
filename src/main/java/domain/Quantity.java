package domain;

public class Quantity {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 99;
    private static final int DEFAULT_QUANTITY = 0;

    private int quantity;

    public Quantity() {
        this.quantity = DEFAULT_QUANTITY;
    }

    public Quantity(final int quantity) {
        checkCountRange(quantity);
        this.quantity = quantity;
    }

    private void checkCountRange(final int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(String.format("주문 가능한 수량이 아닙니다. 현재 입력 : %d", quantity));
        }
    }

    public Quantity addQuantity(int quantity) {
        if (this.quantity + quantity > MAX_QUANTITY){
            throw new IllegalArgumentException("한 메뉴당 최대 주문 수량은 99개 입니다.");
        }
        return new Quantity(this.quantity + quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
