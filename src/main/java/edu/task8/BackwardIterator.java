package edu.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> elements;
    private int currentIndex;

    public BackwardIterator(Collection<T> collection) {
        this.elements = List.copyOf(collection);
        this.currentIndex = elements.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex - 1 >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements to iterate.");
        }
        return elements.get(--currentIndex);
    }
}

