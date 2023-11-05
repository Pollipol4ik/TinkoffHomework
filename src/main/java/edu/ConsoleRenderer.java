package edu;

import java.util.List;

public class ConsoleRenderer implements Renderer {
    private static final char PASSAGE_SYMBOL = '⬛';
    private static final char WALL_SYMBOL = '⬜';
    private static final String PATH_SYMBOL = "\uD83D\uDC1B";

    @Override
    public String render(Maze maze) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getGrid()[row][col];
                sb.append(cell.getType() == Cell.Type.WALL ? WALL_SYMBOL : PASSAGE_SYMBOL);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String renderPath(Maze maze, List<Coordinate> path) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Coordinate current = new Coordinate(row, col);
                if (path.contains(current)) {
                    sb.append(PATH_SYMBOL);
                    continue;
                }
                Cell cell = maze.getGrid()[row][col];
                if (cell.getType() == Cell.Type.PASSAGE) {
                    sb.append(PASSAGE_SYMBOL);
                } else {
                    sb.append(WALL_SYMBOL);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
