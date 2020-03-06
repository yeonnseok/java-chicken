package domain.table;

import domain.order.Order;
import domain.order.Orders;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 가게의 테이블 객체 : 고유의 테이블 번호와 주문들을 받을 수 있는 orders을 멤버로 가지고 있다.
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Table {
	private final int number;
	private Orders orders;

	public Table(final int number) {
		this.number = number;
		this.orders = new Orders(new ArrayList<>());
	}

	public void order(Order inputOrder) {
		Objects.requireNonNull(inputOrder, "주문은 null일 수 없습니다.");

		if (orders.hasOrderedMenu(inputOrder.getMenu())) {
			orders.addPresentMenuOrder(inputOrder);
			return;
		}

		orders.addNewMenuOrder(inputOrder);
	}

	public int calculateTotalPrice() {
		return orders.getOrders().stream()
				.mapToInt(Order::calculatePurePrice)
				.sum();
	}

	public void cleanTable() {
		this.orders = new Orders(new ArrayList<>());
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
