package domain.menu;

import java.util.Objects;

/**
 * 치킨집이 판매하는 메뉴 객체
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
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

	public boolean isChickenCategory() {
		return category.isChicken();
	}

	public String getName() {
		return this.name;
	}

	public int getNumber() {
		return this.number;
	}

	public int getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return category + " " + number + " - " + name + " : " + price + "원";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Menu that = (Menu)obj ;
		return this.number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.number);
	}
}
