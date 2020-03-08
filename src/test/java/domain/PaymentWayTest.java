package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentWayTest {
    @Test
    @DisplayName("결제 수단으로 1과 2 외의 다른 값을 입력했을 때 예외 발생")
    void validatePayment() {
        assertThatThrownBy(() -> {
            PaymentWay paymentWay = PaymentWay.getPayment(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("결제 수단으로는 1 또는 2만 입력해야 합니다. 입력값 : %d", -1));
    }

    @ParameterizedTest
    @CsvSource({"1,false", "2,true"})
    @DisplayName("현금으로 계산하는지 확인")
    void isCashTest(int payWay, boolean status) {
        PaymentWay paymentWay = PaymentWay.getPayment(payWay);

        assertThat(paymentWay.isCash()).isEqualTo(status);
    }
}
