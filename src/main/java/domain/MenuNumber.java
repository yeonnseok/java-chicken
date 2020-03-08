package domain;

public class MenuNumber {
    private int menuNumber;

    public MenuNumber(final int menuNumber) {
        checkMenuRange(menuNumber);
        this.menuNumber = menuNumber;
    }

    private void checkMenuRange(final int menuNumber) {
        if (MenuRepository.menus()
                .stream()
                .mapToInt(Menu::getNumber)
                .noneMatch(number -> number == menuNumber)) {
            throw new IllegalArgumentException("주문할 수 있는 메뉴 번호가 아닙니다.");
        }
    }

    public int getNumber() {
        return menuNumber;
    }
}
