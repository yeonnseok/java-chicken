package domain;

import java.util.List;

public class Menus {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }


    public Menu getMenu(int menuNumber) {
        return this.menus.stream()
                .filter(menu -> menu.isSameMenuNumber(menuNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 번호를 입력하였습니다."));
    }
}
