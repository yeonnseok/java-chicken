package domaintest;

import domain.PayDecide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayDecideTest {

    @DisplayName("결제 확인 선택")
    @ParameterizedTest
    @CsvSource({"1,YES", "2,NO"})
    void paymentNumberTest(int payDecideNumber, String payDecideName) {
        assertThat(PayDecide.getPayDecide(payDecideNumber)).isEqualTo(PayDecide.valueOf(payDecideName));
    }

    @DisplayName("결제 확인 여부 외 다른 번호 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5})
    void payDecideExceptionTest(int payDecideNumber) {
        assertThatThrownBy(() -> {
            PayDecide.getPayDecide(payDecideNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
