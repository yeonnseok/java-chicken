package domaintest;

import domain.Category;
import domain.Menu;
import domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    @DisplayName("주문 생성시 Count 0이하이거나 99 초과 일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void constructorTest(int count) {
        assertThatThrownBy(() -> {
            Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
            new Order(menu, count);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("해당 메뉴의 주문 가격 계산")
    @Test
    void calculateMenuPriceTest() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Order order = new Order(menu, 4);
        int menuPrice = order.calculateMenuPrice();
        assertThat(menuPrice).isEqualTo(64_000);
    }

}
