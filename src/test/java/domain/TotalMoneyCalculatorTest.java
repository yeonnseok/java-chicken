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
        Menu menu1 = new Menu(1,"후라이드", Category.CHICKEN, 16000);
        Menu menu2 = new Menu(2,"양념", Category.CHICKEN, 18000);
        Menu menu3 = new Menu(3,"반반", Category.CHICKEN, 17000);
        tables.registerMenu(tableNumber, menu1, 4);
        tables.registerMenu(tableNumber, menu2, 10);
        tables.registerMenu(tableNumber, menu3, 20);

        TotalMoneyCalculator calculator = new TotalMoneyCalculator();
        PaymentWay paymentWay = new PaymentWay(1);

        assertThat(calculator.calculateTotalMoney(tables, tableNumber, paymentWay)).isEqualTo(554000);
    }
}
