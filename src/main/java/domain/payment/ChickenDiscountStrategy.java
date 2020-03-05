package domain.payment;

import domain.order.Order;
import domain.table.Table;

import java.util.function.Predicate;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class ChickenDiscountStrategy implements DiscountableByCategory {
	private static final int DIVIDE_UNIT = 10;
	private static final int DISCOUNT_UNIT = 10_000;

	private ChickenDiscountStrategy() {}

	public static ChickenDiscountStrategy create() {
		return new ChickenDiscountStrategy();
	}

	@Override
	public int discount(Table table) {
		int discountedPrice = 0;

		discountedPrice += table.getOrders().getOrders().stream()
				.filter(Order::isChickenMenu)
				.mapToInt(this::applyStrategy)
				.sum();

		discountedPrice += table.getOrders().getOrders().stream()
				.filter(not(Order::isChickenMenu))
				.mapToInt(Order::calculatePurePrice)
				.sum();

		return discountedPrice;
	}

	private int applyStrategy(Order order) {
		return order.calculatePurePrice() - (order.getDividedAmountByUnit(DIVIDE_UNIT) * DISCOUNT_UNIT);
	}

	public static <T> Predicate<T> not(Predicate<T> t) {
		return t.negate();
	}
}
