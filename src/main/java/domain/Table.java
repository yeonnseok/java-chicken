package domain;

public class Table {
    private final int number;
    private Order order;

    public Table(final int number) {
        this.number = number;
        this.order = new Order();
    }

    public void addMenu(Menu menu, Quantity quantity) {
        this.order.addMenu(menu, quantity);
    }

    public void clearOrder() {
        this.order.clearOrderInfo();
    }

    public boolean isSameTableNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean hasOrder() {
        return this.order.getOrder().size() != 0;
    }

    public Order getOrder() {
        return this.order;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
