package edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DFSGenerator implements Generator {
    private Cell[][] grid;
    private boolean[][] visited;
    private final int height;
    private final int width;
    private final Random random = new Random();

    public DFSGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new Cell[height][width];
        visited = new boolean[height][width];
    }

    @Override
    public Maze generate(int height, int width) {
        grid = createGrid(height, width);
        Stack<Cell> cellStack = new Stack<>();
        Cell currentCell = grid[1][1];
        visited[1][1] = true;

        while (gridHasUnvisitedCells(visited)) {
            List<NeighbourCellDirection> neighbours =
                getUnvisitedNeighbours(currentCell.getRow(), currentCell.getColumn(), visited);

            if (!neighbours.isEmpty()) {
                cellStack.push(currentCell);
                int randomIndex = random.nextInt(neighbours.size());
                Cell randomCell = neighbours.get(randomIndex).cell();
                Direction randomDirection = neighbours.get(randomIndex).direction();

                switch (randomDirection) {
                    case UP -> grid[randomCell.getColumn() + 1][randomCell.getRow()].setType(Cell.Type.PASSAGE);
                    case DOWN -> grid[randomCell.getColumn() - 1][randomCell.getRow()].setType(Cell.Type.PASSAGE);
                    case LEFT -> grid[randomCell.getColumn()][randomCell.getRow() - 1].setType(Cell.Type.PASSAGE);
                    default -> grid[randomCell.getColumn()][randomCell.getRow() + 1].setType(Cell.Type.PASSAGE);
                }
                currentCell = randomCell;
                visited[currentCell.getColumn()][currentCell.getRow()] = true;
            } else {
                currentCell = cellStack.pop();
            }
        }

        return new Maze(height, width, grid);
    }

    private Cell[][] createGrid(int height, int width) {
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && (i < height - 1 && j < width - 1)) {
                    grid[i][j] = new Cell(j, i, Cell.Type.PASSAGE);
                } else {
                    grid[i][j] = new Cell(j, i, Cell.Type.WALL);
                    visited[i][j] = true;
                }
            }
        }
        return grid;
    }

    private boolean gridHasUnvisitedCells(boolean[][] visited) {
        for (boolean[] row : visited) {
            for (boolean cellVisited : row) {
                if (!cellVisited) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<NeighbourCellDirection> getUnvisitedNeighbours(int x, int y, boolean[][] visited) {
        List<NeighbourCellDirection> neighbours = new ArrayList<>();

        if (inBounds(x - 2, y) && !visited[y][x - 2]) {
            neighbours.add(new NeighbourCellDirection(grid[y][x - 2], Direction.RIGHT));
        }
        if (inBounds(x + 2, y) && !visited[y][x + 2]) {
            neighbours.add(new NeighbourCellDirection(grid[y][x + 2], Direction.LEFT));
        }
        if (inBounds(x, y - 2) && !visited[y - 2][x]) {
            neighbours.add(new NeighbourCellDirection(grid[y - 2][x], Direction.UP));
        }
        if (inBounds(x, y + 2) && !visited[y + 2][x]) {
            neighbours.add(new NeighbourCellDirection(grid[y + 2][x], Direction.DOWN));
        }
        return neighbours;
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private record NeighbourCellDirection(Cell cell, Direction direction) {
    }
}



