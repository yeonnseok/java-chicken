package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalMoneyCalculatorTest {
    @Test
    @DisplayName("Chicken Category 할인이 적용되는지 확인")
    void applyChickenCategoryDiscountTest() {
        Tables tables = new Tables();
        int tableNumber = 1;
        tables.registerMenu(tableNumber, 1, 4);
        tables.registerMenu(tableNumber, 2, 10);
        tables.registerMenu(tableNumber, 5, 20);

        TotalMoneyCalculator calculator = new TotalMoneyCalculator();
        PaymentWay paymentWay = new PaymentWay(1);

        assertThat(calculator.calculateTotalMoney(tables, tableNumber, paymentWay)).isEqualTo(534000);
    }

    @Test
    @DisplayName("결제 수단에 대한 할인이 적용되는지 확인")
    void applyPaymentWayDiscountTest() {
        Tables tables = new Tables();
        int tableNumber = 1;
        tables.registerMenu(tableNumber, 1, 1);
        tables.registerMenu(tableNumber, 2, 1);
        tables.registerMenu(tableNumber, 22, 2);

        TotalMoneyCalculator calculator = new TotalMoneyCalculator();
        PaymentWay paymentWay = new PaymentWay(2);
        double testMoney = 34000 * 0.95;

        assertThat(calculator.calculateTotalMoney(tables, tableNumber, paymentWay)).isEqualTo((int) testMoney);
    }

    @Test
    @DisplayName("치킨 할인과 현금 할인이 모두 적용되는지 확인")
    void calculateTotalMoneyTest() {
        Tables tables = new Tables();
        int tableNumber = 1;
        tables.registerMenu(tableNumber, 1, 10);
        tables.registerMenu(tableNumber, 5, 25);
        tables.registerMenu(tableNumber, 22, 20);
        double testTotalMoney = 16000 * 10 + 17000 * 25 + 1000 * 20 - 30000;

        TotalMoneyCalculator calculator = new TotalMoneyCalculator();
        PaymentWay paymentWay = new PaymentWay(2);
        testTotalMoney *= 0.95;

        assertThat(calculator.calculateTotalMoney(tables, tableNumber, paymentWay)).isEqualTo((int) testTotalMoney);
    }
}
