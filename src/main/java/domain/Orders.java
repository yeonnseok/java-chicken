package domain;

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
		Objects.requireNonNull(inputOrders, "메뉴들은 null일 수 없습니다.");
		this.orders = inputOrders;
	}

}
