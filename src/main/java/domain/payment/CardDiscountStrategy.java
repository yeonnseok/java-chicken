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
public class CardDiscountStrategy implements Discountable {

	@Override
	public int discount(Order order) {
		return 0;
	}
}
