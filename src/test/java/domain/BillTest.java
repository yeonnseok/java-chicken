package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BillTest {
    @Test
    @DisplayName("들어온 주문을 등록하는 기능 확인")
    void registerMenuTest() {
        Bill bill = new Bill();
        bill.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        bill.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        bill.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        List<OrderedMenu> testOrderList = Arrays.asList(
                new OrderedMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3),
                new OrderedMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5),
                new OrderedMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2));
        assertThat(bill.getOrderedMenus()).isEqualTo(testOrderList);
    }

    @Test
    @DisplayName("주문한 메뉴들의 가격 총합을 반환하는 기능 확인")
    void calculateMenuPriceSumTest() {
        Bill bill = new Bill();
        bill.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        bill.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        bill.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        assertThat(bill.calculateMenuPriceSum()).isEqualTo(142000);
    }

    @Test
    @DisplayName("Category가 치킨인 메뉴의 개수 반환하는 기능 확인")
    void countChickenMenuTest() {
        Bill bill = new Bill();
        bill.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        bill.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        bill.registerMenu(new Menu(6, "반반", Category.CHICKEN, 17000), 1);
        bill.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        assertThat(bill.countChickenMenu()).isEqualTo(9);
    }

    @Test
    @DisplayName("결제 완료 후, 테이블의 주문 내역 초기화 확인")
    void initOrderListTest() {
        Bill bill = new Bill();
        bill.registerMenu(new Menu(1, "후라이드", Category.CHICKEN, 16000), 3);
        bill.registerMenu(new Menu(2, "양념", Category.CHICKEN, 18000), 5);
        bill.registerMenu(new Menu(6, "반반", Category.CHICKEN, 17000), 1);
        bill.registerMenu(new Menu(5, "콜라", Category.BEVERAGE, 2000), 2);

        assertThat(bill.getOrderedMenus().size()).isEqualTo(4);
        bill.initOrderList();
        assertThat(bill.getOrderedMenus().size()).isEqualTo(0);
    }
}
