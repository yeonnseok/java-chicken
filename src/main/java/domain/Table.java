package domain;

import java.util.Objects;

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

    public boolean hasOrders() {
        return orders.hasOrders();
    }

    public boolean isSameNumber(int tableNumber) {
        return number == tableNumber;
    }

    public void clearOrders() {
        orders = new Orders();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
