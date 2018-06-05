import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class BaseballPlayer {
	private String name;
	private double BA = 0;
	private double ERA = 0.0;
	private int jerseyNum;
	private String position;
	private String url = "https://www.baseball-reference.com/players/";
	private boolean real;
	
	public BaseballPlayer(String n, double ba, int j, String p) {
		/* traditional constructor; this is how we've been constructing objects */
		name = n; BA = ba; jerseyNum = j; position = p;
	} 
	
	public BaseballPlayer(String n) throws IOException {
		/* new kind of constructor; uses web scraping to get data*/
		name = n;
		String lastname = n.substring(n.indexOf(" ")+1);
		if (lastname.length()>5) {
			lastname = lastname.substring(0, 5); /* finds the player's last name, cuts it down to 5 characters if it is longer than 5 characters*/
		}
		
		url += lastname.substring(0,1).toLowerCase() + "/" + lastname.toLowerCase() + n.substring(0, 2).toLowerCase() + "01.shtml";
		
		/* mine web-site for player data*/
		try {
			Document doc = Jsoup.connect(url).get(); /* searches each individual player's web-site, without having to use the search function on baseball-reference.com */
			Elements ba = doc.getElementsByTag("meta");
			String description = ""; /* description : main source of player data*/
			for (Element e : ba) {
				if (e.toString().contains("Description")) {
					description = e.toString();
				}
			}
			description = description.substring(description.indexOf("Career")); /* cuts down description to necessary info */
			String[] careerStats$ = description.split(","); /* creates a new array that has the elements of description, but split by spaces */
			String[] statFinal = new String[5];
			for (int i = 0; i < 5 ; i ++) { /* transfers values into statFinal */
				statFinal[i] = careerStats$[i]; /* the first few stats aren't important so I skipped those */
			}

			position = statFinal[3];
			if (position.toLowerCase().equals("p")) {
				ERA = Double.parseDouble(statFinal[1].substring(0,5)); /* the ERA and BA stats are in the
				same location in the source code, but the ERA is for pitchers and BA is for all other
				players. this scouts to see if it is a pitcher or a different player*/
			}
			else {
				BA = Double.parseDouble(statFinal[1].substring(0,5));
			}
			
			
			
			Elements jNum = doc.getElementsByTag("a"); /* scans for "a" files */
			
			String findCurrentYear = "";

			for (Element e : jNum) {
				if (e.toString().indexOf("number=")!=-1 && e.toString().indexOf("2018")!=-1) { /* conditions: if it refers to the player's number, and if it is from the current year*/
					findCurrentYear= e.toString(); 
				}
			}
			String specificLink = findCurrentYear.substring(findCurrentYear.indexOf("r=")+2, findCurrentYear.indexOf("\" ")); /* makes sure that it find the player's number even if it's two digits*/
			jerseyNum = Integer.parseInt(specificLink);
			
			real = true;
		}
		catch (HttpStatusException e) {
			real = false;
		}
	} 
	
	public String getName() { //gets player's name
		return name;
	}
	
	public String getPosition() { //gets player's position, returns all of positions available (i.e. 2B/SS/3B)
		return position;
	}
	
	public double getBA() { //gets player's batting average
		return BA;
	}
	
	public double getERA() { //gets player's earned run average (pitchers)
		return ERA;
	}
	
	public int getJersey() { //gets player's jersey number
		return jerseyNum;
	}
	
	public boolean isCurrentPlayer() {
		if (real == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		if (position.toLowerCase().equals("p")) {
			return name + " #" + jerseyNum + " (" + position + " ERA: " + ERA + ")";
		}
		else {
			return name + " #" + jerseyNum + " (" + position + " BA: " + BA + ")";
		}
	}
	
}
