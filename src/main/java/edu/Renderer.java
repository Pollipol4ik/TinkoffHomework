package edu;

import java.util.List;

public interface Renderer {

    String render(Maze maze);

    String renderPath(Maze maze, List<Coordinate> path);
}