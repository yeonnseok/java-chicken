package domain;

public class Order {
    public static final String SPACE = " ";
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

    @Override
    public String toString() {
        return menu.getName() +
                SPACE +
                count +
                SPACE +
                menu.getPrice();
    }
}
