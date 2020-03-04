package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderedMenuTest {
    @ParameterizedTest
    @CsvSource({"0,0", "1,16000", "3,48000", "10,1600000", "53, 848000", "93,1488000"})
    @DisplayName("주문한 메뉴와 수량을 곱하여 합계를 잘 반환하는지 확인")
    void calculateMenuPriceTest() {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        int quantity = 3;
        OrderedMenu orderedMenu = new OrderedMenu(menu, quantity);
        assertThat(orderedMenu.calculateMenuPriceSum());
    }

    @ParameterizedTest
    @CsvSource({"2,3,5", "0,9,9", "10,10,20", "80,9,89", "50,30,80"})
    @DisplayName("추가한 수량이 제대로 더해지는지 확인")
    void addQuantityTest(int nowQuantity, int addQuantity, int totalQuantity) {
        Menu menu = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        OrderedMenu orderedMenu = new OrderedMenu(menu, nowQuantity);

        orderedMenu.addQuantity(addQuantity);
        assertThat(orderedMenu.getQuantity()).isEqualTo(totalQuantity);
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

    @Test
    @DisplayName("음수의 수량이 입력될 경우 예외 발생하는지 확인")
    void validateNegativeNumberTest() {
        OrderedMenu orderedMenu = new OrderedMenu(new Menu(1,"후라이드", Category.CHICKEN, 16000), 0);
        int addQuantity = -1;
        assertThatThrownBy(() -> {
            orderedMenu.addQuantity(addQuantity);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("수량은 0이상의 수를 입력해야 합니다. 입력한 수 : %d", addQuantity));
    }
}
