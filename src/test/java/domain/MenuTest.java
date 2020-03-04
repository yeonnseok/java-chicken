package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @Test
    @DisplayName("메뉴가 수량만큼 메뉴의 가격과 곱하여 한 메뉴의 합계를 반환하는지 확인")
    void calculateMenuPriceSumTest() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        int quantity = 3;
        assertThat(menu.calculateMenuPriceSum(quantity)).isEqualTo(48000);
    }
}
