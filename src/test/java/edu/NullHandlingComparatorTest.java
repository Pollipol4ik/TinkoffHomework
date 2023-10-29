package edu;

import java.util.Map;
import java.util.TreeMap;
import edu.task7.NullHandlingComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import static org.assertj.core.api.Assertions.assertThat;

public class NullHandlingComparatorTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("Тест корректной работы с ключом null")
    public void nullableKey_shouldBeInTreeMap(String nullKey) {
        Map<String, String> treeMap = new TreeMap<>(new NullHandlingComparator());
        treeMap.put(nullKey, "test");
        assertThat(treeMap.containsKey(null)).isTrue();
    }
}
