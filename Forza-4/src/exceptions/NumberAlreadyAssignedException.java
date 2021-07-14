package exceptions;

/**
 * This class models an exception that occurs when the user tries to reassign the order in which the players will play after that it has been
 * already assigned
 * @author lucia
 *
 */
public class NumberAlreadyAssignedException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public NumberAlreadyAssignedException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public NumberAlreadyAssignedException(String message) {
		super(message);
	}
}
