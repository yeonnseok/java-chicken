package domain;

public class Order {
    private Menu menu;
    private Count count;

    public Order(Menu menu, Count count) {
        this.menu = menu;
        this.count = count;
    }

    public int calculateMenuPrice() {
        return menu.priceTimesCount(count);
    }

    public boolean isChickenTypeMenu() {
        return menu.isChickenType();
    }

    public int getCount() {
        return count.getCount();
    }
}
