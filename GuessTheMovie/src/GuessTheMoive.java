import java.io.File;
import java.util.Scanner;


public class GuessTheMoive {

	
	//Constructor
	public void GuessTheMovie() {
		
	}

	
	
	
	
	
	

	
	
	
	/*
	 * Main Method
	 */
	public static void main(String[] args) {
	
		String guessString = "________________";
		int numbGuess = 0;
		
		System.out.println("Guess the movie!");
		System.out.println("You have 10 points.  A point is lost everytime an incorrect letter is chosen");
		System.out.println("The game is over if the correct movie is guessed, or if all 10 points are lost.");
		
		
		File file = new File("movies.txt");
		//Scanner scanner = new Scanner(file);	
	
		System.out.println("You are guessing:" + guessString);
		System.out.println("You have guessed (" +numbGuess+") wrong letters");
		
		
	
	}
	
	

	
	
}
