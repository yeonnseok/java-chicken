package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("숫자가 아닌 입력값이 들어온 경우 예외 발생")
    void validateNumberTest() {
        String input = "aaa";
        assertThatThrownBy(() -> {
            InputView.validateNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력값은 숫자로만 입력해야합니다. 입력값 : %s", input));
    }

    @Test
    @DisplayName("음수의 입력값이 입력될 경우 예외 발생")
    void validateNegativeNumberTest() {
        int input = -1;
        assertThatThrownBy(() -> {
            InputView.validateNegativeNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("수량은 0이상의 수를 입력해야 합니다. 입력한 수 : %d", input));
    }
}
