package isbnConverter;

/**
 * An implementation of the IsbnConverter which accepts 12 digit product Ids, converting them into ISBN-10 codes.
 * @author Averg
 *
 */
public class Isbn10Converter implements IsbnConverter{
	
	/**
	 * Converts a product id into an ISBN code
	 * @param productId A 12-digit string representing a product id.
	 * @return The ISBN code corresponding to the provided product id
	 */
	public String convertToIsbn(String productId) {
		String isbnCode = productId;
		
		isbnCode = removeFirstNDigits(isbnCode, 3);
		isbnCode = attachIsbnChecksum(isbnCode);
		
		return isbnCode;
	}
	
	/**
	 * Removes the first n digits from an id
	 * @param id The id to remove a digit from.
	 * @param n The number of digits to remove, must be lower than number of digits in the id.
	 * @return An id with the first n digits removed.
	 */
	private static String removeFirstNDigits(String id, int n) {
		
		if(n > id.length()){
			throw new RuntimeException("n must be less than the number of characters in id!");
		}
		
		return id.substring(n, id.length());
		
	}
	
	/**
	 * Appends a checksum to the provided id
	 * @param id A numeric id to append a checksum to
	 * @return The product id appended with a checksum
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
			return "x";
		}
		
		else if(checksum == 11) {
			return "0";
		}
		
		else {
			return String.valueOf(checksum);
		}
	}
}
