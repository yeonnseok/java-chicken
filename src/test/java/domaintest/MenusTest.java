package domaintest;

import domain.Category;
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

    @DisplayName("메뉴 번호로 해당 메뉴 반환 여부 확인")
    @Test
    void getMenusByNumberTest() {
        Menus menus = new Menus(MenuRepository.menus());
        Menu menu1 = menus.getMenuByNumber(1);
        assertThat(menu1).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));

        Menu menu2 = menus.getMenuByNumber(2);
        assertThat(menu2).isEqualTo(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
    }
}
