package gameComponents;

/**
 * This class models an exception that occurs when the user tries to 
 * @author lucia
 *
 */
public class NumberAlreadyAssignedException extends IllegalArgumentException{
	public NumberAlreadyAssignedException() {
		
	}
	
	public NumberAlreadyAssignedException(String message) {
		super(message);
	}
}
