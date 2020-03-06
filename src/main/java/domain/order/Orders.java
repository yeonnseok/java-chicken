package domain.order;

import domain.menu.Menu;

import java.util.*;

/**
 * 주문들의 일급 컬렉션
 *
 * @author 토니
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

	public boolean isEmpty() {
		return orders.isEmpty();
	}

	public int getAmountOfOrderedMenu(Menu targetMenu) {
		return orders.stream()
				.filter(order -> order.hasSameMenu(targetMenu))
				.findAny()
				.map(Order::getAmount)
				.orElse(0);
	}

	public List<Order> getOrders() {
		return this.orders;
	}
}
