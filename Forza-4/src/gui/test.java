package gui;

import gameComponents.*;

public class test {
	public static void main(String[] args) {
		boolean start = false;
		GUIStartAndRules rulesFrame = new GUIStartAndRules();
		rulesFrame.setVisible(true);
		// creo i giocatori con i dati inseriti da interfaccia
		if(rulesFrame.isVisible()) {
			Player[] players = rulesFrame.getPlayersData();
			Player p1 = players[0];
			Player p2 = players[1];
			
		}
		
		
		/*GUIGame activeGame = new GUIGame();
		activeGame.setVisible(true);*/
			
	}
}

