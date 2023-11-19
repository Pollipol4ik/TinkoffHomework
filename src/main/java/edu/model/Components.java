package edu.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Components(String header, List<String> tableHeaders, List<String> lines) {

}
