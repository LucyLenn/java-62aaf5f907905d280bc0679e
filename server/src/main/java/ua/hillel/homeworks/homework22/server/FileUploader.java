package ua.hillel.homeworks.homework22.server;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;


public class FileUploader {

    private static final Logger log = LogManager.getLogger(FileUploader.class);
    private static final String PATH_DESTINATION = "server/src/main/resources/";

    @SneakyThrows
    public void uploadFile(String messageIn) {
        String[] parameters = messageIn.split("-file\\s+");

        if (parameters.length != 2) {
            log.error("Error in the number of parameters");
            return;
        }

        String path = parameters[1];

        File srcFile = new File(path);
        File destDir = new File(PATH_DESTINATION);

        if (srcFile.exists()) {
            try {
                FileUtils.copyFileToDirectory(srcFile, destDir);
            } catch (IOException e) {
                log.error("Error in coping file, from: {}, to: {}", path, PATH_DESTINATION, e);
                return;
            }
        } else {
            log.info("The file is not exist: {}", path);
            return;
        }

        log.info("File copied successfully, from: {}, to: {}", path, PATH_DESTINATION);
    }
}
