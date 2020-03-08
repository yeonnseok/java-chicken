package domain;

public class Table {
    private final int number;
    private Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addToOrders(Menu menu, Count count) {
        orders.addOrder(menu, count);
    }

    public Orders getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        return orders.totalPriceDiscountedByChickenCount();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
