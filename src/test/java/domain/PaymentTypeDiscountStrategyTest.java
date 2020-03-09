package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTypeDiscountStrategyTest {
    @DisplayName("현금으로 결제 시 5% 할인 기능 테스트")
    @Test
    void cashDiscountTest() {
        Table table = new Table(1);
        PaymentType paymentType = PaymentType.CASH;
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Menu sourceChicken = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
        Menu halfChicken = new Menu(3, "반반치킨", Category.CHICKEN, 16_000);
        Quantity friedQuantity = new Quantity(10);
        Quantity sourceQuantity = new Quantity(15);
        Quantity halfQuantity = new Quantity(20);
        table.addMenu(friedChicken, friedQuantity);
        table.addMenu(sourceChicken, sourceQuantity);
        table.addMenu(halfChicken, halfQuantity);

        int allMenuPrice = 720_000;

        Assertions.assertThat(PaymentTypeDiscountStrategy.discountByPaymentType(allMenuPrice, paymentType))
                .isEqualTo(684_000);
    }
}
