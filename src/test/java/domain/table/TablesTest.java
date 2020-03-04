package domain.table;

import domain.table.Table;
import domain.table.TableRepository;
import domain.table.Tables;
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
}
