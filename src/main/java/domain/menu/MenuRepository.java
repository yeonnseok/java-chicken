package domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 치킨집에서 판매하는 메뉴들을 캐시로 모아둔 메뉴 레포지토리
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class MenuRepository {
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

	public static List<Menu> menus() {
		return Collections.unmodifiableList(menus);
	}

	public static Menu getMenu(int inputNumber) {
		return menus.stream()
				.filter(menu -> menu.getNumber() == inputNumber)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("해당되는 번호의 메뉴가 없습니다."));
	}
}
