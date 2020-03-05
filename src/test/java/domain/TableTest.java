package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TableTest {
    private Table table;
    private Menu menu;
    private Quantity quantity;

    @BeforeEach
    private void setUp() {
        table = new Table(1);
        menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        quantity = new Quantity(1);
        table.addMenu(menu, quantity);
    }

    @DisplayName("없는 메뉴 추가 테스트")
    @Test
    void addMenuWithNewMenuTest() {
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();

        Map<Menu, Quantity> expected = new HashMap<>();
        expected.put(menu, quantity);

        Assertions.assertThat(orderInfo).isEqualTo(expected);
    }

    @DisplayName("기존에 있는 메뉴 추가 테스트")
    @Test
    void addMenuWithOriginalMenu() {
        table.addMenu(menu, quantity);
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();

        Map<Menu, Quantity> expected = new HashMap<>();
        expected.put(menu, quantity);
        expected.put(menu, quantity);

        Assertions.assertThat(orderInfo).isEqualTo(expected);
    }

    @DisplayName("기존에 있는 메뉴의 수량이 초과될 때 예외 출력 테스트")
    @Test
    void addMenuWithOverQuantityTest() {
        Assertions.assertThatThrownBy(() -> {
            table.addMenu(menu, new Quantity(99));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결제 후 주문 정보가 비워지는지 테스트")
    @Test
    void clearOrderTest() {
        table.clearOrder();
        Order order = table.getOrder();
        Map<Menu, Quantity> orderInfo = order.getOrderInfo();

        Assertions.assertThat(orderInfo.size()).isEqualTo(0);
    }
}
