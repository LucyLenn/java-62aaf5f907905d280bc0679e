package ua.hillel.homeworks.homework9;

import java.nio.file.Path;
import java.util.*;

public class FileNavigator {
    private final Map<Path, List<FileData>> filesTable = new HashMap<>();

    public Map<Path, List<FileData>> getFilesTable() {
        return filesTable;
    }

    public void add(Path path, FileData file) {
        checkPathsMatch(path, file);
        List<FileData> filesList = filesTable.getOrDefault(path, new ArrayList<>());
        filesList.add(file);
        filesTable.put(path, filesList);
    }

    private void checkPathsMatch(Path path, FileData file) throws IllegalArgumentException {
        if (!file.getPath().equals(path)) {
            throw new IllegalArgumentException(String.format("Key-Path and FileData-Path don't match. Key-Path: '%s'; FileDate-Path: '%s'.", path, file.getPath()));
        }
    }

    public List<FileData> find(Path path) {
        return filesTable.getOrDefault(path, Collections.emptyList());
    }

    public List<FileData> filterBySize(long size) {
        List<FileData> filesFilterBySize = new ArrayList<>();

        for (List<FileData> filesList : filesTable.values()) {
            for (FileData files : filesList) {
                if (files.getSize() <= size) {
                    filesFilterBySize.add(files);
                }
            }
        }
        return filesFilterBySize;
    }

    public List<FileData> filterBySizeTwo(long size) {
        List<FileData> filesFilterBySize = new ArrayList<>();

        for (List<FileData> filesList : filesTable.values()) {
            filesFilterBySize.addAll(filesList);
        }
        filesFilterBySize.removeIf(f -> f.getSize() > size);
        return filesFilterBySize;
    }

    public void remove(Path path) {
        filesTable.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> filesSortBySize = new ArrayList<>();

        for (List<FileData> filesList : filesTable.values()) {
            filesSortBySize.addAll(filesList);
        }
        Collections.sort(filesSortBySize, (f1, f2) -> (int) (f1.getSize() - f2.getSize()));
        return filesSortBySize;
    }
}
