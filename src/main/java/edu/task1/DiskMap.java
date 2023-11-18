package edu.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Path filePath;
    private int sizeOfMap = 0;
    private static final String EXCEPTION_MESSAGE = "IOException has been called";


    public DiskMap() {
        filePath = Paths.get("src/main/resources/hw6/diskMap.txt");
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            Files.createFile(filePath);
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public int size() {
      return sizeOfMap;
    }

    @Override
    public boolean isEmpty() {
        try {
            var file = Files.readAllLines(filePath);
            return file.isEmpty();
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
            return false;
        }
    }


    @Override
    public boolean containsKey(Object key) {
        try {
            List<String> allLines = Files.readAllLines(filePath);
            return allLines.stream()
                .map(line -> line.split(":"))
                .anyMatch(str -> str[0].equals(key.toString()));
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            List<String> allLines = Files.readAllLines(filePath);
            return allLines.stream()
                .map(line -> line.split(":"))
                .anyMatch(str -> str[1].equals(value.toString()));
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
            return false;
        }
    }

    @Override
    public String get(Object key) {
        try {
            var file = Files.readAllLines(filePath);
            for (String line : file) {
                if (line.startsWith(key + ":")) {
                    return line.substring(key.toString().length() + 1);
                }
            }
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return null;
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            String entry = key + ":" + value + System.lineSeparator();
            Files.writeString(filePath, entry, java.nio.file.StandardOpenOption.APPEND);
            sizeOfMap++;
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return null;
    }


    @Override
    public String remove(Object key) {
        try {
            var file = Files.readAllLines(filePath);
            Files.delete(filePath);
            for (String line : file) {
                if (!line.startsWith(key + ":")) {
                    Files.writeString(filePath, line + System.lineSeparator(), java.nio.file.StandardOpenOption.APPEND);
                }
            }
            sizeOfMap--;
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (Entry<? extends String, ? extends String> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        try {
            Files.delete(filePath);
            Files.createFile(filePath);
            sizeOfMap = 0;
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }

    }

    @NotNull
    @Override
    public Set<String> keySet() {
        Set<String> keySet = new HashSet<>();
        try {
            var file = Files.readAllLines(filePath);
            for (String line : file) {
                String key = line.split(":")[0];
                keySet.add(key);
            }
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return keySet;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        List<String> valuesList = new ArrayList<>();
        try {
            var file = Files.readAllLines(filePath);
            for (String line : file) {
                String value = line.split(":")[1];
                valuesList.add(value);
            }
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return valuesList;
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> entrySet = new HashSet<>();
        try {
            var file = Files.readAllLines(filePath);
            for (String line : file) {
                String[] keyValue = line.split(":");
                Entry<String, String> entry = new AbstractMap.SimpleEntry<>(keyValue[0], keyValue[1]);
                entrySet.add(entry);
            }
        } catch (IOException e) {
            LOGGER.info(EXCEPTION_MESSAGE);
        }
        return entrySet;
    }
}
