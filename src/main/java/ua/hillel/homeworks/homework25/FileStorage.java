package ua.hillel.homeworks.homework25;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private final List<Path> listFiles = new ArrayList<>();

    public List<Path> getListFiles() {
        return listFiles;
    }

    public void add(Path path) {
        listFiles.add(path);
    }
}
