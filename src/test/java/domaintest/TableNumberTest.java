package domaintest;

import domain.TableNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableNumberTest {

    @DisplayName("테이블 넘버 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    void constructorTest(int number) {
        assertThatThrownBy(() -> {
            new TableNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
