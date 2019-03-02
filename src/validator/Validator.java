package validator;

/**
 * An interface that defines a validator
 * @author Averg
 *
 */
public interface Validator {
	/**
	 * Performs validation on a string input
	 * @param input The input to validate
	 * @return true if input passes validation, false otherwise.
	 */
	boolean validate(String input);
}
