package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gameComponents.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayersCreation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField playerNameText;
	private JTextField rivalNameText;
	private Player[] players = new Player[2];
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			PlayerNameSelection dialog = new PlayerNameSelection();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public PlayersCreation() {
		setTitle("Player's names choice");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel playerName = new JLabel("Player's name");
			contentPanel.add(playerName);
		}
		{
			playerNameText = new JTextField();
			contentPanel.add(playerNameText);
			playerNameText.setColumns(10);
		}
		{
			JLabel rivalName = new JLabel("Rival's name");
			contentPanel.add(rivalName);
		}
		{
			rivalNameText = new JTextField();
			contentPanel.add(rivalNameText);
			rivalNameText.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String nick1 = playerNameText.getText();
						String nick2 = rivalNameText.getText();
						Player p1 = new Player(nick1);
						Player p2 = new Player(nick2);
						p1.setPlayerNumbers(p2);
						if(p1.getPlayerNumber() == 1) {
							JOptionPane.showMessageDialog(okButton, "Player #1 is " + p1.getPlayerName() + "\nPlayer #2 is " + p2.getPlayerName());
							boolean rightChoice = false;
							JRadioButton redColor = new JRadioButton("red");
							JRadioButton yellowColor = new JRadioButton("yellow");
							JPanel btnPanel = new JPanel();
							JPanel msgPanel = new JPanel();
							msgPanel.add(new JLabel(p1.getPlayerName() + " choose one of these colors"));
							btnPanel.add(redColor);
							btnPanel.add(yellowColor);
							JPanel panel = new JPanel();
							panel.add(msgPanel);
							panel.add(btnPanel);
							JOptionPane.showMessageDialog(null, panel);
							if(redColor.isSelected() && yellowColor.isSelected()) {
								rightChoice = false;
							}
							else if(redColor.isSelected()) {
								p1.iAmRed(p2);
								rightChoice = true;
							}
							else{
								p1.iAmYellow(p2);
								rightChoice = true;
							}
							while(!rightChoice) {
								redColor = new JRadioButton("red");
								yellowColor = new JRadioButton("yellow");
								btnPanel = new JPanel();
								msgPanel = new JPanel();
								msgPanel.add(new JLabel(p1.getPlayerName() + " you can only choose one of these colors"));
								btnPanel.add(redColor);
								btnPanel.add(yellowColor);
								panel = new JPanel();
								panel.add(msgPanel);
								panel.add(btnPanel);
								JOptionPane.showMessageDialog(null, panel);
								if(redColor.isSelected() && yellowColor.isSelected()) {
									rightChoice = false;
								}
								else if(redColor.isSelected()) {
									p1.iAmRed(p2);
									rightChoice = true;
								}
								else{
									p1.iAmYellow(p2);
									rightChoice = true;
								}
							}
							GUIStartAndRules.setPlayersData(p1, p2);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(okButton, "Player #1 is " + p2.getPlayerName() + "\nPlayer #2 is " + p1.getPlayerName());
							boolean rightChoice = false;
							JRadioButton redColor = new JRadioButton("red");
							JRadioButton yellowColor = new JRadioButton("yellow");
							JPanel btnPanel = new JPanel();
							JPanel msgPanel = new JPanel();
							msgPanel.add(new JLabel(p2.getPlayerName() + " choose one of these colors"));
							btnPanel.add(redColor);
							btnPanel.add(yellowColor);
							JPanel panel = new JPanel();
							panel.add(msgPanel);
							panel.add(btnPanel);
							JOptionPane.showMessageDialog(null, panel);
							if((redColor.isSelected() && yellowColor.isSelected()) || (!redColor.isSelected() && !yellowColor.isSelected())) {
								rightChoice = false;
							}
							else if(redColor.isSelected()) {
								p2.iAmRed(p1);
								rightChoice = true;
							}
							else{
								p2.iAmYellow(p1);
								rightChoice = true;
							}
							while(!rightChoice) {
								redColor = new JRadioButton("red");
								yellowColor = new JRadioButton("yellow");
								btnPanel = new JPanel();
								msgPanel = new JPanel();
								msgPanel.add(new JLabel(p2.getPlayerName() + " you can only choose one of these colors"));
								btnPanel.add(redColor);
								btnPanel.add(yellowColor);
								panel = new JPanel();
								panel.add(msgPanel);
								panel.add(btnPanel);
								JOptionPane.showMessageDialog(null, panel);
								if((redColor.isSelected() && yellowColor.isSelected()) || (!redColor.isSelected() && !yellowColor.isSelected())) {
									rightChoice = false;
								}
								else if(redColor.isSelected()) {
									p2.iAmRed(p1);
									rightChoice = true;
								}
								else{
									p2.iAmYellow(p1);
									rightChoice = true;
								}
							}
							GUIStartAndRules.setPlayersData(p2, p1);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean isCreationEnded() {
		return true;
	}
}
