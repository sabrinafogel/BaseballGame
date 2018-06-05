import java.util.*;

public class BaseballTeam {
	private ArrayList<BaseballPlayer> roster = new ArrayList<BaseballPlayer>();
	private String name;
	
	public BaseballTeam(String n) {
		name = n;
	} /* traditional constructor; this is how we've been constructing objects */
	
	public void addPlayer(BaseballPlayer x) {
		if (x.isCurrentPlayer() == true) {
			roster.add(x);
		}
		else {
			System.out.println("\n" + x.getName() + " cannot be added to the " + name);
		}
	}
	
	public BaseballPlayer getPlayer(int i) { //returns the player at roster index i
		return roster.get(i);
	}
	
	public String toString() {
		String finReturn = name + "\n";
		int maxNameLength = name.length(); /* used for formatting, finds the longest name in the roster with the default of the team name*/
		for (BaseballPlayer b : roster) {
			if ((b.getName() + " #" + b.getJersey()).length() >= maxNameLength) { //must include name and jersey number
				maxNameLength = (b.getName() + " #" + b.getJersey()).length();
			}
		}
		for (int i = 0; i < maxNameLength-2; i++) {
			finReturn+="-"; /* formats the roster so that the name of the team is the header with the players underneath*/
		}
		for (BaseballPlayer x : roster) {
			finReturn+= "\n" + x.getName() + " #" + x.getJersey(); //cannot be included with the first for each loop because the number of dashes must be counted
		}
		return finReturn;
	}
}
