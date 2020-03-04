package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Orders {
	private List<Order> orders;

	public Orders(List<Order> inputOrders) {
		Objects.requireNonNull(inputOrders, "주문들은 null일 수 없습니다.");
		this.orders = inputOrders;
	}

	public static Orders createOrders() {
		return new Orders(new ArrayList<>());
	}

	public void addNewMenuOrder(Order inputOrder) {
		Objects.requireNonNull(inputOrder, "주문은 null일 수 없습니다.");
		orders.add(inputOrder);
	}

	public void addPresentMenuOrder(Order inputOrder) {
		Objects.requireNonNull(inputOrder, "주문은 null일 수 없습니다.");
		orders.stream()
				.filter(order -> order.hasSameMenu(inputOrder.getMenu()))
				.forEach(order -> order.orderMore(inputOrder.getAmount()));
	}

	public boolean hasOrderedMenu(Menu targetMenu) {
		return orders.stream()
				.anyMatch(order -> order.hasSameMenu(targetMenu));
	}

	public int getAmountOfOrderedMenu(Menu targetMenu) {
		return orders.stream()
				.filter(order -> order.hasSameMenu(targetMenu))
				.findAny()
				.map(Order::getAmount)
				.orElse(0); // TODO: 2020/03/04 0이 맞을까 예외가 맞을까?
	}

	public boolean isEmpty() {
		return orders.isEmpty();
	}
}
