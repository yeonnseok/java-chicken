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
		orders.addNewMenuOrder(inputOrder);
	}

	public boolean isSameNumber(int inputTableNumber) {
		return this.number == inputTableNumber;
	}

	public boolean isOrdered() {
		return !this.orders.isEmpty();
	}

	public Orders getOrders() {
		return this.orders;
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Table that = (Table)obj ;
		return this.number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.number);
	}
}
