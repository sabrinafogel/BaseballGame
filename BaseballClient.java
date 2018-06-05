import java.io.IOException;

public class BaseballClient {
	
	public static void main (String[] args) throws IOException {
		
		BaseballGame trial = new BaseballGame();
		
		/* Trial Players:
		  
		  	Travis Jankowski
			Freddy Galvis
			Carlos Asuaje
			Wil Myers
			Austin Hedges
			Hunter Renfroe
			Cory Spangenberg
			Jose Pirela
			Tyson Ross

			Albert Almora
			Kris Bryant
			Anthony Rizzo
			Javier Baez
			Ian Happ
			Jason Heyward
			Ben Zobrist
		 	Kyle Schwarber
			Jon Lester
		 	
		 */
		
		/* Notes:
		 * 	goals of the project: 	create a fantasy baseball game where the user can input 
		 * 							player and team names, and the program outputs the rosters
		 * 							along with the field display with the player's numbers
			structure diagram highlighting the different classes/objects:
			
			
						       BaseballGame - - - - - - BaseballClient
					  		  /		      \
						 	 /			   \
							/				\
					BaseballTeam			BaseballTeam
						  /					  \
						 /					   \
						/						\
				BaseballPlayer				BaseballPlayer
				
				
				
			things that were hard/didn't get done/blocked you:	i had a hard time with formatting the
																output of the popups, and i had a lot of
																careless mistakes (copy errors, IndexOutOfBounds)
			what you learned/taught yourself:	i learned how to scrape a website for data and how to 
												create a popup window with JTextFields, JTextLabels, and
												JTextAreas
			what you would have done with more time:	if i had more time, i would've made the program playable
													with a button for throwing pitches, calculating if the
													player would hit the ball or not (single, double, triple, hr)
													i would also potentially include a scoreboard
		*/
		
	}
}
