import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class BaseballGame { 
	
	private String name1 = ""; 
	private String name2 = "";
	private BaseballTeam team1 = new BaseballTeam("");
	private BaseballTeam team2 = new BaseballTeam("");
	private JFrame output = new JFrame("Fantasy Baseball Game");

	public BaseballGame(){
		nameReader();
	}
	
	public void nameReader() {

		output.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		output.setBounds(200, 100, 400, 200);
		
		Container container = output.getContentPane();
		container.setLayout(null);
		
		JLabel enterNames = new JLabel("Enter the team names below :");
		enterNames.setBounds(20,5,250,30); // Constructs header
		
		JLabel team1Label = new JLabel("Team One :");
		team1Label.setBounds(20,40,250,30); // Labels for team 1 and 2
		
		JLabel team2Label = new JLabel("Team Two :");
		team2Label.setBounds(20,70,250,30);
		
		JTextField team1Text = new JTextField(); // Gets input for team 1 and 2 name
		team1Text.setBounds(95,40,250,30);
		
		JTextField team2Text = new JTextField();
		team2Text.setBounds(95, 70, 250, 30);
		
		JButton doneBtn  = new JButton("Done"); // Done button
		doneBtn.setBounds(150,110,100,30);
				
		
		container.add(enterNames);
		container.add(team1Label);
		container.add(team2Label);
		container.add(team1Text);
		container.add(team2Text);
		container.add(doneBtn);
		output.setVisible(true);
		
		
		doneBtn.addActionListener(new ActionListener(){ // When the done button is pressed...
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == doneBtn) { // takes in the user input and creates new teams using input
					name1 = team1Text.getText();
					name2 = team2Text.getText();
					team1 = new BaseballTeam(name1);
					team2 = new BaseballTeam(name2);
				}
				output.setVisible(false);
				container.remove(enterNames);
				container.remove(team1Label);
				container.remove(team2Label);
				container.remove(team1Text);
				container.remove(team2Text);
				container.remove(doneBtn);
				enterPlayers(); // Calls next method (enterPlayers())

			}
			
		});
		
	}
	
	public void enterPlayers() {
		
		Container container = output.getContentPane();
		container.setLayout(null);
		
		output.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		output.setBounds(200, 100, 800, 600);
		
		JLabel enterNames = new JLabel("Enter the rosters below :");
		enterNames.setBounds(325,5,400,30); // Constructs header
		
		JLabel team1Label = new JLabel(name1); /* Had to convert the number of characters to the number of pixels*/
		team1Label.setBounds(100+((name1.length()*8)/2),40,250,30); // Labels for team 1 and 2
		
		JLabel team2Label = new JLabel(name2);
		team2Label.setBounds(500+((name1.length()*8)/2),40,250,30);
		
		// Player entry slots, listed first by team one and then by team two
		// Named according to team # and player #
		
		/////////* TEAM ONE */////////
		
		ArrayList<JTextField> team1Players = new ArrayList<JTextField>();
		
		JTextField t1p1 = new JTextField(); 
		t1p1.setBounds(105,80,200,30);
		team1Players.add(t1p1);
		
		JTextField t1p2 = new JTextField(); 
		t1p2.setBounds(105,120,200,30);
		team1Players.add(t1p2);
		
		JTextField t1p3 = new JTextField();
		t1p3.setBounds(105,160,200,30);
		team1Players.add(t1p3);
		
		JTextField t1p4 = new JTextField(); 
		t1p4.setBounds(105,200,200,30);
		team1Players.add(t1p4);
		
		JTextField t1p5 = new JTextField(); 
		t1p5.setBounds(105,240,200,30);
		team1Players.add(t1p5);
		
		JTextField t1p6 = new JTextField();
		t1p6.setBounds(105,280,200,30);
		team1Players.add(t1p6);
		
		JTextField t1p7 = new JTextField();
		t1p7.setBounds(105,320,200,30);
		team1Players.add(t1p7);
		
		JTextField t1p8 = new JTextField();
		t1p8.setBounds(105,360,200,30);
		team1Players.add(t1p8);
		
		JTextField t1p9 = new JTextField();
		t1p9.setBounds(105,400,200,30);
		team1Players.add(t1p9);
		
		/////////* TEAM TWO */////////
		
		ArrayList<JTextField> team2Players = new ArrayList<JTextField>();
		
		JTextField t2p1 = new JTextField();
		t2p1.setBounds(505,80,200,30);
		team2Players.add(t2p1);
		
		JTextField t2p2 = new JTextField();
		t2p2.setBounds(505,120,200,30); 
		team2Players.add(t2p2);
		
		JTextField t2p3 = new JTextField(); 
		t2p3.setBounds(505,160,200,30);
		team2Players.add(t2p3);
		
		JTextField t2p4 = new JTextField(); 
		t2p4.setBounds(505,200,200,30);
		team2Players.add(t2p4);
		
		JTextField t2p5 = new JTextField(); 
		t2p5.setBounds(505,240,200,30);
		team2Players.add(t2p5);
		
		JTextField t2p6 = new JTextField();
		t2p6.setBounds(505,280,200,30);
		team2Players.add(t2p6);
		
		JTextField t2p7 = new JTextField();
		t2p7.setBounds(505,320,200,30);
		team2Players.add(t2p7);
		
		JTextField t2p8 = new JTextField();
		t2p8.setBounds(505,360,200,30);
		team2Players.add(t2p8);
		
		JTextField t2p9 = new JTextField();
		t2p9.setBounds(505,400,200,30);
		team2Players.add(t2p9);
		
		//////////////////////////////
		
		JButton doneBtn  = new JButton("Done");
		doneBtn.setBounds(360,500,100,30);
		
		container.add(enterNames);
		container.add(team1Label);
		container.add(team2Label);
		for (JTextField j : team1Players) { // For loops save space when adding to container (and to teams)
			container.add(j);
		}
		for (JTextField j : team2Players) {
			container.add(j);
		}
		container.add(doneBtn);
		output.setVisible(true);
		
		doneBtn.addActionListener(new ActionListener(){ // When done button is pressed...
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == doneBtn) {
					try { //Add players to the team
						for (JTextField j : team1Players) {
							team1.addPlayer(new BaseballPlayer(j.getText()));
						}
						for (JTextField j : team2Players) {
							team2.addPlayer(new BaseballPlayer(j.getText()));
						}

					} catch (IOException e1) { /* if the name entered is not a real player*/
						e1.printStackTrace();
					}
				}
				
				output.setVisible(false);
				container.remove(enterNames);
				container.remove(team1Label);
				container.remove(team2Label);
				for (JTextField j : team1Players) {
					container.remove(j);
				}
				for (JTextField j : team2Players) {
					container.remove(j);
				}
				container.remove(doneBtn);
				try {
					displayGame();
				} catch (IOException e1) { // will *hopefully* never happen
					e1.printStackTrace();
				}
			}
			
		});
		
		
	}
	
	public void displayGame() throws IOException { // shows the playing field
		Container container = output.getContentPane();
		container.setLayout(null);
		
		output.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		output.setBounds(200, 100, 800, 500);
		output.setVisible(true);
		
		JTextArea printTeam1 = new JTextArea(team1.toString()); // prints team 1 roster
		printTeam1.setBounds(0,0,200,200);
		printTeam1.setEditable(false); // USER CANNOT EDIT THE VALUES
		
		/* OK SO 
		 * i wanted to include the number of the pitcher but the code didn't work */
		
		JTextArea printTeam2 = new JTextArea(team2.toString()); // prints team 2 roster
		printTeam2.setBounds(600,0,200,200);
		printTeam2.setEditable(false);
		
		String field = 	"                                     .............. " + "\n" + // shows the baseball diamond, is ugly af
						"                                  ⋰:            :⋱" + "\n" +
						"                               ⋰   :            :   ⋱" + "\n" +
						"                            ⋰      :            :       ⋱" + "\n" + 
						"                         ⋰         :............           ⋱" + "\n" + 
						"                      ⋰                                       ⋱" + "\n" +
						"                   ⋰                                             ⋱" + "\n" +
						"                ⋰                                                   ⋱" + "\n" + 
						"             ⋰                                                         ⋱" + "\n" + 
						"          ⋰                                                               ⋱" + "\n" +
						"       ⋰                                                                     ⋱" + "\n" +   
						" ............                         ............                        ............" + "\n" +
						" :          :                         :          :                        :          :" + "\n" +
						" :          :                         :          :                        :          :" + "\n" +  
						" :          :                         :          :                        :          :" + "\n" +
						" :..........:                         :..........:                        :..........:" + "\n" +
						"      ⋱                                                                        ⋰" + "\n" +
						"         ⋱                                                                  ⋰" + "\n" +
						"            ⋱                                                            ⋰" + "\n" +
						"               ⋱                                                      ⋰" + "\n" +
						"                  ⋱                                                ⋰" + "\n" + 
						"                     ⋱                                          ⋰" + "\n" +
						"                        ⋱           .............            ⋰" + "\n" + 
						"                           ⋱       :             :        ⋰" + "\n" + 
						"                              ⋱    :     " + team2.getPlayer(0).getJersey() /* this shows the current player's jersey number,
						 																				was going to be used in playthrough of game
						 																				but did not code the gaming mechanic*/ + "      :     ⋰" + "\n" +
						"                                 ⋱ :             :  ⋰" + "\n" + 
						"                                     :.............:" ;
		JTextArea printField = new JTextArea(field);
		printField.setBounds(220,0,350,450);
		printField.setEditable(false); 
		
		container.add(printTeam1);
		container.add(printTeam2);
		container.add(printField);
		output.setVisible(true);
	}

}
