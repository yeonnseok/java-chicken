package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
}
