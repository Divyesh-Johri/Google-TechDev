import java.util.Scanner;
// Has CodingBat solutions and others
// Also used to mess around with functions

public class CodingBat {
	
	public static void main (String [] args) {
		
		System.out.println(canBalance(new int[] {1, 1, 1, 2, 1}));
		//System.out.println(canBalance(new int[] {2, 1, 1, 2, 1}));
		//System.out.println(canBalance(new int[] {10, 10}));
		
	}
	
	/** stringSplosion CodingBat problem
	 * 
	 * Given a non-empty string like "Code" return a string like "CCoCodCode".
	 * 
	 * stringSplosion("Code") → "CCoCodCode"
	 * stringSplosion("abc") → "aababc"
	 * stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String retStatement = "";
		
		  for(int x = 0; x <= str.length(); x++){
		      retStatement += str.substring(0, x);
		  }
		  
		  return retStatement;
	}
	
	/** maxSpan CodingBat problem
	 * 
	 * Consider the leftmost and rightmost appearances of some value in an array. 
	 * We'll say that the "span" is the number of elements between the two inclusive. 
	 * A single value has a span of 1. Returns the largest span found in the given array. 
	 * (Efficiency is not a priority.)
	 * 
	 * maxSpan([1, 2, 1, 1, 3]) → 4
	 * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
	 * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
	 */
	public int maxSpan(int[] nums) {
		  
		int maxSpan = 0;
		
		// A double for loop will locate both sides of possible spans
		for(int front = 0; front < nums.length; front++) {
			for(int back = nums.length - 1; back >= 0; back--) {
				//See if a span exists and if it's a max span
				if(nums[back] == nums[front] && (front-back)+1 > maxSpan){					
					maxSpan = (front - back) + 1;
				}
			}
		}
		
		return maxSpan;
	}
	
	/** withoutString CodingBat problem
	 * 
	 * Given two strings, base and remove, return a version of the base string where all instances 
	 * of the remove string have been removed (not case sensitive). You may assume that the remove 
	 * string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" 
	 * leaves "x".
	 * 
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there" 
	 */
	public static String withoutString(String base, String remove) {		
		
			// Increment through the string and find substrings in base that equal remove
			for(int i = 0; i < base.length(); i++) {
				if (i+remove.length() > base.length()){ // To prevent IndexOutOfBounds
					break;
				} else if (base.substring(i, i+remove.length()).equalsIgnoreCase(remove)) {
					base = base.replaceAll(base.substring(i, i+remove.length()), "");
				}
			}	
			
		return base;
	}
	
	/** sumNumbers CodingBat problem
	 * 
	 * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
	 * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char 
	 * is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
	 * 
	 * sumNumbers("abc123xyz") → 123
	 * sumNumbers("aa11b33") → 44
	 * sumNumbers("7 11") → 18
	 */
	public static int sumNumbers(String str) {
		
		// Converting string to a char array for easier traversal
		// Also using currentNum and sum to help find and sum numbers
		char[] stringList = str.toCharArray();
		String currentNum = "";
		int sum = 0;
		
		// Traverse through the char array, find digits, and if the number has ended,
		// add to the total sum
		for (int i = 0; i < stringList.length; i++){
			if (Character.isDigit(stringList[i])) {
				
				currentNum = currentNum.concat(Character.toString(stringList[i]));
				
				if (i+1 == stringList.length || !Character.isDigit(stringList[i+1])) {
					sum += Integer.parseInt(currentNum);
					currentNum = "";
				}
			}
		}
		
		return sum;
	}
	
	/** canBalance CodingBat problem
	 * 
	 * Given a non-empty array, return true if there is a place to split the array so that the sum of the 
	 * numbers on one side is equal to the sum of the numbers on the other side.
	 * 
	 * canBalance(new int[] {1, 1, 1, 2, 1}) → true
	 * canBalance(new int[] {2, 1, 1, 2, 1}) → false
	 * canBalance(new int[] {10, 10}) → true
	 */
	public static boolean canBalance(int[] nums) {
		 	// Start in the middle of the array, shift towards the side that has a larger sum.
			// If the side that was smaller becomes larger without balance, its impossible.
		
			int divide = nums.length / 2; //Start in the middle of the array
			int sumL = 0;
			int sumR = 0;
			
			//
			do {
				// Move the divider
				if (sumL < sumR)
					divide++;
				if (sumL > sumR)
					divide--;
				
				// Reset sums
				sumL = 0;
				sumR = 0;
				
				// Find new sums			
				for (int i = 0; i < nums.length; i++) {
					if (i < divide)
						sumL += nums[i];
					else
						sumR += nums[i];
				}
				
				// Check for balance
				if (sumL == sumR)
					return true;
				
			} while (divide > 0 && divide < nums.length);
				
			return false;
	}
	
}
