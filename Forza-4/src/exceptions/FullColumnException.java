package exceptions;

/**
 * This class models an exception that occurs when a user tries to put a disc into an already full column
 * @author lucia
 *
 */
public class FullColumnException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public FullColumnException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public FullColumnException(String message) {
		super(message);
	}
}
