package edu.parser.logparser;


import edu.parser.pathparser.PathParser;
import edu.receiver.HttpLogReceiver;
import edu.receiver.PathLogReceiver;
import edu.receiver.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static edu.TestUtils.logsForTests;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NginxLogParserTest {
    @Test
    @DisplayName("Nginx log format test")
    public void parseLogs_shouldReturnListOfAllParsedLogs() {
        Receiver receiver = new PathLogReceiver(PathParser.getPaths("src/main/resources/log1.txt"));
        LogParser logParser = new NginxLogParser();
        assertThat(logParser.parseLogs(receiver.receive())).containsAll(logsForTests);
    }

    @Test
    @DisplayName("Not nginx log format test")
    public void parseLogs_shouldThrowException_whenDoesntMatchNginxLogFormat() {
        Receiver receiver = new HttpLogReceiver("https://hacker-news.firebaseio.com/v0/topstories.json");
        LogParser logParser = new NginxLogParser();
        assertThatThrownBy(() -> logParser.parseLogs(receiver.receive())).isInstanceOf(IllegalStateException.class);
    }
}
