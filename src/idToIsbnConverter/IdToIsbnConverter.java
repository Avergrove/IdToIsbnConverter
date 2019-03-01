package idToIsbnConverter;

public class IdToIsbnConverter {
	/**
	 * Converts a product id into an ISBN code
	 * @param productId A non-negative number
	 * @return The ISBN code corresponding to the product id
	 */
	public static double convertToIsbn(double productId) {
		double isbnCode = productId;
		
		isbnCode = removeFirstNDigits(isbnCode, 3);
		isbnCode = attachIsbnChecksum(isbnCode);
		
		return isbnCode;
	}
	
	/**
	 * Removes the first n digits from an id
	 * @param id The non-zero and non-negative id to remove
	 * @param n The number of digits to remove, must be lower than number of digits in id.
	 * @return An id with the first n digits removed.
	 */
	private static double removeFirstNDigits(double id, int n) {
		
		double idDigitCount = Math.floor(Math.log10(id)) + 1;
		return id % Math.pow(10, idDigitCount - n);
	}
	
	/**
	 * Appends a checksum to the provided id
	 * @param id The non-zero and non-negative id to append a checksum to
	 * @return An id that is appended with the checksum
	 */
	private static double attachIsbnChecksum(double id) {
		return id * 10 + findIsbnChecksum(id);
	}
	
	
	/**
	 * Calculates the checksum of a product id according to ISBN standards.
	 * @param id
	 * @return The checksum of a product id
	 */
	private static double findIsbnChecksum(double id) {
		
		int checksum = 0;
		int currRadix = 2;
		
		while(id > 0) {
			double currDigit = id % 10;
			id = Math.floor(id / 10);
			checksum += currDigit * currRadix;
			
			currRadix++;
		}
		
		checksum = 11 - checksum % 11;
		return checksum;
	}
}
