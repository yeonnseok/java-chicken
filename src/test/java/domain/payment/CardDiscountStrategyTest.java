package domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class CardDiscountStrategyTest {
	@DisplayName("create 정적 팩토리 메서드로 CardDiscountStrategy객체가 생성되는지 확인")
	@Test
	void create() {
		assertThat(CardDiscountStrategy.create()).isInstanceOf(CardDiscountStrategy.class);
	}

	@DisplayName("discount 10000원 입력시 PaymentType에 따라 할인된 가격이 반환")
	@CsvSource(value = {"1,10000", "2, 9500"})
	@ParameterizedTest
	void discount(int inputPaymentTypeNumber, int expected) {
		PaymentType paymentType = PaymentType.of(inputPaymentTypeNumber);
		assertThat(CardDiscountStrategy.discount(10000, paymentType)).isEqualTo(expected);
	}
}
