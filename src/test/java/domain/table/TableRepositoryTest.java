package domain.table;

import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * TableRepository test
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class TableRepositoryTest {

	@DisplayName("getTable 입력한 table번호와 같은 테이블을 반환하는지 확인")
	@Test
	void getTable() {
		Table table = new Table(1);
		assertThat(TableRepository.getTable(1)).isEqualTo(table);
	}

	@DisplayName("getTable 입력한 table번호가 없을시 예외처리")
	@Test
	void getTable_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			TableRepository.getTable(10);
		}).withMessage("해당되는 번호의 테이블이 없습니다.");
	}
}
