/*

	This java file is responsible for displaying the current
	features for the application as well as what new features have been added.

*/

package library.management.system;

import java.awt.*;
import javax.swing.*;

public class ReadMe extends JFrame{

	private JPanel contentPane;
	
	public ReadMe() {
		super("Read Me - Library Management System");
		setBounds(350, 50, 700, 600);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBackground(new Color(0, 88, 133));
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 40, 1400, 120);
		contentPane.add(bgPanel);
		
		JLabel l1 = new JLabel("Library");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Calibre", Font.BOLD, 30));
		l1.setBounds(20, 10, 200, 50);
		bgPanel.add(l1);
		
		JLabel l2 = new JLabel("Management System");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Calibre", Font.BOLD, 34));
		l2.setBounds(20, 60, 400, 50);
		bgPanel.add(l2);
		
		JTextArea textArea = new JTextArea("Library Management System is a multiuser user-friendly software that can make your job easier. \n"
				+ "It consists of many functionality that are listed below - \n"
				+ "\n1. Store books into the database"
				+ "\n2. Check statistics of issue and return books"
				+ "\n3. Add students information"
				+ "\n4. Issue and return books"
				+ "\n5. Create multiple account for librarians"
				+ "\n6. Minimalistic User Interface");
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Calibre", Font.TRUETYPE_FONT, 13));
		textArea.setBounds(20,  190,  600,  190);
		contentPane.add(textArea);
		
		JLabel l3 = new JLabel("***We hope you find our software useful and enjoyable.***");
		l3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		l3.setBounds(60, 500, 600, 40);
		l3.setForeground(new Color(0, 88, 133));
		contentPane.add(l3);
                
		JLabel l4 = new JLabel("What's new?");
		l4.setFont(new Font("Calibri", Font.BOLD, 16));
		l4.setForeground(new Color(0, 88, 133));
		l4.setBounds(20, 380, 600, 40);
		contentPane.add(l4);
                
		JLabel l5 = new JLabel("<HTML>1. Added Date and Time <br>2. Autoselect system date while issuing and returning book<br>3. Export data to PDF</HTML>");
		l5.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 13));
		l5.setBounds(20, 405, 600, 70);
		contentPane.add(l5);
	}
	
	public static void main(String[] args) {
		new ReadMe().setVisible(true);
	}

}
