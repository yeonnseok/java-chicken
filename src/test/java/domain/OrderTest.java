package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class OrderTest {

	@DisplayName("Order 생성자 정상 동작 확인")
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
		}).withMessage("1개에서 99개 사이로 주문해야합니다.");
	}
}
