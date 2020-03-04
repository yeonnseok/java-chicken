package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderedMenuTest {
    @Test
    @DisplayName("주문한 메뉴와 수량을 곱하여 합계를 잘 반환하는지 확인")
    void calculateMenuPriceTest() {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        int quantity = 3;
        OrderedMenu orderedMenu = new OrderedMenu(menu, quantity);
        assertThat(orderedMenu.calculateMenuPriceSum());
    }
}
