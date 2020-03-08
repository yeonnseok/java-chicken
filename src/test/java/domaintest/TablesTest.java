package domaintest;

import domain.Table;
import domain.TableRepository;
import domain.Tables;
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
}
