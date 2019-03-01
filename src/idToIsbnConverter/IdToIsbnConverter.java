package idToIsbnConverter;

public class IdToIsbnConverter {
	/**
	 * Converts a product id into an ISBN code
	 * @param productId A non-negative number
	 * @return The ISBN code corresponding to the product id
	 */
	public static String convertToIsbn(String productId) {
		String isbnCode = productId;
		
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
	private static String removeFirstNDigits(String id, int n) {
		
		return id.substring(n, id.length());
		
	}
	
	/**
	 * Appends a checksum to the provided id
	 * @param id The non-zero and non-negative id to append a checksum to
	 * @return An id that is appended with the checksum
	 */
	private static String attachIsbnChecksum(String id) {
		String isbn = id.concat(getIsbnChecksum(id));
		return isbn;
	}
	
	
	/**
	 * Calculates the checksum of a product id according to ISBN standards.
	 * @param productId
	 * @return The checksum of a product id
	 */
	private static String getIsbnChecksum(String productId) {
		
		double id = Double.parseDouble(productId);
		
		int checksum = 0;
		int currRadix = 2;
		
		while(id > 0) {
			double currDigit = id % 10;
			id = Math.floor(id / 10);
			checksum += currDigit * currRadix;
			
			currRadix++;
		}
		
		checksum = 11 - checksum % 11;
		
		
		if(checksum == 10) {
			return "X";
		}
		
		else {
			return String.valueOf(checksum);
		}
	}
}
