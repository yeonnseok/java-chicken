package domain.payment;

import domain.order.Order;
import domain.table.Table;

import java.util.function.Predicate;

/**
 * 치킨 카테고리에 대한 할인 객체
 *
 * @author 토니
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
		int categoryCount = 0;

		categoryCount += table.getOrders().getOrders().stream()
				.filter(Order::isChickenMenu)
				.mapToInt(Order::getAmount)
				.sum();

		int discountMoney = (categoryCount / DIVIDE_UNIT) * DISCOUNT_UNIT;

		return table.calculateTotalPrice() - discountMoney;
	}
}
