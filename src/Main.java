
public class Main {

	public static void main(String[] args) {
		int numbGuess=10;
		
		GuessTheMovie game = new GuessTheMovie();
		String movieTitle = game.readFile();
		String maskString = game.mask(movieTitle);
		String guessString = game.revealSpace(movieTitle, maskString);

		
		System.out.println ("\nGuess the movie!");
		System.out.println (guessString);
		System.out.println("\nYou begin with "+ numbGuess+" points.  A point is lost everytime an incorrect letter is chosen");
		System.out.println("The game is over if the correct movie is guessed, or if all 10 points are lost.\n\n\n");
		
		//Game begins here
		game.hangman(movieTitle, guessString);
			
	}

}
