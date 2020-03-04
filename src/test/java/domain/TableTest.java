package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {
    @ParameterizedTest
    @CsvSource({"1,1,true", "1,2,false", "3,3,true", "1,7,false", "100,100,true", "99,100,false"})
    @DisplayName("테이블 번호가 존재하는지 매칭하는 기능 테스트")
    void isPresentTableNumberTest(int tableNumber, int testTableNumber, boolean status) {
        Table table = new Table(tableNumber);
        assertThat(table.isPresentTableNumber(testTableNumber)).isEqualTo(status);
    }

//    @Test
//    @DisplayName("주문받은 메뉴와 수량을 등록하는 기능 확인")
//    void isFinishPayTest() {
//        Table table = new Table(1);
//        table.registerMenu(new Menu(1,"후라이드", Category.CHICKEN, 16000), quantity);
//        assertThat()
//    }
}
