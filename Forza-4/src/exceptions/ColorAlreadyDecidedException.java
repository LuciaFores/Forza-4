package exceptions;

/**
 * This class models an exception that occurs when the user tries to change the colors that have been already decided
 * @author lucia
 *
 */
public class ColorAlreadyDecidedException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public ColorAlreadyDecidedException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public ColorAlreadyDecidedException(String message) {
		super(message);
	}
}
