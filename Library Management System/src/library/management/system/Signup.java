/*

	This java file is responsible for creating 
	new account for the librarian so they can do their work.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField textField1, textField2, textField3, textField4;
	private JButton b1, b2;
	private JComboBox combobox;
	
	public static void main(String[] args) {
		new Signup().setVisible(true);
	}
	
	public Signup() {
		super("Create Account - Library Management System");
		setBounds(360, 200, 560, 420);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username   : ");
		usernameLabel.setForeground(new Color(0, 88, 133));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(99, 86, 92, 24);
		contentPane.add(usernameLabel);
		
		JLabel nameLabel = new JLabel("Name   : ");
		nameLabel.setForeground(new Color(0, 88, 133));
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(99, 123, 92, 24);
		contentPane.add(nameLabel);
		
		JLabel passwordLabel = new JLabel("Password   : ");
		passwordLabel.setForeground(new Color(0, 88, 133));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(99, 160, 92, 24);
		contentPane.add(passwordLabel);
		
		JLabel securityQue = new JLabel("Security Question : ");
		securityQue.setForeground(new Color(0, 88, 133));
		securityQue.setFont(new Font("Tahoma", Font.BOLD, 14));
		securityQue.setBounds(99, 197, 140, 24);
		contentPane.add(securityQue);
		
		combobox = new JComboBox();
		combobox.setModel(new DefaultComboBoxModel(new String[] {"Your Nickname?", "Your Lucky Number?", "Your Birthplace?", "Your Favourite Teacher?"}));
		combobox.setBounds(265, 202, 170, 20);
		combobox.setBackground(Color.WHITE);
		contentPane.add(combobox);
		
		JLabel answerLabel = new JLabel("Answer   : ");
		answerLabel.setForeground(new Color(0, 88, 133));
		answerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		answerLabel.setBounds(99, 234, 92, 24);
		contentPane.add(answerLabel);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(265, 91, 140, 20);
		contentPane.add(textField1);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(265, 128, 140, 20);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(265, 165, 140, 20);
		contentPane.add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(265, 239, 140, 20);
		contentPane.add(textField4);
		
		b1 = new JButton("Create");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b1.setBounds(140, 289, 100, 30);
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBounds(300, 289, 100, 30);
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		contentPane.add(b2);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 88, 133));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel.setBounds(31, 46, 476, 296);
		contentPane.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			EstablishConnection establishConnection2 = new EstablishConnection();
			
			if(ae.getSource() == b1) {
				String sql = "insert into account (username, name, password, sec_que, sec_ans) values (?, ?, ?, ?, ?)";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, textField1.getText());
				statement.setString(2, textField2.getText());
				statement.setString(3, textField3.getText());
				statement.setString(4, (String)combobox.getSelectedItem());
				statement.setString(5, textField4.getText());
				
				String sql2 = "select * from account where username = ?";
				PreparedStatement statement2 = establishConnection2.connection.prepareStatement(sql2);
				statement2.setString(1, textField1.getText());
				ResultSet resultSet = statement2.executeQuery();
				String tempString = "";
				if (resultSet.next()) {
					tempString = resultSet.getString("username");
				}
				
				if(textField1.getText().equals(tempString)) {
					JOptionPane.showMessageDialog(null, "Username is already taken!");
					textField1.setText("");
				}
				
				
				int i = statement.executeUpdate();
				
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Successfully Created");
                                        new LoginUser().setVisible(true);
                                        this.setVisible(false);
				}
				
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
			}
			if(ae.getSource() == b2) {
				this.setVisible(false);
				new LoginUser().setVisible(true);
			}
			
		} catch (Exception e) {}
	}
}
