package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestTask8 {
    @Test
    @DisplayName("Кони не могут побить друг друга")
    public void knightBoardCaptureDonotBeatEachOther() {
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        assertThat(Task8.isSafe(board)).isTrue();
    }

    @Test
    @DisplayName("Кони могут побить друг друга")
    public void knightBoardCapture_shouldReturnTrue_whenKnightsCanBeatEachOther() {
        int[][] board = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assertThat(Task8.isSafe(board)).isFalse();
    }

    @Test
    @DisplayName("Ввод null")
    public void knightBoardCapture_shouldThrowException_whenNullInput() {
        int[][] board = null;
        assertThatThrownBy(() -> Task8.isSafe(board)).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("height != 8")
    public void knightBoardCapture_shouldThrowException_whenBoardLengthNotEqualEight() {
        int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        assertThatThrownBy(() -> Task8.isSafe(board)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("weight != 8")
    public void knightBoardCapture_shouldThrowException_whenBoardWidthNotEqualEight() {
        int[][] board = {
            {1, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0}
        };
        assertThatThrownBy(() -> Task8.isSafe(board)).isInstanceOf(IllegalArgumentException.class);
    }
}
