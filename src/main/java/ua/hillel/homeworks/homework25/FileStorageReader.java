package ua.hillel.homeworks.homework25;

import lombok.SneakyThrows;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileStorageReader implements StorageReader {
    @Override
    @SneakyThrows
    public byte[] read(File file) {
        return Files.readAllBytes(file.toPath());
    }

    @Override
    @SneakyThrows
    public List<byte[]> read(File file, int chunkSize) {

        List<byte[]> listArrayBytes = new ArrayList<>();

        try (RandomAccessFile reader = new RandomAccessFile(file, "r");
             FileChannel inChannel = reader.getChannel()) {

            return getListArrayBytes(listArrayBytes, inChannel, chunkSize);
        }
    }

    @Override
    @SneakyThrows
    public List<byte[]> read(File file, Resume resume) {

        List<byte[]> listArrayBytes = new ArrayList<>();

        try (RandomAccessFile reader = new RandomAccessFile(file, "r");
             FileChannel inChannel = reader.getChannel()) {

            reader.seek(resume.lastReadPositionInFile());
            int chunkSize = resume.chunkSize();

            return getListArrayBytes(listArrayBytes, inChannel, chunkSize);
        }
    }

    @SneakyThrows
    private List<byte[]> getListArrayBytes(List<byte[]> listArrayBytes, FileChannel inChannel, int chunkSize) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(chunkSize);

        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();

            if (byteBuffer.hasRemaining()) {
                byte[] arrayBytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(arrayBytes);
                listArrayBytes.add(arrayBytes);
            }
            byteBuffer.clear();
        }
        return listArrayBytes;
    }
}
