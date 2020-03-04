package domain.order;

import domain.menu.Menu;

import java.util.Objects;

/**
 * 메뉴와 수량이 담긴 주문 객체
 *
 * @author 토니
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

	public void orderMore(int inputAmount) {
		validateAmount(inputAmount);
		validateAmount(this.amount + inputAmount);
		this.amount = this.amount + inputAmount;
	}

	private void validateAmount(int inputAmount) {
		if (inputAmount < MIN_AMOUNT || inputAmount > MAX_AMOUNT) {
			throw new IllegalArgumentException("메뉴는 총 1개에서 99개 사이로 주문해야합니다.");
		}
	}

	public boolean hasSameMenu(Menu targetMenu) {
		return this.menu.equals(targetMenu);
	}

	public Menu getMenu() {
		return this.menu;
	}

	public int getAmount() {
		return this.amount;
	}
}
