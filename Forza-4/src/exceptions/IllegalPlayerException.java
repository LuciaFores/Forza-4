package exceptions;

/**
 * This class models an exception that occurs when a player that isn't the first one tries to decide the color in the game
 * @author lucia
 *
 */
public class IllegalPlayerException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public IllegalPlayerException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public IllegalPlayerException(String message) {
		super(message);
	}
}
