package ua.hillel.homeworks.homework10;

public class ArraySizeException extends RuntimeException {
    public ArraySizeException(String message) {
        super(message);
    }

    public ArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "Invalid size array. " + super.getMessage();
    }
}
