/*

	This java file is responsible for displaying the
	first window, which contains an option for launching the application.

*/

package library.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{
	JPanel p1;
	JLabel l1, introLabel, introLabel2;
	JButton b1;
	
	public LibraryManagementSystem() {
		super("Library Management System");
		setBounds(160, 70, 1040, 600);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setBounds(0, 0, 1000, 500);
		p1.setLayout(null);
		setContentPane(p1);
                
		introLabel = new JLabel("A simple and minimalistic application for");
		introLabel.setBounds(150, 50, 700, 80);
		introLabel.setForeground(new Color(0, 88, 133));
		introLabel.setFont(new Font("", Font.BOLD, 20));
		p1.add(introLabel);
		
		introLabel2 = new JLabel("managing your library work with ease.");
		introLabel2.setBounds(150, 70, 700, 80);
		introLabel2.setForeground(new Color(0, 88, 133));
		introLabel2.setFont(new Font("", Font.BOLD, 20));
		p1.add(introLabel2);
		
		l1 = new JLabel("");
		b1 = new JButton("LAUNCH");
		b1.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		b1.setBackground(Color.WHITE);
		b1.setForeground(new Color(0, 88, 133));
		b1.setBounds(800, 80, 100, 50);
		p1.add(b1);
		b1.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/start.png"));
		Image i11 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
		ImageIcon i111 = new ImageIcon(i11);	
		l1 = new JLabel(i111);
		l1.setBounds(50, 0, 900, 500);
		p1.add(l1);
	}
	
	public static void main(String[] args) {
		new LibraryManagementSystem().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			new LoginUser().setVisible(true);
			setVisible(false);
		}
		
	}

}
