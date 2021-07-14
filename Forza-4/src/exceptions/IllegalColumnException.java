package exceptions;

/**
 * This class models an exception that occurs when the user tries to put the disc into a column which index is smaller then 0 or greater than 7
 * @author lucia
 *
 */
public class IllegalColumnException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public IllegalColumnException() {
		
	}	
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public IllegalColumnException(String message) {
		super(message);
	}
}
