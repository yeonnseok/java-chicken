package domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class MenuTest {
	@DisplayName("isChickenCategory 치킨 카테고리 메뉴는 true, 없으면 false 반환")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "21,false"})
	void isChickenCategory(int menuNumber, boolean expected) {
		Menu menu = MenuRepository.getMenu(menuNumber);
		assertThat(menu.isChickenCategory()).isEqualTo(expected);
	}
}
