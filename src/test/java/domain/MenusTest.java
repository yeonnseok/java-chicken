package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenusTest {
    @ParameterizedTest
    @DisplayName("테이블 전체를 조회하여 존재하는 테이블 번호인지 확인")
    @CsvSource({"1,true", "6,true", "7,false", "21,true", "22,true", "23,false", "33,false"})
    void isPresentTableNumberTest(int menuNumber, boolean status) {
        Menus menus = new Menus();
        assertThat(menus.isPresentMenu(menuNumber)).isEqualTo(status);
    }
}
