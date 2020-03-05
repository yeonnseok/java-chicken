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
public interface Discountable {
	int discount(final Table table, final PaymentType paymentType);
}
