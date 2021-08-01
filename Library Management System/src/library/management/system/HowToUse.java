/*

	This java file is responsible for giving
	a short and simple manual about how to use this application.

*/

package library.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HowToUse extends JFrame{
	private JPanel contentPane;
	
	public HowToUse() {
		super("How to use? - Library Management System");
		setBounds(350, 150, 820, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBackground(new Color(0, 88, 133));
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 40, 1400, 50);
		contentPane.add(bgPanel);
		
		JLabel l1 = new JLabel("How to use me?");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Calibre", Font.TRUETYPE_FONT |Font.BOLD, 20));
		l1.setBounds(10, 0, 200, 50);
		bgPanel.add(l1);

		JTextArea textArea = new JTextArea("After launching the home window you will get a menu consist of three manu items, and 6 different options in order to manage your "
				+ "\nlibrary work efficiently. \n"
				+ "\nI am here to help you out using me with ease -\n\n"
				+ "\n1. To store new Books - Click on ADD BOOKS button and store relevant data"
				+ "\n2. See statistics - Click on STATISTICS button"
				+ "\n3. Add new students - Click on ADD STUDENT button and store relevant data"
				+ "\n4. Issue books to students - Click on ISSUE BOOK button and store relevant data"
				+ "\n5. Get books back - Click on RETURN BOOK button and fill the book and student id, then click on RETURN button"
				+ "\n6. See book and student details - Click on RECORD tab in the menu, and select desired option"
				+ "\n7. Export your data to PDF - ");
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Calibre", Font.TRUETYPE_FONT, 13));
		textArea.setBounds(20,  110,  800,  200);
		contentPane.add(textArea);
		
	}
	
	public static void main(String[] args) {
		new HowToUse().setVisible(true);
	}
}
