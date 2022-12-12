package ua.hillel.homeworks.homework25;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileStorageReader implements StorageReader {
    private Resume resume;

    public Resume getResume() {
        return resume;
    }

    @Override
    @SneakyThrows
    public byte[] read(File file) {
        return Files.readAllBytes(file.toPath());
    }

    @Override
    public List<byte[]> read(File file, int chunkSize, long position) {

        List<byte[]> listArrayBytes = new ArrayList<>();
        long lastReadPositionInFile = 0L;

        try (RandomAccessFile reader = new RandomAccessFile(file, "r");
             FileChannel inChannel = reader.getChannel()) {

            reader.seek(position);
            ByteBuffer byteBuffer = ByteBuffer.allocate(chunkSize);

            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();

                if (byteBuffer.hasRemaining()) {
                    byte[] arrayBytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(arrayBytes);
                    lastReadPositionInFile = inChannel.position();
                    listArrayBytes.add(arrayBytes);
                }
                byteBuffer.clear();
            }
            return listArrayBytes;

        } catch (IOException e) {
            resume = new Resume(file, chunkSize, lastReadPositionInFile);
            throw new ResumeReadFileException("Error in reading file: " + file, e);
        }
    }
}
