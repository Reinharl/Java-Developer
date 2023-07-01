package exception;

public class WordNotPresentException extends IllegalArgumentException {
    public WordNotPresentException(String message) {
        super(message);
    }
}
