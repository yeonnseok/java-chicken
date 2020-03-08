package domaintest;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesTest {

    @DisplayName("테이블 목록 길이 확인")
    @Test
    void getTablesTest() {
        Tables tables = new Tables(TableRepository.tables());
        List<Table> tableList = tables.getTables();
        assertThat(tableList.size()).isEqualTo(6);
    }

    @DisplayName("테이블 번호로 해당 테이블 반환 여부 확인")
    @Test
    void getMenusByNumberTest() {
        Tables tables = new Tables(TableRepository.tables());
        Table table1 = tables.getTableByNumber(1);
        assertThat(table1).isEqualTo(new Table(1));

        Table table2 = tables.getTableByNumber(2);
        assertThat(table2).isEqualTo(new Table(2));
    }
}
