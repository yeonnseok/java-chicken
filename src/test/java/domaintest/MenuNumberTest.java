package domaintest;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuNumberTest {

    @DisplayName("메뉴 번호 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 33, 1000})
    void constructorTest(int number) {
        assertThatThrownBy(() -> {
            new MenuNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 번호와 일치하는 메뉴 인스턴스 반환")
    @Test
    void getMenuByNumberTest() {
        Menus menus = new Menus(MenuRepository.menus());
        MenuNumber menuNumber = new MenuNumber(1);
        Menu menu = menus.getMenuByNumber(menuNumber);
        assertThat(menu).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }
}
