package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

/**
 * Orders test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class OrdersTest {
	@DisplayName("Orders 생성자 정상 동작")
	@Test
	void Orders() {
		Orders orders = new Orders(
				Arrays.asList(
						new Order(MenuRepository.getMenu(1), 1),
						new Order(MenuRepository.getMenu(2), 2),
						new Order(MenuRepository.getMenu(3), 3)
				)
		);
		assertThat(orders).isInstanceOf(Orders.class);
	}

	@DisplayName("Orders 생성자 null입력시 예외처리")
	@ParameterizedTest
	@NullSource
	void Orders_null_input(List<Order> nullInput) {
		assertThatNullPointerException().isThrownBy(() -> {
			new Orders(nullInput);
		}).withMessage("주문들은 null일 수 없습니다.");
	}

	@DisplayName("createOrders 정적 팩토리 메서드 생성 테스트")
	@Test
	void createOrders() {
		assertThat(Orders.createOrders()).isInstanceOf(Orders.class);
	}

	@DisplayName("addNewMenuOrder 처음 주문되는 메뉴에 대해 정상 작동 확인")
	@Test
	void addNewMenuOrder() {
		ArrayList<Order> newOrders = new ArrayList<>();
		newOrders.add(new Order(MenuRepository.getMenu(1), 1));
		newOrders.add(new Order(MenuRepository.getMenu(2), 2));
		newOrders.add(new Order(MenuRepository.getMenu(3), 3));

		Orders orders = new Orders(newOrders);
		Menu newMenu = MenuRepository.getMenu(4);
		Order newOrder = new Order(newMenu, 4);

		orders.addNewMenuOrder(newOrder);

		assertThat(orders.hasOrderedMenu(newMenu)).isEqualTo(true);
		assertThat(orders.getAmountOfOrderedMenu(newMenu)).isEqualTo(4);
	}

	@DisplayName("addPresentMenuOrder 추가 주문되는 메뉴에 대해 정상 작동 확인")
	@Test
	void addPresentMenuOrder() {
		ArrayList<Order> newOrders = new ArrayList<>();
		newOrders.add(new Order(MenuRepository.getMenu(1), 1));
		newOrders.add(new Order(MenuRepository.getMenu(2), 2));
		newOrders.add(new Order(MenuRepository.getMenu(3), 3));

		Orders orders = new Orders(newOrders);
		Menu againMenu = MenuRepository.getMenu(3);
		Order newOrder = new Order(againMenu, 4);

		orders.addPresentMenuOrder(newOrder);

		assertThat(orders.hasOrderedMenu(againMenu)).isEqualTo(true);
		assertThat(orders.getAmountOfOrderedMenu(againMenu)).isEqualTo(7);
	}

	@DisplayName("hasOrderedMenu 입력받은 메뉴가 있으면 true 반환")
	@Test
	void hasOrderedMenu_true() {
		Orders orders = new Orders(
				Arrays.asList(
						new Order(MenuRepository.getMenu(1), 1),
						new Order(MenuRepository.getMenu(2), 2),
						new Order(MenuRepository.getMenu(3), 3)
				)
		);
		assertThat(orders.hasOrderedMenu(MenuRepository.getMenu(1))).isEqualTo(true);
	}

	@DisplayName("hasOrderedMenu 입력받은 메뉴가 없으면 false 반환")
	@Test
	void hasOrderedMenu_false() {
		Orders orders = new Orders(
				Arrays.asList(
						new Order(MenuRepository.getMenu(1), 1),
						new Order(MenuRepository.getMenu(2), 2),
						new Order(MenuRepository.getMenu(3), 3)
				)
		);
		assertThat(orders.hasOrderedMenu(MenuRepository.getMenu(4))).isEqualTo(false);
	}
}
