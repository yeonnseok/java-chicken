package domain;

import java.util.Objects;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isMatchMenu(int menuNumber) {
        return this.number == menuNumber;
    }

    public int calculateMenuPriceSum(int quantity) {
        return this.price * quantity;
    }

    public boolean isChickenCategory() {
        return this.category == Category.CHICKEN;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        return this.number == ((Menu)o).number;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
