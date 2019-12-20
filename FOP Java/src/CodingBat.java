import java.util.Scanner;

// Has CodingBat solutions and others
// Also used to mess around with functions

public class CodingBat {
	
	public static void main (String [] args) {
		System.out.println("haha");
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
		
			for(int i = 0; i < base.length(); i++) {
				if (i+remove.length() > base.length()){
					break;
				} else if (base.substring(i, i+remove.length()).equalsIgnoreCase(remove)) {
					base.replace(base.substring(i, i+remove.length()), "");
				}
			}
	
		return base;
	}
}
