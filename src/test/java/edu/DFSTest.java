package edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class DFSTest {
    @Test
    @DisplayName("#generate test")
    public void generate_shouldReturnMazeWhichHaveSolution() {
        Maze testMaze = new DFSGenerator(11, 11).generate(11, 11);
        List<Coordinate> actual =
            new DepthFirstSolver(testMaze).solve(testMaze, new Coordinate(1, 1), new Coordinate(11, 11));
        assertThat(actual).isNotEmpty();
    }
    @Test
    @DisplayName("#generate test")
    public void generateHaveSolution() {
        Maze testMaze = new DFSGenerator(11, 11).generate(11, 11);
        List<Coordinate> actual =
            new DepthFirstSolver(testMaze).solve(testMaze, new Coordinate(1, 1), new Coordinate(9, 9));
        assertThat(actual).isNotEmpty();
    }
}
