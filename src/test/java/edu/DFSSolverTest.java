package edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;

public class DFSSolverTest {
    private Maze maze;

    @BeforeEach
    void setUp() {
        Cell[][] grid = Utils.createGrid(5, 5, Cell.Type.PASSAGE);
        Utils.addBorderWalls(grid);
        grid[1][2].setType(Cell.Type.WALL);
        grid[2][2].setType(Cell.Type.WALL);
        maze = new Maze(5, 5, grid);
    }

    @Test
    @DisplayName("DFSSolver test")
    void dfsSolverCorrectPath() {
        Solver dfsSolver = new DepthFirstSolver(maze);
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(3, 2);
        assertThat(dfsSolver.solve(maze, start, end)).containsExactly(
            new Coordinate(1, 1),
            new Coordinate(2, 1),
            new Coordinate(3, 1),
            new Coordinate(3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("wrongCoordinates")
    @DisplayName("DFSSolver test with incorrect input")
    void dfsSolverIncorrectValueStartOrEnd(Coordinate start, Coordinate end) {
        Solver dfsSolver = new DepthFirstSolver(maze);
        assertThatThrownBy(() -> dfsSolver.solve(maze, start, end)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> wrongCoordinates() {
        return Stream.of(
            Arguments.of(new Coordinate(1, 2), new Coordinate(6, 3)),
            Arguments.of(new Coordinate(0, 0), new Coordinate(3, 3)),
            Arguments.of(new Coordinate(1, 1), new Coordinate(0, 3))
        );
    }
}
