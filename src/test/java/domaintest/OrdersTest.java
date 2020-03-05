package domaintest;

import domain.Category;
import domain.Menu;
import domain.Order;
import domain.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {
    private Orders orders;

    @BeforeEach
    void setUp() {
        Menu menu1 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Menu menu2 = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
        Menu menu3 = new Menu(3, "반반치킨", Category.CHICKEN, 16_000);
        Menu menu4 = new Menu(4, "통구이", Category.CHICKEN, 16_000);
        orders = new Orders();
        orders.addOrder(new Order(menu1, 3));
        orders.addOrder(new Order(menu2, 2));
        orders.addOrder(new Order(menu3, 1));
        orders.addOrder(new Order(menu4, 4));
    }

    @DisplayName("주문 등록 된 음식 가격 합산")
    @Test
    void calculateTotalPrice() {
        int totalPrice = orders.calculateTotalPrice();
        assertThat(totalPrice).isEqualTo(160_000);
    }
}
