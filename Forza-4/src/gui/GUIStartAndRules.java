package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import gameComponents.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIStartAndRules extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIStartAndRules() {
		setTitle("Welcome to CONNECT4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(GUIStartAndRules.class.getResource("/icons/logo.png")));
		panel.add(logo);
		
		JTextPane rules = new JTextPane();
		rules.setForeground(new Color(0, 0, 0));
		rules.setBackground(new Color(240, 240, 240));
		rules.setFont(new Font("Calibri", Font.PLAIN, 30));
		rules.setText("\r\n\t\t\tRules of the game\r\n\r\nYou will play with another player, each player will try to connect four checkers of their color vertically, horizontally or diagonally.\r\nThe first player to reach this will win.");
		
		contentPane.add(rules, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton loadGame = new JButton("Load Game");
		loadGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(loadGame);
		
		JButton newGame = new JButton("New Game");
		newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
				String nickname1 = JOptionPane.showInputDialog("Insert player name");
				String nickname2 = JOptionPane.showInputDialog("Insert other player name");
				Player p1 = new Player(nickname1);
				Player p2 = new Player(nickname2);
				p1.setPlayerNumbers(p2);
				if(p1.getPlayerNumber() == 1) {
					JOptionPane.showMessageDialog(frame, "The player #1 is " + p1.getPlayerName() + "\nThe player #2 is " + p2.getPlayerName());
				}
				else {
					JOptionPane.showMessageDialog(frame, "The player #1 is " + p2.getPlayerName() + "\nThe player #2 is " + p1.getPlayerName());
				}
				
			}
		});
		newGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(newGame);
		
		
	}

}
