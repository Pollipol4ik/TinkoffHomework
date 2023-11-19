package edu.receiver.path;

import edu.receiver.PathLogReceiver;
import edu.receiver.Receiver;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.parser.pathparser.PathParser.getPaths;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PathLogReceiverTest {
    private final Path wrongPath = Path.of("src/main/resources/log55.txt");

    @Test
    @DisplayName("Path receive logs test")
    public void receive_shouldReturnListOfStringsFromPathsToFiles() {
        Receiver receiver = new PathLogReceiver(getPaths("src/main/resources/log2.txt"));
        assertThat(receiver.receive().size()).isEqualTo(82);
    }

    @Test
    @DisplayName("Path receive logs with wrong path test")
    public void receive_shouldThrowException_whenPathIsWrong() {
        Receiver receiver = new PathLogReceiver(List.of(wrongPath));
        assertThatThrownBy(receiver::receive).isInstanceOf(RuntimeException.class);
    }
}
