package exceptions;

public class WriteLockException extends Exception {
    public WriteLockException(String message) {
        super(message);
    }
}
