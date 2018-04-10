import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.*;


public class GuessTheMovie {

	private int randomNumber;	
	private int counter = 10;
	private String wrongLetter[] = new String[10];
	ArrayList<String> obj = new ArrayList<String>();
	
	//Constructor
	public GuessTheMovie() {		
		
	}

	
	/* ***  readFile() Method ***
	 *  This method will read the file movies.txt and store that information into an array
	 *  Once the size of the array is known, a random movie title will be picked and returned back 
	 *  to the Main method 
	 *  2 Scanner elements are needed.   
	 *  Scanner #1 - Count the Array Size
	 *  Scanner #2 - Create the array 
	 *  Once the Array size is known, a Method to generate a random number is called, passing in the array Size
	 *  The random Number method returns a random number from 0 - (ArraySize-1) 
	 *  A string is created containing the array entry @ random array number
	 *  This string is passed back to the main array */
	
	public String readFile(){ 
		//Declaration of Objects
		String temp ="";
		String movieName;
		int randomInt;
		
		try {
			File file = new File("movies.txt");
			Scanner arrayScan = new Scanner(file);
			Scanner scanner = new Scanner(file);
			int arraySize = 0;
			int movieSize=0;
						
			//Discover how big the file is
			while (arrayScan.hasNextLine()) {
				arrayScan.nextLine();
				arraySize++;
			}
			arrayScan.close();
			
			
			//Fill up the Array
			String movie [] = new String [arraySize];
			while (scanner.hasNextLine()) {
				movie[movieSize]=scanner.nextLine();
				movieSize++;
			}
			scanner.close();

			randomInt = setRandom(arraySize);
			movieName = movie[randomInt];
			return movieName;
		}
		
		catch (FileNotFoundException exception){
			System.out.print("That file doesn't exist!!");
		}
	return temp;
	}
	
	
	
	/* This Method line replaces characters in the movie title with "_"
	 * We are creating 'guessString' from a character array the String Construct String(Char[])
	 * The char[] temp is a character array with the size of 'movieTitle.length';
	 * The character array is filled with a null value...or '\0'
	 * String(Char[]) =  String(temp)
	 * we use the String.replace to swap all the Null characters with '_' */
	
	public String mask (String movieTitle) {
		char[] temp = new char[movieTitle.length()];
		String maskString = new String(temp).replace("\0", "_");
		return maskString;
	}
		

	
	/* This method generates a random number.
	 * An integer is passed in and the random number is returned. */
	private int setRandom(int randomNumber) {		
		this.randomNumber = (int)(Math.random()*randomNumber);
		return this.randomNumber;
	}
	
	
	
	/* This Method reveals the spaces in the movie name.
	 * Eg. Star Wars = _________ is now ____ ____ */
	public String revealSpace(String movie, String guess) {
		String space = " ";
		for (int i=0;i<guess.length();i++) {
			if (movie.charAt(i) == space.charAt(0)) {
				guess = guess.substring(0,i) + space + guess.substring(i+1);	
			}
		}
		return guess;		
	}
	

	
	
	/*
	 * This method is the main Hangman Game
	 * 
	 */
		public void hangman(String movieTitle, String guessString) {
			
			int wrong = 0;

			
			for (int i=0;i<10;i++) {	
				boolean wrongBool = false;
				boolean rightBool = false;
				boolean check1=false;

				System.out.print("You are guessing: "+ guessString +": Number of Guesses remaining[" + counter);
				
				//This is the for loop that appropriately displays the correct Wrong Letters:
					if (wrong>0) {
						System.out.print("] - Wrong Letters: ");
						for (int k=0;k<wrong;k++) {
							if (k == (wrong-1)) {
								System.out.print(wrongLetter[k] + " \n");}
							else { System.out.print(wrongLetter[k] + " ");}
						}			
					}
					else {System.out.print("]  - Wrong Letters: \n");}
					

					
				//We are calling the method to input our character	
					String guessChar = selectChar();
				

				//We are seeing if the our guess is found in the movie title
					for (int j=0; j<movieTitle.length();j++) {
						if (movieTitle.charAt(j) == guessChar.charAt(0)) {
							guessString = guessString.substring(0,j) + guessChar + guessString.substring(j+1);
							rightBool = true;
							i--;
							}
						
						else  {
							wrongBool = true;
							}							
					}
					

/*				  A check that we go through when we discover an incorrect value
 				* We are dumping all the wrong inputs in an arraylist and this way we can check for repeated characters.
 				* if there is no duplicate, we add the wrong value into the wrongLetter Array
 				* If there is a duplicate we let the user know	*/
					
				if (wrongBool==true && rightBool == false ) {					
					if (obj.contains(guessChar)) {
						System.out.println("You've already chosen "+ guessChar + ".  Please choose again");		
						wrong--;
						counter++;
						i--;
						
					}
					else {
						obj.add(guessChar);
						wrongLetter[wrong] = guessChar;
					}
										
					wrong++;
				}
				
				//This check is to find out if we have successfully completed the game
				else if (movieTitle.equals(guessString)) {
					break;
				}
				
				//This else is entered if the user enters a correct character, and offsetting the counter-- in the line below.
				else {
					counter++;
				}
				
				counter--;
			}
			
			//Final IF statement - Completed the game either by solving it or running out of guesses
			if (movieTitle.equals(guessString)) {
				System.out.print("YOU SOLVED IT!! - The movie is "+ guessString + "\n");}
			
				else{
				System.out.print("You ran out of guesses \n");
				}
		}	
		
		
		
		/* This Method grabs the user input
		 * A Try and Catch is not needed since we are dealing directly with a String
		 * scanner.useDelimiter is used to take the first character from the scanner function 
		 * We convert all the inputs into lowercase*/		
		private String selectChar () {
			
			String scanInput;
			System.out.println("Please guess a letter:  ");
			Scanner scanner = new Scanner(System.in);
			scanner.useDelimiter("");
			scanInput = scanner.next();			
			scanInput = scanInput.toLowerCase();
			return scanInput;
		}
}
