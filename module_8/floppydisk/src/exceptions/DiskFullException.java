package exceptions;

public class DiskFullException extends IndexOutOfBoundsException {
    public DiskFullException(String message) {
        super(message);
    }
}
