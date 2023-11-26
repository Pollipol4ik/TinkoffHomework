package edu.task5;

import java.util.Comparator;

public class ComparatorAsc implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String compareFirst = o1.surname().isEmpty() ? o1.name() : o1.surname();
        String compareSecond = o2.surname().isEmpty() ? o2.name() : o2.surname();
        return compareFirst.compareTo(compareSecond);
    }
}
