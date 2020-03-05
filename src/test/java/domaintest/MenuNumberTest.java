package domaintest;

import domain.MenuNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuNumberTest {

    @DisplayName("메뉴 번호 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 33, 1000})
    void constructorTest(int number) {
        assertThatThrownBy(() -> {
            new MenuNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
