package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Table table;
    private Menu friedChicken;
    private Menu coke;
    PaymentType credit;
    PaymentType cash;

    @BeforeEach
    private void setUp() {
        table = new Table(1);
        friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        coke = new Menu(21, "콜라", Category.BEVERAGE, 1_000);
        credit = PaymentType.CREDIT;
        cash = PaymentType.CASH;
    }

    @DisplayName("결제 기능 테스트")
    @Test
    void calculateByCreditTest() {
        Quantity quantity = new Quantity(1);
        table.addMenu(friedChicken, quantity);
        table.addMenu(coke, quantity);

        int amountByCredit = Calculator.calculate(table, credit);
        int amountByCash = Calculator.calculate(table, cash);

        Assertions.assertThat(amountByCredit).isEqualTo(17_000);
        Assertions.assertThat(amountByCash).isEqualTo(16_150);
    }

    @DisplayName("10개 이상의 치킨 메뉴 항목에 대해 할인 기능 테스트")
    @Test
    void calculateOverTenQuantityTest() {
        Quantity quantity = new Quantity(10);
        table.addMenu(friedChicken, quantity);
        table.addMenu(coke, quantity);

        int amountByCredit = Calculator.calculate(table, credit);
        int amountByCash = Calculator.calculate(table, cash);

        Assertions.assertThat(amountByCredit).isEqualTo(160_000);
        Assertions.assertThat(amountByCash).isEqualTo(152_000);
    }
}
