package application;

import java.util.Scanner;

import isbnConverter.Isbn10Converter;
import isbnConverter.IsbnConverter;
import validator.Isbn10Validator;
import validator.Validator;

/**
 * An application that allows users to convert a product Id into an ISBN code
 * 
 * @author Avergrove
 */
public class IdToIsbnApplication {

	public static void main(String[] args) {

		System.out.println("Please enter a Product Id to convert to ISBN-10 format:");
		String productId = requestForProductId();
		
		String isbnCode = convertToIsbn(productId, new Isbn10Converter());
		System.out.println(String.format("\nThe generated ISBN-10 id is:\n%s", isbnCode));
	}

	
	/**
	 * Requests the user to provide a valid product id.
	 * @return A product id provided by the user.
	 */
	private static String requestForProductId() {
		
		boolean isInputValidated = false;

		String input = "";
		Scanner scanner = new Scanner(System.in);
		
		Validator validator = new Isbn10Validator();
		
		while (!isInputValidated) {
			input = scanner.next();
			
			if(validator.validate(input)) {
				break;
			}
			
			else {
				System.out.println("Product Id must contain 12 digits.");
			}
		}
		
		scanner.close();
		
		return input;
	}
	
	/**
	 * Converts a provided productId into an ISBN code.
	 * @param productId The id to convert into an ISBN code.
	 * @param converter Converter variant to use to output ISBN code types.
	 * @return An ISBN code corresponding to the ISBN Converter used.
	 */
	private static String convertToIsbn(String productId, IsbnConverter converter) {
		String isbnCode = converter.convertToIsbn(productId);
		return isbnCode;
	}
}
