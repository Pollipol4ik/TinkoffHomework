package edu.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionary {
    public static <T> Map<T, Integer> freqDict(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items null");
        }
        if (items.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    private FrequencyDictionary() {

    }
}
