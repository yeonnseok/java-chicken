package domain;

public class Table {
    private static final int PAY_FINISH = 0;

    private final int number;
    private final Bill bill = new Bill();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isMatchTableNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    public void registerMenu(Menu menu, int quantity) {
        bill.registerMenu(menu, quantity);
    }

    public int calculateMenuPriceSum() {
        return bill.calculateMenuPriceSum();
    }

    public int countChickenMenu() {
        return bill.countChickenMenu();
    }

    public boolean isPayFinish() {return bill.calculateMenuPriceSum() == PAY_FINISH;}

    public void initOrderList() {
        bill.initOrderList();
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
