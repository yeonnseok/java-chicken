package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * PosStatus test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class PosStatusTest {

	@DisplayName("of 유효한 번호 입력시 정상 동작")
	@Test
	void of() {
		assertThat(PosStatus.of(1)).isEqualTo(PosStatus.STATUS_ORDER);
	}

	@DisplayName("of 유효하지 않은 번호 입력시 예외처리")
	@Test
	void of_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			PosStatus.of(9);
		}).withMessage("기능번호가 유효하지 않습니다.");
	}
}
