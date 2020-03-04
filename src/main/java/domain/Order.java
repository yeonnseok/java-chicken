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
	private static final int MIN_AMOUNT = 1;
	private static final int MAX_AMOUNT = 99;

	private final Menu menu;
	private int amount;

	public Order(Menu inputMenu, int inputAmount) {
		Objects.requireNonNull(inputMenu, "메뉴는 null일 수 없습니다.");
		validateAmount(inputAmount);
		this.menu = inputMenu;
		this.amount = inputAmount;
	}

	private void validateAmount(int inputAmount) {
		if (inputAmount < MIN_AMOUNT || inputAmount > MAX_AMOUNT) {
			throw new IllegalArgumentException("메뉴는 총 1개에서 99개 사이로 주문해야합니다.");
		}
	}

	public void orderMore(int inputAmount) {
		validateAmount(inputAmount);
		validateAmount(this.amount + inputAmount);
		this.amount += inputAmount;
	}

	public int getAmount() {
		return this.amount;
	}

	public boolean isSameMenu(Menu targetMenu) {
		return this.menu.equals(targetMenu);
	}
}
