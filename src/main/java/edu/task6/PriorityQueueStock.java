package edu.task6;

import java.util.PriorityQueue;

public class PriorityQueueStock implements StockMarket {
    private static final String EXCEPTION_MESSAGE = "Stock is null";
    private final PriorityQueue<Stock> stockPriorityQueue = new PriorityQueue<>(new StockComparator());

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        stockPriorityQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        stockPriorityQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockPriorityQueue.peek();
    }

    public PriorityQueue<Stock> getStockQueue() {
        return stockPriorityQueue;
    }
}
