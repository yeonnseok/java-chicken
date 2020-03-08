package domain.table;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Tables test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class TablesTest {
	@DisplayName("Tables 생성자 정상 동작")
	@Test
	void Tables() {
		assertThat(new Tables(TableRepository.tables())).isInstanceOf(Tables.class);
	}

	@DisplayName("Tables 생성자 null 입력시 예외처리")
	@ParameterizedTest
	@NullSource
	void Table_null_input(List<Table> nullInput) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Tables(nullInput);
		}).withMessage("Tables에 잘못된 입력이 들어왔습니다.");
	}

	@DisplayName("getTable 유효한 테이블 번호 입력시 테이블 반환")
	@Test
	void getTable() {
		Tables tables = new Tables(TableRepository.tables());
		assertThat(tables.getTable(1)).isEqualTo(new Table(1));
	}

	@DisplayName("getTable 유효하지 않은 테이블 번호 입력시 예외처리")
	@Test
	void getTable_exception() {
		Tables tables = new Tables(TableRepository.tables());
		assertThatIllegalArgumentException().isThrownBy(() -> {
			tables.getTable(99);
		}).withMessage("해당되는 번호의 테이블이 없습니다.");
	}
}
