package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menus {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public boolean isPresentMenu(int menuNumber) {
        return menus.stream()
                .anyMatch(m -> m.isMatchMenu(menuNumber));
    }

    public static List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public Menu getMenu(int inputRegisterMenu) {
        return menus.stream()
                .filter(m -> m.isMatchMenu(inputRegisterMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴번호입니다."));
    }
}
