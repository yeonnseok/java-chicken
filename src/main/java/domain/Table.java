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
public class Table {
	private final int number;
	private Orders orders;

	public Table(final int number) {
		this.number = number;
		this.orders = Orders.createOrders();
	}

	public void order(Order inputOrder) {
		Objects.requireNonNull(inputOrder, "주문은 null일 수 없습니다.");

		if (orders.hasOrderedMenu(inputOrder.getMenu())) {
			orders.addPresentMenuOrder(inputOrder);
			return;
		}
		System.out.println("NEW!");
		orders.addNewMenuOrder(inputOrder);
	}

	public Orders getOrders() {
		return this.orders;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
