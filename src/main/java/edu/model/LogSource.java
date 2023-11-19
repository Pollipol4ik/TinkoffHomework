package edu.model;

import java.util.List;

public record LogSource(LogData logData, List<NginxLog> logs) {

}
