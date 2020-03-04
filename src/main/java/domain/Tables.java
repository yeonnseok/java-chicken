package domain;

import java.util.List;
import java.util.Optional;

/**
 * 클래스 이름 : .java
 *
 * @author
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

}
