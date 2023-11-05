package edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class BFSSolverTest {
    private final Solver solver = new BSFSolver(maze);
    private static Maze maze;

    @BeforeAll
    static void initMaze() {
        Cell[][] grid = Utils.createGrid(5, 5, Cell.Type.PASSAGE);
        Utils.addBorderWalls(grid);
        maze = new Maze(5, 5, grid);
    }

    @Test
    @DisplayName("BFSSolver test")
    public void solveFindCorrectPath() {
        List<Coordinate> actual = solver.solve(maze, new Coordinate(1, 1), new Coordinate(3, 3));
        Collections.reverse(actual);
        assertThat(actual).containsExactly(new Coordinate(1, 1), new Coordinate(2, 1),
            new Coordinate(3, 1), new Coordinate(3, 2), new Coordinate(3, 3)
        );
    }

    @Test
    @DisplayName("BFSSolver test with incorrect input")
    public void solveWhenInputIsIncorrect() {
        assertThatThrownBy(() -> solver.solve(maze, new Coordinate(-2, 0), new Coordinate(10, 10))).isInstanceOf(
            IllegalArgumentException.class);
    }

}
