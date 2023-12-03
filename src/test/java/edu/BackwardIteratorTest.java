package edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BackwardIteratorTest {

    @Test
    @DisplayName("Тест 1 2 3")
    public void listReturnBackwardList() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));
        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            actual.add(iterator.next());
        }
        assertThat(actual).containsExactly(3, 2, 1);
    }
}
