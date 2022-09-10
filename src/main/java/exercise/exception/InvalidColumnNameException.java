package exercise.exception;

public class InvalidColumnNameException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2771939467243913060L;

	public InvalidColumnNameException(String message) {
        super(message);
    }
}
