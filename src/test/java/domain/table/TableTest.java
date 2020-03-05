package domain.table;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Table test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class TableTest {
	private Table table_one;

	@BeforeEach
	void setUp() {
		table_one = new Table(1);
	}

	@DisplayName("order 테이블에 올바른 주문이 들어오는지 확인")
	@Test
	void order() {
		Menu orderedMenu = MenuRepository.getMenu(1);
		Order inputOrder = new Order(orderedMenu, 1);
		table_one.order(inputOrder);
		assertThat(table_one.getOrders().getAmountOfOrderedMenu(orderedMenu)).isEqualTo(1);
	}

	@DisplayName("order 테이블에 메뉴 1을 1개씩 3번 주문하여 3개가 주문되는지 확인")
	@Test
	void order_many_times() {
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

	@DisplayName("cleanTable 사용시 빈 orders로 재할당 되는지 확인")
	@Test
	void cleanTable() {
		Menu menu_one = MenuRepository.getMenu(1);
		Menu menu_two = MenuRepository.getMenu(2);
		table_one.order(new Order(menu_one, 11));
		table_one.order(new Order(menu_two, 99));
		table_one.cleanTable();
		assertThat(table_one.getOrders().isEmpty()).isEqualTo(true);
	}
}
