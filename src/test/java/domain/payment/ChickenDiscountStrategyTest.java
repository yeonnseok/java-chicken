package domain.payment;

import domain.menu.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	private Table table;

	@BeforeEach
	void setUp() {
		table = TableRepository.getTable(1);
	}

	@AfterEach
	void tearDown() {
		table.cleanTable();
	}

	@DisplayName("create 정적 팩토리 메서드로 ChickenDiscountStrategy 객체가 생성되는지 확인")
	@Test
	void create() {
		assertThat(ChickenDiscountStrategy.create()).isInstanceOf(ChickenDiscountStrategy.class);
	}

	@DisplayName("discount 후라이드 치킨 29개 입력시 할인이 적용되어 444_000이 반환되는지 확인")
	@Test
	void discount() {
		Order order = new Order(MenuRepository.getMenu(1), 20);
		Order otherOrder = new Order(MenuRepository.getMenu(1), 9);

		table.order(order);
		table.order(otherOrder);

		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(table, PaymentType.CASH)).isEqualTo(444_000);
	}

	@DisplayName("discount 후라이드 치킨 9개 입력시 할인 적용이 안되어 144_000이 반환되는지 확인")
	@Test
	void discount_not_applied_invalid_amount() {
		Order order = new Order(MenuRepository.getMenu(1), 9);

		table.order(order);

		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(table, PaymentType.CASH)).isEqualTo(144_000);
	}

	@DisplayName("discount 음료 카테고리 99개 입력시 할인 적용이 안되어 99_000이 반환되는지 확인")
	@Test
	void discount_not_applied_invalid_category() {
		Order order = new Order(MenuRepository.getMenu(21), 99);

		table.order(order);

		Discountable discountStrategy = ChickenDiscountStrategy.create();

		assertThat(discountStrategy.discount(table, PaymentType.CASH)).isEqualTo(99_000);
	}
}
