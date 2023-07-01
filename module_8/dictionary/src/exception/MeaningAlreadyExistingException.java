package exception;

public class MeaningAlreadyExistingException extends IllegalArgumentException{
    public MeaningAlreadyExistingException(String message) {
        super(message);
    }
}
