package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @Test
    @DisplayName("메뉴가 수량만큼 메뉴의 가격과 곱하여 한 메뉴의 합계를 반환하는지 확인")
    void calculateMenuPriceSumTest() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        int quantity = 3;
        assertThat(menu.calculateMenuPriceSum(quantity)).isEqualTo(48000);
    }

    @ParameterizedTest
    @CsvSource({"1,1,true", "2,2,true", "3,4,false", "10,12,false", "100,100,true"})
    @DisplayName("해당 메뉴의 번호와 전달된 번호가 일치하는지 확인")
    void isPresentMenu(int menuNumber, int testMenuNumber, boolean status) {
        Menu menu = new Menu(menuNumber, "후라이드", Category.CHICKEN, 16000);
        assertThat(menu.isMatchMenu(testMenuNumber)).isEqualTo(status);
    }

    @Test
    @DisplayName("치킨 카테고리인지 확인하는 기능 테스트")
    void isChickenCategoryTest() {
        Menu menu1 = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        assertThat(menu1.isChickenCategory()).isEqualTo(true);

        Menu menu2 = new Menu(2, "양념", Category.CHICKEN, 17000);
        assertThat(menu2.isChickenCategory()).isEqualTo(true);

        Menu menu3 = new Menu(3, "콜라", Category.BEVERAGE, 1600);
        assertThat(menu3.isChickenCategory()).isEqualTo(false);
    }
}
