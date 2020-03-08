package domain.payment;

import domain.table.Table;

/**
 * 카테고리에 의한 할인에 대한 interface
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public interface DiscountableByCategory {
	int discount(final Table table);
}
