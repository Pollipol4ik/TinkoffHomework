package edu.receiver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathReceiverSelector extends Selector {

    @Override
    public Receiver selectRetriever(String path) {
//        try {
//            Path logPath = Paths.get(path);
//            return new PathReceiver(logPath.toString());
//        } catch (Exception e) {
//            return checkNext(path);
//        }
        try {
            Paths.get(path);
            return new PathReceiver(path);
        } catch (Exception e) {
            return checkNext(path);
        }
    }
}

