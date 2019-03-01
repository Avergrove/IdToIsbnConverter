package idToIsbnConverter;

import java.util.Scanner;

/**
 * An application that allows users to convert a product Id into an ISBN code
 * @author Avergrove
 */
public class IdToIsbnApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		String isbnCode = IdToIsbnConverter.convertToIsbn(input);
		System.out.println(isbnCode);

		scanner.close();
	}

}
