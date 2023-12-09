package edu.receiver.http;

import edu.receiver.HttpLogReceiver;
import edu.receiver.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HttpLogReceiverTest {
    private static final String HTTP =
        "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";

    @Test
    @DisplayName("HTTP receive logs test")
    public void receive_shouldReturnListOfStringsFromHttp() {
        Receiver receiver = new HttpLogReceiver(HTTP);
        assertThat(receiver.receive().size()).isEqualTo(51462);
    }
}
