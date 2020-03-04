package domain.payment;

import domain.menu.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class ChickenDiscountStrategyTest {
	@DisplayName("create 정적 팩토리 메서드로 ChickenDiscountStrategy 객체가 생성되는지 확인")
	@Test
	void create() {
		assertThat(ChickenDiscountStrategy.create()).isInstanceOf(ChickenDiscountStrategy.class);
	}

	@DisplayName("discount 후라이드 치킨 29개 입력시 할인이 적용되어 444_000이 반환되는지 확인")
	@Test
	void discount() {
		Order order = new Order(MenuRepository.getMenu(1), 20);
		order.orderMore(9);
		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(order)).isEqualTo(444_000);
	}

	@DisplayName("discount 후라이드 치킨 9개 입력시 할인 적용이 안되어 144_000이 반환되는지 확인")
	@Test
	void discount_not_applied_invalid_amount() {
		Order order = new Order(MenuRepository.getMenu(1), 9);
		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(order)).isEqualTo(144_000);
	}

	@DisplayName("discount 음료 카테고리 99개 입력시 할인 적용이 안되어 99_000이 반환되는지 확인")
	@Test
	void discount_not_applied_invalid_category() {
		Order order = new Order(MenuRepository.getMenu(21), 99);
		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(order)).isEqualTo(99_000);
	}
}
