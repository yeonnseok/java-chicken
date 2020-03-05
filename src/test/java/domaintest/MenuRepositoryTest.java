package domaintest;

import domain.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRepositoryTest {

    @DisplayName("메뉴 사이즈 확인")
    @Test
    void menuSizeTest() {
        int menuSize = MenuRepository.menus().size();
        assertThat(menuSize).isEqualTo(8);
    }
}