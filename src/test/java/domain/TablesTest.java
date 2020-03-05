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
    @DisplayName("전달한 테이블 번호에 메뉴 등록하는 기능 테스트")
    void registerMenuTest() {
        Tables tables = new Tables();
        int tableNumber = 2;
        int quantity = 5;
        tables.registerMenu(tableNumber, 1, quantity);

        Table testTable = new Table(2);
        testTable.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), quantity);

        assertThat(tables.tables().get(1).getOrderList()).isEqualTo(testTable.getOrderList());
    }

    @Test
    @DisplayName("전달한 테이블 번호의 치킨 종류의 메뉴 개수를 잘 반환하는지 확인")
    void countChickenMenuTest() {
        Tables tables = new Tables();
        int tableNumber = 2;

        tables.registerMenu(tableNumber, 1, 5);
        tables.registerMenu(tableNumber, 2, 3);
        tables.registerMenu(tableNumber, 21, 10);

        assertThat(tables.countChickenMenu(tableNumber)).isEqualTo(8);
    }

    @Test
    @DisplayName("전달한 테이블 번호의 주문 내역 총합 가격을 잘 반환하는지 확인")
    void calculateTotalTotalMoneyTest() {
        Tables tables = new Tables();
        int tableNumber = 2;

        tables.registerMenu(tableNumber, 1, 1);
        tables.registerMenu(tableNumber, 2, 1);
        tables.registerMenu(tableNumber, 21, 1);

        assertThat(tables.calculateTotalMoney(tableNumber)).isEqualTo(33000);
    }
}
