package idToIsbnConverter;

import java.util.Scanner;

/**
 * An application that allows users to convert a product Id into an ISBN code
 * 
 * @author Avergrove
 */
public class IdToIsbnApplication {

	public static void main(String[] args) {

		System.out.println("Please enter a Product Id to convert to ISBN-10 format: ");
		String productId = requestForProductId();
		
		String isbnCode = IdToIsbnConverter.convertToIsbn(productId);
		System.out.println(String.format("\nThe generated ISBN-10 id is: %s", isbnCode));
	}

	private static String requestForProductId() {
		
		boolean isInputValidated = false;

		String input = "";
		Scanner scanner = new Scanner(System.in);
		
		while (!isInputValidated) {
			input = scanner.next();
			
			if(validateInputIsProductId(input)) {
				break;
			}
			
			else {
				System.out.println("Product Id must contain only 10 digits.");
			}
		}
		
		scanner.close();
		
		return input;
	}
	
	/**
	 * Validates input, ensuring that it is a valid product id.
	 * 
	 * @param input The input to check.
	 * @return True if input contains only digits, and 12 numbers.
	 */
	private static boolean validateInputIsProductId(String input) {
		String pattern = "^[0-9]{12}$";
		return input.matches(pattern);
	}

}
