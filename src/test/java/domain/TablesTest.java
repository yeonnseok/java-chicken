package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TablesTest {
    @DisplayName("유효한 테이블을 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 6, 8})
    void getTableTest(int input) {
        Tables tables = new Tables(TableRepository.tables());

        Assertions.assertThat(tables.getTable(input)).isInstanceOf(Table.class);
    }

    @DisplayName("유효하지 않은 테이블을 가져올 때 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 0, 9})
    void getTableWithInvalidTableNumberTest(int input) {
        Tables tables = new Tables(TableRepository.tables());

        Assertions.assertThatThrownBy(() -> {
            tables.getTable(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
