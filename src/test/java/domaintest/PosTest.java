package domaintest;

import domain.Pos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PosTest {

    @DisplayName("정수 입력 시 해당 enum 반환")
    @ParameterizedTest
    @CsvSource({"1,ORDER", "2,PAY", "3,EXIT", "100,NONE", "-2,NONE"})
    void posNumberTest(int posNumber, String posName) {
        assertThat(Pos.getPos(posNumber)).isEqualTo(Pos.valueOf(posName));
    }
}
