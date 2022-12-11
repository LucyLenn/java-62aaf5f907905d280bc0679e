import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.hillel.homeworks.homework25.FileStorage;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class FileStorageTest {

    Path pathFile = Path.of("src", "main", "resources", "files", "file1.txt");

    @Test
    void shouldReturnTheList_withTheAddedPaths() {
        List<Path> listFilesExpected = new ArrayList<>();
        listFilesExpected.add(pathFile);

        FileStorage fileStorage = new FileStorage();
        fileStorage.add(pathFile);
        List<Path> listFilesActual = fileStorage.getListFiles();

        Assertions.assertEquals(listFilesExpected, listFilesActual);
    }
}
