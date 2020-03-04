package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderListTest {
    @Test
    @DisplayName("들어온 주문을 등록하는 기능 확인")
    void registerMenuTest() {
        OrderList orderList = new OrderList();
        orderList.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        orderList.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        orderList.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        List<OrderedMenu> testOrderList = Arrays.asList(new OrderedMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3)
                                                        , new OrderedMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5)
                                                        , new OrderedMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2));
        assertThat(orderList.getOrderList()).isEqualTo(testOrderList);
    }

    @Test
    @DisplayName("주문한 메뉴들의 가격 총합을 반환하는 기능 확인")
    void calculateMenuPriceSumTest() {
        OrderList orderList = new OrderList();
        orderList.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        orderList.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        orderList.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        assertThat(orderList.calculateMenuPriceSum()).isEqualTo(142000);
    }
}
