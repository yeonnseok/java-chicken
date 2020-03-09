package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {
    @DisplayName("유효하지 않은 값으로 생성할 때 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 100})
    void quantityConstructorTest(int input) {
        Assertions.assertThatThrownBy(() -> {
            new Quantity(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수량을 99개 이상으로 증가시킬 때 예외 출력 테스트")
    @Test
    void addQuantityTest() {
        Quantity quantity = new Quantity(50);
        Quantity otherQuantity = new Quantity(50);

        Assertions.assertThatThrownBy(() -> {
            quantity.addQuantity(otherQuantity);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
