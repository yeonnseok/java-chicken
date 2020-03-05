package domain.payment;

import domain.order.Order;
import domain.table.Table;

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
	public int discount(Table table) {
		int discountedPrice = 0;
		for(Order order : table.getOrders().getOrders()) {
			int orderPrice = order.calculatePurePrice();
			if (order.isChickenMenu()) {
				orderPrice = applyStrategy(order);
			}
			discountedPrice += orderPrice;
		}
		return discountedPrice;
	}

	private int applyStrategy(Order order) {
		return order.calculatePurePrice() - (order.getDividedAmountByUnit(DIVIDE_UNIT) * DISCOUNT_UNIT);
	}
}
