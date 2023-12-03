package edu;


import edu.task6.PriorityQueueStock;
import edu.task6.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockTest {
    private PriorityQueueStock priorityQueueStock;
    private final Stock stockForRemove = new Stock("Sberbank", 269.7);

    @BeforeEach public void makeStockMarket() {
        priorityQueueStock = new PriorityQueueStock();
        priorityQueueStock.add(new Stock("Ozon", 2680.3));
        priorityQueueStock.add(new Stock("Gazprom", 167.3));
    }

    @Test
    @DisplayName("Тест метода add")
    public void stockAddStock() {
        Stock stock = new Stock("Yandex", 3000);
        priorityQueueStock.add(stock);
        assertTrue(priorityQueueStock.getStockQueue().contains(stock));
    }

    @Test
    @DisplayName("Тест метода remove")
    public void stockRemoveStock() {
        priorityQueueStock.remove(stockForRemove);
        assertFalse(priorityQueueStock.getStockQueue().contains(stockForRemove));
    }

    @Test
    @DisplayName("Тест метода mostValuableStock")
    public void stockReturnFirstStock() {
        Stock stock = new Stock("Yandex", 3000);
        priorityQueueStock.add(stock);
        assertThat(priorityQueueStock.mostValuableStock()).isEqualTo(stock);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Тест null")
    public void stockEmptyOrNull(Stock stock) {
        assertAll(
            () -> assertThatThrownBy(() -> priorityQueueStock.add(stock)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> priorityQueueStock.remove(stock)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
