package domaintest;

import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableRepositoryTest {

    @DisplayName("전체 테이블 길이 확인")
    @Test
    void tableSizeTest() {
        int tableSize = TableRepository.tables().size();
        assertThat(tableSize).isEqualTo(6);
    }
}