package domain;

public class Table {
    private final int number;
    private final OrderList orderList = new OrderList();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isMatchTableNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    public void registerMenu(Menu menu, int quantity) {
        orderList.registerMenu(menu, quantity);
    }

    public int calculateMenuPriceSum() {
        return orderList.calculateMenuPriceSum();
    }

    public int countChickenMenu() {
        return orderList.countChickenMenu();
    }

    public void initOrderList() {
        orderList.initOrderList();
    }

    public OrderList getOrderList() {
        return orderList;
    }
}
