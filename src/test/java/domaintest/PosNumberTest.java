package domaintest;

import domain.PosNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PosNumberTest {

    @DisplayName("정수 입력 시 해당 enum 반환")
    @ParameterizedTest
    @CsvSource({"1,ORDER", "2,PAY", "3,EXIT"})
    void posNumberTest(int posNumber, String posName) {
        assertThat(PosNumber.getPosNumber(posNumber)).isEqualTo(PosNumber.valueOf(posName));
    }
}
