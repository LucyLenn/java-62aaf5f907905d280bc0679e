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
    private ClientSession clientSession;

    public FileUploader(ClientSession clientSession) {
        this.clientSession = clientSession;
    }

    @SneakyThrows
    public void uploadFile(String messageIn) {
        String messageForClient;
        String[] parameters = messageIn.split("-file\\s+");

        if (parameters.length != 2) {
            messageForClient = "Error in the number of parameters";
            log.error(messageForClient);
            clientSession.sendMessage(messageForClient);
            return;
        }

        String path = parameters[1];

        File srcFile = new File(path);
        File destDir = new File(PATH_DESTINATION);

        if (srcFile.exists()) {
            try {
                FileUtils.copyFileToDirectory(srcFile, destDir);
            } catch (IOException e) {
                messageForClient = String.format("Error in coping file, from: %s, to: %s", path, PATH_DESTINATION);
                log.error(messageForClient, e);
                clientSession.sendMessage(messageForClient);
                return;
            }
        } else {
            messageForClient = String.format("The file is not exist: %s", path);
            log.info(messageForClient);
            clientSession.sendMessage(messageForClient);
            return;
        }

        messageForClient = String.format("File copied successfully, from: %s, to: %s", path, PATH_DESTINATION);
        clientSession.sendMessage(messageForClient);
    }
}
