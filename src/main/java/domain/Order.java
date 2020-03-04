package domain;

import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Order {
	private final Menu menu;
	private int amount;

	public Order(Menu inputMenu, int inputAmount) {
		Objects.requireNonNull(inputMenu, "메뉴는 null일 수 없습니다.");
		this.menu = inputMenu;
		this.amount = inputAmount;
	}

}
