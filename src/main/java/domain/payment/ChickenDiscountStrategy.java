package domain.payment;

import domain.order.Order;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class ChickenDiscountStrategy implements Discountable {
	private static final int DIVIDE_UNIT = 10;
	private static final int DISCOUNT_UNIT = 10_000;

	private ChickenDiscountStrategy() {}

	public static ChickenDiscountStrategy create() {
		return new ChickenDiscountStrategy();
	}

	@Override
	public int discount(Order order) {
		int orderPrice = order.calculatePurePrice();

		if (order.isChickenMenu()) {
			orderPrice = applyStrategy(order);
		}

		return orderPrice;
	}

	private int applyStrategy(Order order) {
		return order.calculatePurePrice() - (order.getDividedAmountByUnit(DIVIDE_UNIT) * DISCOUNT_UNIT);
	}
}
