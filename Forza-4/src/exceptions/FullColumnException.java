package exceptions;

/**
 * This class models an exception that occurs when a user tries to put a disc into an already full column
 * @author lucia
 *
 */
public class FullColumnException extends IllegalArgumentException{
	public FullColumnException() {
		
	}
	
	public FullColumnException(String message) {
		super(message);
	}
}
