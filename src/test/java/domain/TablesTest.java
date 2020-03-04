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
        assertThat(Tables.isPresentTableNumber(tableNumber)).isEqualTo(status);
    }

    @Test
    @DisplayName("전달한 테이블 번호에 메뉴 등록하는 기능 테스트")
    void registerMenuTest() {
        Tables tables = new Tables();
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        int tableNumber = 1;
        int quantity = 5;
        tables.registerMenu(tableNumber, menu, quantity);

        Table testTable = new Table(2);
        testTable.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), quantity);

        assertThat(tables.tables().get(0).getOrderList()).isEqualTo(testTable.getOrderList());
    }

    @Test
    @DisplayName("전달한 테이블 번호의 치킨 종류의 메뉴 개수를 잘 반환하는지 확인")
    void countChickenMenuTest() {
        Tables tables = new Tables();
        int tableNumber = 2;
        Menu menu1 = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        Menu menu2 = new Menu(2, "양념", Category.CHICKEN, 18000);
        Menu menu3 = new Menu(4, "콜라", Category.BEVERAGE, 1800);

        tables.registerMenu(tableNumber, menu1, 5);
        tables.registerMenu(tableNumber, menu2, 3);
        tables.registerMenu(tableNumber, menu3, 10);

        assertThat(tables.countChickenMenu(tableNumber)).isEqualTo(8);
    }
}
