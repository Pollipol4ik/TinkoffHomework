package edu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSFSolver extends SolverAbstract {
    public BSFSolver(Maze maze) {
        super(maze);
    }

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        validateCoordinates(start, end);
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate[][] parent = new Coordinate[maze.getHeight()][maze.getWidth()];
        queue.add(start);
        visited[start.column()][start.row()] = true;
        parent[start.column()][start.row()] = start;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            List<Coordinate> neighbours = getNeighbours(current);
            for (Coordinate neighbour : neighbours) {
                if (!visited[neighbour.column()][neighbour.row()]) {
                    queue.offer(neighbour);
                    visited[neighbour.column()][neighbour.row()] = true;
                    parent[neighbour.column()][neighbour.row()] = new Coordinate(current.row(), current.column());
                }
            }
        }

        if (!visited[end.column()][end.row()]) {
            return Collections.emptyList();
        }

        path.add(end);
        Coordinate currenr = parent[end.column()][end.row()];
        while (!currenr.equals(start)) {
            path.add(currenr);
            currenr = parent[currenr.column()][currenr.row()];
        }
        path.add(start);
        return path;
    }

    private void validateCoordinates(Coordinate start, Coordinate end) {
        if (!isValidCoordinate(start) || !isValidCoordinate(end)) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
    }
}
