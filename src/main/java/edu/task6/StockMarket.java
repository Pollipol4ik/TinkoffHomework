package edu.task6;

public interface StockMarket {
    void add(Stock stock);

    void remove(Stock stock);

    Stock mostValuableStock();
}
