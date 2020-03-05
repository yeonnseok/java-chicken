package domaintest;

import domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {

    @DisplayName("결제 기능 선택")
    @ParameterizedTest
    @CsvSource({"1,CARD", "2,CASH", "3,NONE", "0,NONE"})
    void paymentNumberTest(int paymentNumber, String paymentName) {
        assertThat(Payment.getPayment(paymentNumber)).isEqualTo(Payment.valueOf(paymentName));
    }

    @DisplayName("현금 결제시 5% 할인 테스트")
    @ParameterizedTest
    @CsvSource({"CARD,30000,30000", "CASH,30000,28500", "NONE,30000,30000"})
    void cardDiscountTest(String paymentName, int totalPrice, int discountedTotalPrice) {
        Payment payment = Payment.valueOf(paymentName);
        int totalPriceAfterPaymentDiscount = payment.totalPriceAfterPaymentDiscount(totalPrice);
        assertThat(totalPriceAfterPaymentDiscount).isEqualTo(discountedTotalPrice);
    }
}
