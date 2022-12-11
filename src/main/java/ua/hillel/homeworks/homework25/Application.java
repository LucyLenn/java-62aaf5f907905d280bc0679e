package ua.hillel.homeworks.homework25;

import java.io.File;
import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {

        FileStorage fileStorage = new FileStorage();
        fileStorage.add(Path.of("src", "main", "resources", "files", "file1.txt"));
        fileStorage.add(Path.of("src", "main", "resources", "files", "file2.txt"));
        fileStorage.add(Path.of("src", "main", "resources", "files", "file3.txt"));

        FileStorageReader fileStorageReader = new FileStorageReader();

        for (Path pathFile : fileStorage.getListFiles()) {
            File file = pathFile.toFile();

            if (file.exists()) {
                try {
                    fileStorageReader.read(file, 5, 0L);
                } catch (ResumeReadFileException e) {
                    Resume resume = fileStorageReader.getResume();
                    if (resume != null) {
                        fileStorageReader.read(resume.lastReadFile(), resume.chunkSize(), resume.lastReadPositionInFile());
                    }
                }
            }
        }
    }
}
