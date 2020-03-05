package domain.order;

import domain.menu.Menu;

import java.util.*;
import java.util.function.Consumer;

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

	public Orders(List<Order> inputOrders) { // TODO: 2020/03/05 옵셔널을 통한 리팩토링
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
				.orElse(0); // TODO: 2020/03/04 0이 맞을까 예외가 맞을까?
	}

	public List<Order> getOrders() {
		return this.orders;
	}
}
