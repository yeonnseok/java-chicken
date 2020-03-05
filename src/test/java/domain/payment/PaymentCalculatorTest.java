package domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PaymentCalculator test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class PaymentCalculatorTest {
	@DisplayName("PaymentCalculator 생성자 정상 동작 확인")
	@Test
	void PaymentCalculator() {
		assertThat(new PaymentCalculator()).isInstanceOf(PaymentCalculator.class);
	}
}
