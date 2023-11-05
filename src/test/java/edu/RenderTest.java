package edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RenderTest {
    private final Renderer renderer = new ConsoleRenderer();

    @Test
    @DisplayName("#render test")
    public void renderGivenMaze() {
        Cell[][] grid = Utils.createGrid(7, 7, Cell.Type.PASSAGE);
        Utils.addBorderWalls(grid);
        Maze testMaze = new Maze(7, 7, grid);
        assertThat(renderer.render(testMaze)).isEqualTo("""
            ⬜⬜⬜⬜⬜⬜⬜
            ⬜⬛⬛⬛⬛⬛⬜
            ⬜⬛⬛⬛⬛⬛⬜
            ⬜⬛⬛⬛⬛⬛⬜
            ⬜⬛⬛⬛⬛⬛⬜
            ⬜⬛⬛⬛⬛⬛⬜
            ⬜⬜⬜⬜⬜⬜⬜
            """);
    }

    @Test
    @DisplayName("#renderPath test")
    public void renderPathGivenMazeWithPath() {
        Cell[][] grid = Utils.createGrid(7, 7, Cell.Type.PASSAGE);
        Utils.addBorderWalls(grid);
        Maze testMaze = new Maze(7, 7, grid);
        List<Coordinate> testPath = new ArrayList<>() {{
            add(new Coordinate(1, 1));
            add(new Coordinate(1, 2));
            add(new Coordinate(2, 2));
            add(new Coordinate(3, 2));
            add(new Coordinate(4, 2));
            add(new Coordinate(4, 3));
            add(new Coordinate(5, 3));
            add(new Coordinate(5, 4));
            add(new Coordinate(5, 5));

        }};

        assertThat(renderer.renderPath(testMaze, testPath)).isEqualTo("""
            ⬜⬜⬜⬜⬜⬜⬜
            ⬜🐛🐛⬛⬛⬛⬜
            ⬜⬛🐛⬛⬛⬛⬜
            ⬜⬛🐛⬛⬛⬛⬜
            ⬜⬛🐛🐛⬛⬛⬜
            ⬜⬛⬛🐛🐛🐛⬜
            ⬜⬜⬜⬜⬜⬜⬜
            """);
    }
}
