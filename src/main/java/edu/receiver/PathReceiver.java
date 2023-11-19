package edu.receiver;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class PathReceiver implements Receiver {

    private static final String LOGS_DIRECTORY = "logs/";
    private final String targetPath;

    public PathReceiver(String targetPath) {
        this.targetPath = targetPath;
    }

//    private List<String> getLogsFromFile(Path path) throws IOException {
//        return Files.readAllLines(path);
//    }

//    @Override
//    public List<String> receive() {
//        List<String> logs = new ArrayList<>();
//        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + LOGS_DIRECTORY + targetPath);
//        try {
//            Files.walkFileTree(Paths.get(LOGS_DIRECTORY), Set.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
//                new SimpleFileVisitor<Path>() {
//                    @Override
//                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                        if (pathMatcher.matches(file)) {
//                            logs.addAll(getLogsFromFile(file));
//                        }
//                        return FileVisitResult.CONTINUE;
//                    }
//
//                    @Override
//                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return logs;
//    }

    @Override
    public List<String> receive() {
        List<String> logs = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(
            Paths.get(LOGS_DIRECTORY),
            Integer.MAX_VALUE,
            FileVisitOption.FOLLOW_LINKS
        )) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + LOGS_DIRECTORY + targetPath);
            pathStream
                .filter(Files::isRegularFile)
                .filter(pathMatcher::matches)
                .forEach(el -> logs.addAll(getLogsFromFile(el)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return logs;
    }

    private List<String> getLogsFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

