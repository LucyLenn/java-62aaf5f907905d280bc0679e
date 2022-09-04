package ua.hillel.homeworks.homework9;

import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
        FileNavigator filesTable = new FileNavigator();

        Path path1 = Path.of("/path/folder1");
        Path path2 = Path.of("/path/folder2");
        Path path3 = Path.of("/path/folder3");

        FileData file1 = new FileData("1", 16, path1);
        FileData file2 = new FileData("2", 12, path2);
        FileData file3 = new FileData("3", 17, path3);
        FileData file4 = new FileData("4", 15, path3);

        filesTable.add(path1, file1);
        filesTable.add(path2, file2);
        filesTable.add(path3, file3);
        filesTable.add(path3, file4);

        System.out.println("List of files in folders:");
        filesTable.getFilesTable().forEach((k, v) -> System.out.println("Path = " + k + "; Files = " + v));

        System.out.println(filesTable.find(path3));
        System.out.println(filesTable.filterBySize(15));
        filesTable.remove(path3);
        System.out.println(filesTable.sortBySize());
    }
}
