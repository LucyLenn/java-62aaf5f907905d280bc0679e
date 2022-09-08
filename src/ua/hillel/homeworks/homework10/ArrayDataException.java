package ua.hillel.homeworks.homework10;

public class ArrayDataException extends RuntimeException {
    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
