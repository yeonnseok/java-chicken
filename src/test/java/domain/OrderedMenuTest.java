package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderedMenuTest {
    @Test
    @DisplayName("주문한 메뉴와 수량을 곱하여 합계를 잘 반환하는지 확인")
    void calculateMenuPriceTest() {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        int quantity = 3;
        OrderedMenu orderedMenu = new OrderedMenu(menu, quantity);
        assertThat(orderedMenu.calculateMenuPriceSum());
    }

    @Test
    @DisplayName("추가한 수량이 제대로 더해지는지 확인")
    void addQuantityTest() {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        int firstQuantity = 2;
        OrderedMenu orderedMenu = new OrderedMenu(menu, firstQuantity);
        int addQuantity = 3;

        orderedMenu.addQuantity(addQuantity);
        assertThat(orderedMenu.getQuantity()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({"0,100", "1,99", "99,1", "98,2", "3,97", "50,50"})
    @DisplayName("한 메뉴에 대한 최대 주문량을 초과하면 예외 발생하는지 확인")
    void maxQuantityTest(int nowQuantity, int addQuantity) {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        OrderedMenu orderedMenu = new OrderedMenu(menu, nowQuantity);

        assertThatThrownBy(() -> {
            orderedMenu.addQuantity(addQuantity);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("한 메뉴에 대해 최대 99개까지 주문가능합니다. 현재 주문량 : %d", nowQuantity));
    }
}
