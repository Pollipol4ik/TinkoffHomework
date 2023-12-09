package edu.parser.logparser;

import edu.model.Log;
import java.util.List;

public interface LogParser {
    List<Log> parseLogs(List<String> logInfo);
}
