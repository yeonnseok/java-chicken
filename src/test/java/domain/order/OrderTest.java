package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Order test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class OrderTest {

	@DisplayName("Order 생성자 정상 동작")
	@Test
	void Order() {
		assertThat(new Order(MenuRepository.getMenu(1), 1)).isInstanceOf(Order.class);
	}

	@DisplayName("Order 생성자 유효하지 않은 메뉴 입력시 예외처리")
	@Test
	void Order_invalid_menu_input() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Order(MenuRepository.getMenu(88), 1);
		}).withMessage("해당되는 번호의 메뉴가 없습니다.");
	}

	@DisplayName("Order 생성자 null 메뉴 입력시 예외처리")
	@ParameterizedTest
	@NullSource
	void Order_Null_menu_input(Menu nullMenu) {
		assertThatNullPointerException().isThrownBy(() -> {
			new Order(nullMenu, 1);
		}).withMessage("메뉴는 null일 수 없습니다.");
	}

	@DisplayName("Order 생성자 유효하지 않은 수량 입력시 예외처리")
	@ParameterizedTest
	@ValueSource(ints = {0, 100})
	void Order_invalid_amount_input(int inputAmount) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Order(MenuRepository.getMenu(1), inputAmount);
		}).withMessage("메뉴는 총 1개에서 99개 사이로 주문해야합니다.");
	}

	@DisplayName("orderMore 유효한 수량의 메뉴 추가시 정상 동작")
	@Test
	void orderMore() {
		Order order = new Order(MenuRepository.getMenu(1), 1);
		order.orderMore(10);
		assertThat(order.getAmount()).isEqualTo(11);
	}

	@DisplayName("orderMore 유효하지 않은 수량의 메뉴 추가시 예외처리")
	@ParameterizedTest
	@ValueSource(ints = {-20, 0, 100})
	void orderMore_invalid_range_input(int inputAmount) {
		Order order = new Order(MenuRepository.getMenu(1), 30);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			order.orderMore(inputAmount);
		}).withMessage("메뉴는 총 1개에서 99개 사이로 주문해야합니다.");
	}

	@DisplayName("orderMore 메뉴 추가시 총 수량이 유효하지 않을 경우 예외처리")
	@Test
	void orderMore_invalid_range_total_amount() {
		Order order = new Order(MenuRepository.getMenu(1), 30);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			order.orderMore(70);
		}).withMessage("메뉴는 총 1개에서 99개 사이로 주문해야합니다.");
	}

	@DisplayName("hasSameMenu 입력된 메뉴와 같은 메뉴가 order에 있다면 true 반환, 없다면 false 반환")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,false"})
	void hasSameMenu(int inputMenuNumber, boolean expected) {
		Order order = new Order(MenuRepository.getMenu(1), 10);
		assertThat(order.hasSameMenu(MenuRepository.getMenu(inputMenuNumber)))
				.isEqualTo(expected);
	}
}
