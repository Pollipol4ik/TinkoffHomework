package edu;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import static java.lang.System.out;

public class Application {
    private static final int MIN_MAZE_SIZE = 11;
    private static final int MAX_MAZE_SIZE = 41;
    private static final String ERROR_INPUT_MESSAGE = "Incorrect number of algorithm";
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    private final Scanner scanner;
    private final int height;
    private final int width;

    public Application() {
        out.println("Hello! Welcome to Maze Application!");
        scanner = new Scanner(System.in);
        width = setMazeWidth();
        height = setMazeHeight();
    }

    public void run() {
        Generator mazeGenerator = setMazeGenerator(height, width);
        Maze maze = mazeGenerator.generate(height, width);
        Renderer mazeRenderer = new ConsoleRenderer();

        out.println("Generated maze:\n" + mazeRenderer.render(maze));
        out.println("Input start of path coordinates");
        Coordinate start = setCoordinate();
        out.println("Input end of path coordinates");
        Coordinate end = setCoordinate();

        Solver mazeSolver = setMazeSolver(maze);
        List<Coordinate> path = mazeSolver.solve(maze, start, end);

        out.println("Shortest path from start to end:\n" + mazeRenderer.renderPath(maze, path));
    }

    protected Solver setMazeSolver(Maze maze) {
        out.println("Choose algorithm for finding the path in the maze: 1) BFSSolver or 2) DFSSolver");
        int choose = scanner.nextInt();
        while (choose < 1 || choose > 2) {
            LOGGER.info(ERROR_INPUT_MESSAGE);
            choose = scanner.nextInt();
        }
        if (choose == 1) {
            return new BSFSolver(maze);
        }
        return new DepthFirstSolver(maze);
    }

    private Coordinate setCoordinate() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Coordinate(x, y);
    }

    protected Generator setMazeGenerator(int height, int width) {
        out.println("The algorithm for generating the maze is selected automatically: DFSGenerator");
        return new DFSGenerator(height, width);
    }

    private int setMazeWidth() {
        out.println("Choose odd width of the maze from 11 to 41");
        int mazeWidth = scanner.nextInt();
        while (isNotValidMazeSize(mazeWidth)) {
            LOGGER.info("Incorrect width");
            mazeWidth = scanner.nextInt();
        }
        return mazeWidth;
    }

    private int setMazeHeight() {
        out.println("Choose odd height of the maze from 11 to 41");
        int mazeHeight = scanner.nextInt();
        while (isNotValidMazeSize(mazeHeight)) {
            LOGGER.info("Incorrect height");
            mazeHeight = scanner.nextInt();
        }
        return mazeHeight;
    }

    protected boolean isNotValidMazeSize(int size) {
        return size % 2 == 0 || size < MIN_MAZE_SIZE || size > MAX_MAZE_SIZE;
    }

}

