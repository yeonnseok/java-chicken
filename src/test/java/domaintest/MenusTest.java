package domaintest;

import domain.Menu;
import domain.MenuRepository;
import domain.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenusTest {

    @DisplayName("메뉴 목록 길이 확인")
    @Test
    void getTablesTest() {
        Menus menus = new Menus(MenuRepository.menus());
        List<Menu> menuList = menus.getMenus();
        assertThat(menuList.size()).isEqualTo(8);
    }
}
