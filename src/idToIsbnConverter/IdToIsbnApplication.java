package idToIsbnConverter;

import java.util.Scanner;

/**
 * An application that allows users to convert a product Id into an ISBN code
 * @author Avergrove
 */
public class IdToIsbnApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double input = scanner.nextDouble();
		
		System.out.println(String.format("%.0f", IdToIsbnConverter.convertToIsbn(input)));

		scanner.close();
	}

}
