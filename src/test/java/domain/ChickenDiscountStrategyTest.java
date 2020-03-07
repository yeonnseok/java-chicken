package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChickenDiscountStrategyTest {
    @DisplayName("치킨의 수에 맞게 할인금액을 계산하는지 테스트")
    @Test
    void chickenDiscountStrategyTest() {
        Table table = new Table(1);
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Menu sourceChicken = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
        Menu halfChicken = new Menu(3, "반반치킨", Category.CHICKEN, 16_000);
        Quantity friedQuantity = new Quantity(10);
        Quantity sourceQuantity = new Quantity(15);
        Quantity halfQuantity = new Quantity(20);
        table.addMenu(friedChicken, friedQuantity);
        table.addMenu(sourceChicken, sourceQuantity);
        table.addMenu(halfChicken, halfQuantity);

        DiscountByCategory chickenDiscountStrategy = ChickenDiscountStrategy.create();
        int chickenDiscountPrice = chickenDiscountStrategy.discountByCategory(table);

        Assertions.assertThat(chickenDiscountPrice).isEqualTo(40_000);
    }
}
