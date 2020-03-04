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

    public Order getOrder() {
        return this.order;
    }

    public boolean isSameTableNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
