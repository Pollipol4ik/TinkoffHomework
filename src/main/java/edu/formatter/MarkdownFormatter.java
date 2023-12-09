package edu.formatter;

import edu.model.metrics.Metric;

public class MarkdownFormatter extends StatusFormatter {

    @Override
    public String print(Metric metric) {
        StringBuilder metricSb = new StringBuilder();
        appendHeader(metricSb, "#### ", metric.header());
        int[] maxSpaces = getMaxSpacesForEachColumn(metric.table());

        makeRow(metric.table().get(0), maxSpaces, metricSb);

        for (int maxSpace : maxSpaces) {
            metricSb.append(SPLITTER).append(":").append("-".repeat(Math.max(0, maxSpace - 2))).append(":");
        }

        metricSb.append(SPLITTER).append('\n');

        for (int i = 1; i < metric.table().size(); i++) {
            makeRow(metric.table().get(i), maxSpaces, metricSb);
        }

        return metricSb.toString();
    }

    private void makeRow(String row, int[] maxSpaces, StringBuilder metricSb) {
        String[] rowData = row.split(REGEX_SPLITTER);

        for (int i = 0; i < rowData.length; i++) {
            metricSb.append(SPLITTER).append(" ".repeat(Math.max(0, maxSpaces[i] - rowData[i].length())))
                .append(rowData[i]);
        }

        metricSb.append(SPLITTER).append('\n');
    }
}
