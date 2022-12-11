package ua.hillel.homeworks.homework25;

import java.io.File;
import java.util.List;

public interface StorageReader {
    byte[] read(File file);

    List<byte[]> read(File file, int chunkSize, long positionPoint);
}
