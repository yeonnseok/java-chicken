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

    public boolean isChickenType() {
        return category.equals(Category.CHICKEN);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return number == menu.number &&
                price == menu.price &&
                name.equals(menu.name) &&
                category == menu.category;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, category, price);
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
