package edu;

import edu.task2.Rectangle;
import edu.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTask22 {
    static Arguments[] rectangles_test() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles_test")
    @DisplayName("Оба значения заданы и корректны")
    void rectangleArea_test(Rectangle rect) {
        rect.setHeight(20);
        rect.setWidth(10);
        assertThat(rect.area()).isEqualTo(200.0);
    }

    static Arguments[] square_test() {
        return new Arguments[] {
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("square_test")
    @DisplayName("Значение заданы и корректны")
    void squareArea_test(Square square) {
        square.setSide(20);

        assertThat(square.area()).isEqualTo(400.0);
    }
    static Arguments[] square_test1() {
        return new Arguments[] {
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("square_test1")
    @DisplayName("Сторона квадрата = 0")
    void squareArea_test1(Square square) {
        square.setSide(0);

        assertThat(square.area()).isEqualTo(0.0);
    }

    static Arguments[] rectangles_test1() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles_test1")
    @DisplayName("Оба значения заданы, ширина = 0")
    void rectangleArea_test1(Rectangle rect) {
        rect.setHeight(10);
        rect.setWidth(0);
        assertThat(rect.area()).isEqualTo(0.0);
    }

    static Arguments[] rectangles_test2() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles_test2")
    @DisplayName("Оба значения заданы, высота = 0")
    void rectangleArea_test2(Rectangle rect) {
        rect.setHeight(0);
        rect.setWidth(10);
        assertThat(rect.area()).isEqualTo(0.0);
    }

    @Test
    void testNegativeWidthRectangle() {
        Rectangle rectangle = new Rectangle();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rectangle.setWidth(-1);
        });
        assertEquals("Width cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeHeightRectangle() {
        Rectangle rectangle = new Rectangle();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rectangle.setHeight(-1);
        });
        assertEquals("Height cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeWidthSquare() {
        Square square = new Square();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            square.setWidth(-1);
        });
        assertEquals("Width cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeHeightSquare() {
        Square square = new Square();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            square.setHeight(-1);
        });
        assertEquals("Height cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeSideSquare() {
        Square square = new Square();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            square.setSide(-1);
        });
        assertEquals("Side cannot be negative", exception.getMessage());
    }
}

