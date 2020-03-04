package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class TableTest {
	@DisplayName("Table 생성자 테스트")
	@Test
	void Table() {
		assertThat(new Table(1)).isInstanceOf(Table.class);
	}

	@DisplayName("order 테이블에 올바른 주문이 들어오는지 확인")
	@Test
	void order() {
		Table table_one = new Table(1);
		Menu orderedMenu = MenuRepository.getMenu(1);
		Order inputOrder = new Order(orderedMenu, 1);
		table_one.order(inputOrder);
		assertThat(table_one.getOrders().getAmountOfOrderedMenu(orderedMenu)).isEqualTo(1);
	}

	@DisplayName("order 테이블에 메뉴 1을 1개씩 3번 주문하여 3개가 주문되는지 확인")
	@Test
	void order_many_times() {
		Table table_one = new Table(1);
		Menu orderedMenu = MenuRepository.getMenu(1);

		Order inputOrder = new Order(orderedMenu, 1);
		table_one.order(inputOrder);
		inputOrder = new Order(orderedMenu, 1);
		table_one.order(inputOrder);
		inputOrder = new Order(orderedMenu, 1);
		table_one.order(inputOrder);

		assertThat(table_one.getOrders().getAmountOfOrderedMenu(orderedMenu)).isEqualTo(3);
	}

	@DisplayName("order 테이블에 메뉴 1을 1개씩 2번 주문하고 메뉴 2를 1개 1회 주문시 각각 개수만큼 주문되는지 확인")
	@Test
	void order_many_times_two_menus() {
		Table table_one = new Table(1);
		Menu menu_one = MenuRepository.getMenu(1);
		Menu menu_two = MenuRepository.getMenu(2);

		Order inputOrder = new Order(menu_one, 1);
		table_one.order(inputOrder);
		inputOrder = new Order(menu_one, 1);
		table_one.order(inputOrder);
		inputOrder = new Order(menu_two, 1);
		table_one.order(inputOrder);

		assertThat(table_one.getOrders().getAmountOfOrderedMenu(menu_one)).isEqualTo(2);
		assertThat(table_one.getOrders().getAmountOfOrderedMenu(menu_two)).isEqualTo(1);
	}
}
