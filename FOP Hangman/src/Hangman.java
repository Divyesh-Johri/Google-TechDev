
/*
 * Based on Stanford's hangman assignment for its CS106A class
 * (https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/handouts/200%20Assignment%204.pdf)
 * 
 * Plays like traditional hangman (with the inclusion of feet -- 8 guesses), this class starts
 * as a stub with a console playable hangman using a list of words provided by HangmanLexicon. 
 * It will then include implementation with a GUI interface using the acm java package.
 */
import java.util.*;

public class Hangman {
	//Main method
	public static void main(String [] args) throws Exception {
		
		HangmanLexicon lex = new HangmanLexicon();
		Scanner reader = new Scanner(System.in);
		
		int index = (int)(Math.random()*10);
		
		String word = lex.getWord(index).toLowerCase();	
		ArrayList<Character> corGuessedLts = new ArrayList<Character>(word.length());
		int incorrect = 8;
		
		String guess = "";
		for (int i = 0; i < word.length(); i++)
		{ guess = guess.concat("-"); }
		
		System.out.println("Welcome to Hangman!!");
		// Continue the game until the word is fully guessed or 8 incorrect guesses is reached
		game:
		while(incorrect > 0) {
			// Prompts
			System.out.println("The word so far looks like this: " + guess);
			System.out.println(String.format("You have %d guesses left", incorrect));
			System.out.print("Your guess: ");
			char letter = reader.nextLine().toLowerCase().charAt(0);
			
			// Validation
			if (!Character.isLetter(letter)) {
				System.out.println("Not a legal guess, try again.");
				continue game;
			}
			for (char i : corGuessedLts) {
				if (letter == i) {
					System.out.println("This is already a known letter, try again.");
					continue game;
				}					
			}
			
			// Check if letter exists
			char[] wordArr = word.toCharArray();
			for (char i : wordArr) {
				if (letter == i) {
					updateGuess(letter, guess, word);
					corGuessedLts.add(letter);
					System.out.println("That guess is correct.");
					// End the game if player won (break)
					
					// Continue the game if not
					continue game;
				}
			}
			
			// If letter doesn't exist
			System.out.println(String.format("There are no %c's in the word.", letter));
			incorrect--;
		}
		
		// If incorrect is 0, player lost. Otherwise, player won.
		
	}
	
	
	// Update word
	// Receives guessed letter, player's guessed word, and the word itself.
	// Returns updated guessed word.
	public static String updateGuess(char letter, String guess, String word) {
		
	}
	
}
