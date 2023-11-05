package edu;

import java.util.Collections;
import java.util.List;

public class DepthFirstSolver extends SolverAbstract {
    public DepthFirstSolver(Maze maze) {
        super(maze);
    }

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        validateCoordinates(start, end);
        if (!dfs(start, end)) {
            return Collections.emptyList();
        }
        return path;
    }

    private boolean dfs(Coordinate start, Coordinate end) {
        visited[start.column()][start.row()] = true;
        path.add(start);
        if (start.equals(end)) {
            return true;
        }
        for (Coordinate neighbor : getNeighbours(start)) {
            if (!visited[neighbor.column()][neighbor.row()] && dfs(neighbor, end)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    private void validateCoordinates(Coordinate start, Coordinate end) {
        if (!isValidCoordinate(start) || !isValidCoordinate(end)) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
    }
}
