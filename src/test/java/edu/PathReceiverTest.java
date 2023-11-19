package edu;

import java.util.List;
import edu.receiver.PathReceiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PathReceiverTest {

    @Test
    @DisplayName("#retrieveLogs test")
    public void retrieveLogs_shouldReturnListWhichContainsAllLinesOfLogFile() {
        List<String> lines = new PathReceiver("logFirst.txt").receive();
        assertThat(lines).hasSize(59);
    }
}
