package edu.formatter;

import edu.model.Components;
import java.util.List;


public abstract class StatusFormatter {
    protected static final String SEPARATOR = "\\|";

    public abstract String format(Components formatterComponent);

    protected abstract String formatHeader(String header);

    protected abstract String formatTableHeaders(List<String> tableHeaders, int[] columnMaxWidth);

    protected abstract String formatTableRows(List<String> tableRows, int[] columnMaxWidth);

    protected void calculateColumnMaxWidth(int[] columnMaxWidth, Components formatterComponent) {
        for (String line : formatterComponent.lines()) {
            String[] separatedLine = line.split(SEPARATOR);
            for (int i = 0; i < separatedLine.length; i++) {
                columnMaxWidth[i] = Math.max(columnMaxWidth[i], separatedLine[i].length());
            }
        }
        for (int i = 0; i < formatterComponent.tableHeaders().size(); i++) {
            columnMaxWidth[i] = Math.max(columnMaxWidth[i], formatterComponent.tableHeaders().get(i).length());
        }
    }
}

