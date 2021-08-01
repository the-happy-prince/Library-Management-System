/*

	This java file is responsible for displaying the
	login window for the librarians as well as a way to recover their password.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.text.StyleConstants;

public class LoginUser extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button1, button2, button3;
	
	public LoginUser() {
		super("Login - Library Management System");
		setBackground(new Color(169, 169, 169));
		setBounds(370, 200, 600, 400);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel headLabel = new JLabel("Library Management System");
		headLabel.setBounds(110, 60, 480, 60);
		headLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		headLabel.setForeground(new Color(0, 88, 133));
		panel.add(headLabel);
		
		JLabel l1 = new JLabel("Username: ");
		l1.setBounds(170, 140, 95, 24);
		l1.setFont(new Font("Calibri", Font.BOLD, 14));
		panel.add(l1);
		
		JLabel l2 = new JLabel("Password: ");
		l2.setBounds(170, 165, 95, 24);
		l2.setFont(new Font("Calibri", Font.BOLD, 14));
		panel.add(l2);
		
		textField = new JTextField();
		textField.setBounds(290, 140, 157, 20);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 165, 157, 20);
		panel.add(passwordField);
		
		button1 = new JButton("Sign In");
		button1.addActionListener(this);
		button1.setForeground(Color.WHITE);
		button1.setBackground(new Color(0, 88, 133));
		button1.setBounds(175, 220, 270, 30);
		panel.add(button1);
		
		button2 = new JButton("Register");
		button2.addActionListener(this);
		button2.setForeground(Color.WHITE);
		button2.setBackground(new Color(66, 183, 42));
		button2.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		button2.setBounds(480, 5, 113, 30);
		panel.add(button2);
                
		JPanel bgPanel = new JPanel();
		bgPanel.setBackground(new Color(0, 88, 133));
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1400, 40);
		panel.add(bgPanel);
		
		JLabel paneLabel = new JLabel("RDS College, Muzaffarpur");
		paneLabel.setForeground(Color.WHITE);
		paneLabel.setFont(new Font("Calibre", Font.TRUETYPE_FONT |Font.BOLD, 18));
		paneLabel.setBounds(10, 0, 300, 40);
		bgPanel.add(paneLabel);
		
		button3 = new JButton("<HTML><u>lost account access?</u></HTML>");
		button3.addActionListener(this);
		button3.setBackground(Color.WHITE);
		button3.setForeground(Color.BLACK);
		button3.setBorder(null);
		button3.setBounds(210, 250, 179, 39);
		panel.add(button3);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == button1) {
			Boolean status = false;
			try {
				EstablishConnection establishConnection = new EstablishConnection();
				String sql = "Select * from account where username = ? and password = ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, textField.getText());
				statement.setString(2, passwordField.getText());
				
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()) {
					this.setVisible(false);
					new Loading().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Credentials!");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource() == button2) {
			setVisible(false);
			Signup su = new Signup();
			su.setVisible(true);
		}
		if(ae.getSource() == button3) {
			setVisible(false);
			Forgot forgot = new Forgot();
			forgot.setVisible(true);
		}
	}
	public static void main(String[] args) {
		new LoginUser().setVisible(true);
	}
}
