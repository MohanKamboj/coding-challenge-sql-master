package exercise.exception;

public class InvalidParameterException extends Exception {

    private static final long serialVersionUID = -4160483257065297885L;

	public InvalidParameterException(String message) {
        super(message);
    }
}
