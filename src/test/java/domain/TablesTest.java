package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesTest {
    @ParameterizedTest
    @DisplayName("테이블 전체를 조회하여 존재하는 테이블 번호인지 확인")
    @CsvSource({"1,true", "2,true", "4,false", "5,true", "8,true", "9,false", "11,false"})
    void isPresentTableNumberTest(int tableNumber, boolean status) {
        Tables tables = new Tables();
        assertThat(tables.isPresentTableNumber(tableNumber)).isEqualTo(status);
    }

    @Test
    @DisplayName("전달한 테이블 번호의 주문 내역 총합 가격을 잘 반환하는지 확인")
    void calculateTotalTotalMoneyTest() {
        Tables tables = new Tables();
        Menus menus = new Menus();
        int tableNumber = 2;

        Table table = tables.getTable(tableNumber);
        table.registerMenu(menus.getMenu(1), 1);
        table.registerMenu(menus.getMenu(2), 1);
        table.registerMenu(menus.getMenu(21), 1);

        assertThat(tables.calculateTotalMoney(tableNumber)).isEqualTo(33000);
    }
}
