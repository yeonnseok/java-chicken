package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTypeTest {
    @DisplayName("입력한 값이 유효한 결제 수단인지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void getPaymentTypeTest(int input) {
        PaymentType paymentType = PaymentType.getPaymentType(input);

        Assertions.assertThat(paymentType).isInstanceOf(PaymentType.class);
    }

    @DisplayName("유효하지 않은 결제 수단을 입력했을 때 예외 출력 테스트")
    @Test
    void getPaymentTypeWithInvalidInput() {
        Assertions.assertThatThrownBy(() -> {
            PaymentType.getPaymentType(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
