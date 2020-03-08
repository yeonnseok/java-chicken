package domaintest;

import domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {

    @DisplayName("결제 기능 선택")
    @ParameterizedTest
    @CsvSource({"1,CARD", "2,CASH"})
    void paymentNumberTest(int paymentNumber, String paymentName) {
        assertThat(Payment.getPayment(paymentNumber)).isEqualTo(Payment.valueOf(paymentName));
    }

    @DisplayName("결제 수단 외 다른 번호 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5})
    void paymentExceptionTest(int paymentNumber) {
        assertThatThrownBy(() -> {
            Payment.getPayment(paymentNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("현금 결제시 5% 할인 테스트")
    @ParameterizedTest
    @CsvSource({"CARD,30000,30000", "CASH,30000,28500"})
    void cardDiscountTest(String paymentName, int totalPrice, int discountedTotalPrice) {
        Payment payment = Payment.valueOf(paymentName);
        int totalPriceAfterPaymentDiscount = payment.totalPriceAfterDiscount(totalPrice);
        assertThat(totalPriceAfterPaymentDiscount).isEqualTo(discountedTotalPrice);
    }
}
