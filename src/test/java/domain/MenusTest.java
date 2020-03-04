package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenusTest {
    @DisplayName("유효한 메뉴를 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
    void getMenuTest(int input) {
        Menus menus = new Menus(MenuRepository.menus());

        Assertions.assertThat(menus.getMenuByMenuNumber(input)).isInstanceOf(Menu.class);
    }

    @DisplayName("유효하지 않은 메뉴를 가져올 때 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 7, 20, 23})
    void getMenuWithInvalidMenuNumberTest(int input) {
        Menus menus = new Menus(MenuRepository.menus());

        Assertions.assertThatThrownBy(() -> {
            menus.getMenuByMenuNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
