import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.hillel.homeworks.homework25.FileStorageReader;
import ua.hillel.homeworks.homework25.Resume;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

class FileStorageReaderTest {

    Path pathFile = Path.of("src", "main", "resources", "files", "file1.txt");
    FileStorageReader fileStorageReader = new FileStorageReader();

    @Test
    void givenExistentPath_whenConfirmsFileExists_thenCorrect() {
        Assertions.assertTrue(Files.exists(pathFile));
    }

    @Test
    void shouldReadExistingFile() throws UnsupportedEncodingException {
        byte[] byteArrayInFile = fileStorageReader.read(pathFile.toFile());
        String stringFromFile = new String(byteArrayInFile, "UTF-8");

        Assertions.assertEquals("text one", stringFromFile);
    }

    @ParameterizedTest
    @MethodSource("expectedArraysAndChunkSizeProvider")
    void shouldReadExistingFile_WithChunkSize_AndReturnArrayFromFirstIndexInList(
            byte[] expectedArray, int chunkSize) {

        List<byte[]> listArrayBytes = fileStorageReader.read(pathFile.toFile(), chunkSize);
        Assertions.assertArrayEquals(listArrayBytes.get(0), expectedArray);
    }

    static Stream<Arguments> expectedArraysAndChunkSizeProvider() {
        return Stream.of(
                Arguments.of("text ".getBytes(), 5),
                Arguments.of("tex".getBytes(), 3),
                Arguments.of("text on".getBytes(), 7)
        );
    }

    @ParameterizedTest
    @MethodSource("expectedArraysAndChunkSizeAndPositionProvider")
    void shouldReadExistingFile_fromResume_AndReturnArrayFromFirstIndexInList(
            byte[] expectedArray, int chunkSize, long position) {

        Resume resume = new Resume(pathFile.toFile(), chunkSize, position);

        List<byte[]> listArrayBytes = fileStorageReader.read(resume.lastReadFile(), resume);
        Assertions.assertArrayEquals(listArrayBytes.get(0), expectedArray);
    }

    static Stream<Arguments> expectedArraysAndChunkSizeAndPositionProvider() {
        return Stream.of(
                Arguments.of("ext o".getBytes(), 5, 1L),
                Arguments.of("xt ".getBytes(), 3, 2L),
                Arguments.of("t one".getBytes(), 7, 3L)
        );
    }

    @Test
    void shouldReadExistingFile_WithChunkSize_AndReturnSizeListArrayBytes() {
        List<byte[]> listArrayBytes = fileStorageReader.read(pathFile.toFile(), 3);
        Assertions.assertEquals(3, listArrayBytes.size());
    }
}
