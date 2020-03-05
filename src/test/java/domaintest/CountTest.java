package domaintest;

import domain.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {

    @DisplayName("count 0이하이거나 99 초과 일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void constructorTest(int count) {
        assertThatThrownBy(() -> {
            new Count(count);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
