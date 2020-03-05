package domaintest;

import domain.*;
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
        Menu menu5 = new Menu(22, "사이다", Category.BEVERAGE, 1_000);
        orders = new Orders();
        orders.addOrder(menu1, new Count(20));
        orders.addOrder(menu2, new Count(20));
        orders.addOrder(menu3, new Count(1));
        orders.addOrder(menu4, new Count(4));
        orders.addOrder(menu5, new Count(2));
    }


    @DisplayName("치킨 종류 메뉴 총 개수 계산")
    @Test
    void countChickenTypeTest() {
        int chickenCount = orders.countChickenType();
        assertThat(chickenCount).isEqualTo(45);
    }

    @DisplayName("치킨 종류 개수 10개당 10_000원씩 할인")
    @Test
    void discountByChickenTypeTest() {
        int discountedTotalPrice = orders.totalPriceDiscountedByChickenCount();
        assertThat(discountedTotalPrice).isEqualTo(682_000);
    }
}
