package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 치킨집에 있는 모든 테이블들을 생성해둔 테이블 레포지토리
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public static Table getTable(int inputNumber) {
		return tables.stream()
				.filter(table -> table.isSameNumber(inputNumber))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("해당되는 번호의 테이블이 없습니다."));
	}
}
