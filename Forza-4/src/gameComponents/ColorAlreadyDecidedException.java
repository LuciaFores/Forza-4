package gameComponents;

/**
 * This class models an exception that occurs when the user tries to change the colors that have been already decided
 * @author lucia
 *
 */
public class ColorAlreadyDecidedException extends IllegalArgumentException{
	public ColorAlreadyDecidedException() {
		
	}
	
	public ColorAlreadyDecidedException(String message) {
		super(message);
	}
}
