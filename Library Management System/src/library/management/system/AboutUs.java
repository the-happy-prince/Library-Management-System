/*

	This java file is responsible for displaying the contact details
	of the developer.

*/

package library.management.system;

import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	
	public static void main(String[] args) {
		new AboutUs().setVisible(true);
	}
	
	public AboutUs() {
		super("About - Developer");
		setIconImage(Toolkit.getDefaultToolkit().getImage("library/management/system/second.png"));
		setBackground(Color.WHITE);
		setBounds(350, 150, 700, 500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("New Label");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/logo.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		l1 = new JLabel(i3);
		l1.setBounds(450, 40, 210, 210);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Library");
		l2.setForeground(new Color(0, 88, 133));
		l2.setFont(new Font("Calibre", Font.BOLD, 34));
		l2.setBounds(160, 40, 150, 55);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Management System");
		l3.setForeground(new Color(0, 88, 133));
		l3.setFont(new Font("Calibre", Font.BOLD, 34));
		l3.setBounds(70, 90, 405, 45);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Developer Details");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Calibre", Font.BOLD, 14));
		l4.setBounds(160, 130, 600, 40);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Prince Raj");
		l5.setForeground(new Color(0, 88, 133));
		l5.setFont(new Font("Calibre", Font.BOLD, 20));
		l5.setBounds(20, 170, 600, 40);
		contentPane.add(l5);
		
		JTextArea textArea = new JTextArea("For any issue or addding new feature\nContact me -\n\n"
				+ "Telegram         :   @the_happy_prince\n"
				+ "Email                 :   princeraj@tuta.io\n"
                                + "WhatsApp        :  +91-9798073195");
		textArea.setEditable(false);
		textArea.setForeground(new Color(0, 88, 133));
		textArea.setFont(new Font("Calibre", Font.BOLD, 12));
		textArea.setBounds(20,  210,  600,  200);
		contentPane.add(textArea);
		
	}
}
