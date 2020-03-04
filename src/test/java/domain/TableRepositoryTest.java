package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TableRepositoryTest {
    @ParameterizedTest
    @DisplayName("테이블 전체를 조회하여 존재하는 테이블 번호인지 확인")
    @CsvSource({"1,true", "2,true", "4,false", "5,true", "8,true", "9,false", "11,false"})
    void isPresentTableNumberTest(int tableNumber, boolean status) {
        TableRepository tableRepository = new TableRepository();
        System.out.println("ggggg");
        assertThat(TableRepository.isPresentTableNumber(tableNumber)).isEqualTo(status);
    }
}
