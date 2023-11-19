package edu;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import edu.receiver.UrlReceiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UrlReceiverTest {

    @Test
    @DisplayName("#retrieveLogs test")
    public void retrieveLogs_shouldReturnListWhichContainsAllLinesOfRemoteSourceFile() {
        List<String> lines = new UrlReceiver(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs").receive();
        assertThat(lines).hasSize(51462);
    }
}
