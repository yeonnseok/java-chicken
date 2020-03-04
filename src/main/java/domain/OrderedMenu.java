package domain;

public class OrderedMenu {
    private Menu menu;
    private int quantity;

    public OrderedMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int calculateMenuPriceSum() {
        return menu.calculateMenuPriceSum(quantity);
    }
}
