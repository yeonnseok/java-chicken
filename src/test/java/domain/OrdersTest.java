package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

/**
 * 클래스 이름 : .java
 *
 * @author
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
