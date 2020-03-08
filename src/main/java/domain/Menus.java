package domain;

import java.util.List;

public class Menus {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Menu getMenuByNumber(MenuNumber menuNumber) {
        return menus.stream()
                .filter(menu -> menu.getNumber() == menuNumber.getNumber())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }
}
