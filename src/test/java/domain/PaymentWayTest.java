package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentWayTest {
    @Test
    @DisplayName("결제 수단으로 1과 2 외의 다른 값을 입력했을 때 예외 발생")
    void validatePayment() {
        assertThatThrownBy(() -> {
            PaymentWay paymentWay = new PaymentWay(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("결제 수단으로는 1 또는 2만 입력해야 합니다. 입력값 : %d", -1));
    }
}
