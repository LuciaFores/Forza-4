package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIGame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public GUIGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttons = new JPanel();
		contentPane.add(buttons, BorderLayout.NORTH);
		buttons.setLayout(new GridLayout(0, 7, 12, 0));
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttons.add(btn7);
		
		JPanel playingGrid = new JPanel();
		contentPane.add(playingGrid, BorderLayout.CENTER);
		playingGrid.setLayout(new GridLayout(6, 7, 0, 0));
		
		JLabel cell1_1 = new JLabel("");
		cell1_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_1);
		
		JLabel cell1_2 = new JLabel("");
		cell1_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_2);
		
		JLabel cell1_3 = new JLabel("");
		cell1_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_3);
		
		JLabel cell1_4 = new JLabel("");
		cell1_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_4);
		
		JLabel cell1_5 = new JLabel("");
		cell1_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_5);
		
		JLabel cell1_6 = new JLabel("");
		cell1_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_6);
		
		JLabel cell1_7 = new JLabel("");
		cell1_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell1_7);
		
		JLabel cell2_1 = new JLabel("");
		cell2_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_1);
		
		JLabel cell2_2 = new JLabel("");
		cell2_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_2);
		
		JLabel cell2_3 = new JLabel("");
		cell2_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_3);
		
		JLabel cell2_4 = new JLabel("");
		cell2_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_4);
		
		JLabel cell2_5 = new JLabel("");
		cell2_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_5);
		
		JLabel cell2_6 = new JLabel("");
		cell2_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_6);
		
		JLabel cell2_7 = new JLabel("");
		cell2_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell2_7);
		
		JLabel cell3_1 = new JLabel("");
		cell3_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_1);
		
		JLabel cell3_2 = new JLabel("");
		cell3_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_2);
		
		JLabel cell3_3 = new JLabel("");
		cell3_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_3);
		
		JLabel cell3_4 = new JLabel("");
		cell3_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_4);
		
		JLabel cell3_5 = new JLabel("");
		cell3_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_5);
		
		JLabel cell3_6 = new JLabel("");
		cell3_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_6);
		
		JLabel cell3_7 = new JLabel("");
		cell3_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell3_7);
		
		JLabel cell4_1 = new JLabel("");
		cell4_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_1);
		
		JLabel cell4_2 = new JLabel("");
		cell4_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_2);
		
		JLabel cell4_3 = new JLabel("");
		cell4_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_3);
		
		JLabel cell4_4 = new JLabel("");
		cell4_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_4);
		
		JLabel cell4_5 = new JLabel("");
		cell4_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_5);
		
		JLabel cell4_6 = new JLabel("");
		cell4_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_6);
		
		JLabel cell4_7 = new JLabel("");
		cell4_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell4_7);
		
		JLabel cell5_1 = new JLabel("");
		cell5_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_1);
		
		JLabel cell5_2 = new JLabel("");
		cell5_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_2);
		
		JLabel cell5_3 = new JLabel("");
		cell5_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_3);
		
		JLabel cell5_4 = new JLabel("");
		cell5_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_4);
		
		JLabel cell5_5 = new JLabel("");
		cell5_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_5);
		
		JLabel cell5_6 = new JLabel("");
		cell5_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_6);
		
		JLabel cell5_7 = new JLabel("");
		cell5_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell5_7);
		
		JLabel cell6_1 = new JLabel("");
		cell6_1.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_1);
		
		JLabel cell6_2 = new JLabel("");
		cell6_2.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_2);
		
		JLabel cell6_3 = new JLabel("");
		cell6_3.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_3);
		
		JLabel cell6_4 = new JLabel("");
		cell6_4.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_4);
		
		JLabel cell6_5 = new JLabel("");
		cell6_5.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_5);
		
		JLabel cell6_6 = new JLabel("");
		cell6_6.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_6);
		
		JLabel cell6_7 = new JLabel("");
		cell6_7.setIcon(new ImageIcon(GUIGame.class.getResource("/icons/emptyCell.png")));
		playingGrid.add(cell6_7);
	}

}
