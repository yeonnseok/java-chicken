package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 클래스 이름 : .java
 *
 * @author
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
