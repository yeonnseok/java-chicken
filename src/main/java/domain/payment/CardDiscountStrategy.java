package domain.payment;

import domain.table.Table;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class CardDiscountStrategy {

	private CardDiscountStrategy() {}

	public static CardDiscountStrategy create() {
		return new CardDiscountStrategy();
	}

	public static int discount(int inputPrice, PaymentType paymentType) {
		return (int) ((inputPrice * paymentType.getDiscountRate()));
	}
}
