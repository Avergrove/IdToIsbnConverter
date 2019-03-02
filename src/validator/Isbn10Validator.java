package validator;

public class Isbn10Validator implements Validator {

	@Override
	/**
	 * Validates input, ensuring that it can be converted into an ISBN-10 id.
	 */
	public boolean validate(String input) {
		String pattern = "^[0-9]{12}$";
		return input.matches(pattern);
	}

}
