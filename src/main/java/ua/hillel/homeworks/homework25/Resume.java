package ua.hillel.homeworks.homework25;

import java.io.File;

public record Resume(File lastReadFile, int chunkSize, long lastReadPositionInFile) {
}
