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

    @DisplayName("현재 주문 진행 중인 테이블 이외의 테이블 번호 입력시 예외 발생 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    void existedTableNumberTest(int inputNumber) {
        assertThatThrownBy(() -> {
            TableNumber tableNumber = new TableNumber(3);
            checkExistedTableNumber(tableNumber, inputNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 주문 진행중인 테이블만 선택가능합니다.");
    }

    private static void checkExistedTableNumber(TableNumber tableNumber, int inputNumber) {
        if (tableNumber.isNotZeroAndNotSameValueWith(inputNumber)) {
            throw new IllegalArgumentException("현재 주문 진행중인 테이블만 선택가능합니다.");
        }
    }
}
