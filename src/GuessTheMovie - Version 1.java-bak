import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class GuessTheMovie {

	private int numbGuess = 10;
	private String guessString;
	
	
	
	//Constructor
	public GuessTheMovie() {
		
	}

	
	
	
	
	public void openFile () { 
		//Declaration of Objects
		try {
			File file = new File("movies.txt");
			Scanner scanner = new Scanner(file);

			
			
			//Find the file size of movie text to create an array
			int arraySize = 0;			
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				arraySize++;
			}


			
			//declare an array of unkonwn size			
			String movie [] = new String [arraySize];
			
			System.out.print("The file has " +arraySize+ " lines in the file\n\n");
		}	
		
		
		
		catch (FileNotFoundException exception){
			System.out.print("That file doesn't exist!!");
		}
	}
	
	

	
	
	
	
	/*
	 * Main Method
	 */
	public static void main(String[] args) {
	
		GuessTheMovie game = new GuessTheMovie();
		game.openFile();
		
		
		String guessString = "________________";
		int numbGuess = 0;
		
		System.out.println("Guess the movie!");
		System.out.println("You have 10 points.  A point is lost everytime an incorrect letter is chosen");
		System.out.println("The game is over if the correct movie is guessed, or if all 10 points are lost.");
	
		System.out.println("You are guessing:" + guessString);
		System.out.println("You have guessed (" + numbGuess +") wrong letters");
	}
	
	

	
	
}
