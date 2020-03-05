package domaintest;

import domain.Category;
import domain.Count;
import domain.Menu;
import domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    @DisplayName("해당 메뉴의 주문 가격 계산")
    @Test
    void calculateMenuPriceTest() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Order order = new Order(menu, new Count(4));
        int menuPrice = order.calculateMenuPrice();
        assertThat(menuPrice).isEqualTo(64_000);
    }

}
