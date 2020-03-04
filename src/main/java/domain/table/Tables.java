package domain.table;

import java.util.List;
import java.util.Optional;

/**
 * 테이블들의 일급 컬렉션
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Tables {
	private List<Table> tables;

	public Tables(List<Table> inputTables) {
		tables = Optional.ofNullable(inputTables)
				.orElseThrow(() -> new IllegalArgumentException("Tables에 잘못된 입력이 들어왔습니다."));
	}

	public List<Table> getTables() {
		return this.tables;
	}

	public Table getTable(final int inputNumber) {
		return tables.stream()
				.filter(table -> table.isSameNumber(inputNumber))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("해당되는 번호의 테이블이 없습니다."));
	}
}
