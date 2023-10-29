package edu.task2;

import java.util.ArrayList;
import java.util.List;

public class ClusterizeString {
    private ClusterizeString() {
    }

    public static List<String> clusterize(String input) {

        List<String> clusters = new ArrayList<>();
        int balance = 0;
        int balance2 = 0;
        int balance3 = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                balance++;
                currentCluster.append(c);
            } else if (c == ')' && balance > 0) {
                balance--;
                currentCluster.append(c);

            } else if (c == '[') {
                balance2++;
                currentCluster.append(c);
            } else if (c == ']' && balance2 > 0) {
                balance2--;
                currentCluster.append(c);

            } else if (c == '{') {
                balance3++;
                currentCluster.append(c);
            } else if (c == '}' && balance3 > 0) {
                balance3--;
                currentCluster.append(c);

            }
            if (balance == 0 && balance2 == 0 && balance3 == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }
        if (!currentCluster.isEmpty()) {
            throw new IllegalArgumentException("It is not possible to completely cluster a row");
        }

        return clusters;
    }
}
