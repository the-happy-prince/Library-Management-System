/*

	This java file is responsible for recovering password
	in the case of losing access to the account.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Forgot extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5;
	private JButton b1, b2, b3;
	
	public static void main(String[] args) {
		new Forgot().setVisible(true);
	}
	
	public Forgot(){
		super("Forgot Password? - Library Management System");
		setBounds(380, 120, 620, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Calibri", Font.BOLD, 15));
		l1.setForeground(new Color(0, 88, 133));
		l1.setBounds(80, 83, 87, 29);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Calibri", Font.BOLD, 15));
		l2.setForeground(new Color(0, 88, 133));
		l2.setBounds(80, 122, 75, 21);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Your Security Question");
		l3.setFont(new Font("Calibri", Font.BOLD, 15));
		l3.setForeground(new Color(0, 88, 133));
		l3.setBounds(80, 154, 200, 27);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Answer");
		l4.setFont(new Font("Calibri", Font.BOLD, 15));
		l4.setForeground(new Color(0, 88, 133));
		l4.setBounds(80, 192, 104, 21);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Password");
		l5.setFont(new Font("Calibri", Font.BOLD, 15));
		l5.setForeground(new Color(0, 88, 133));
		l5.setBounds(80, 224, 104, 21);
		contentPane.add(l5);
		
		t1 = new JTextField();
		t1.setFont(new Font("Calibri", Font.PLAIN, 14));
		t1.setForeground(new Color(105, 105, 105));
		t1.setBounds(277, 88, 139, 20);
		t1.setColumns(10);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setFont(new Font("Calibri", Font.BOLD, 14));
		t2.setBackground(Color.WHITE);
		t2.setForeground(new Color(165, 62, 62));
		t2.setBounds(277, 123, 139, 20);
		t2.setColumns(10);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setFont(new Font("Calibri", Font.BOLD, 14));
		t3.setBackground(Color.WHITE);
		t3.setForeground(Color.BLACK);
		t3.setBounds(277, 156, 221, 20);
		t3.setColumns(10);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Calibri", Font.BOLD, 14));
		t4.setForeground(new Color(139, 79, 79));
		t4.setBounds(277, 193, 139, 20);
		t4.setColumns(10);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Calibri", Font.BOLD, 14));
		t5.setForeground(new Color(139, 79, 79));
		t5.setBounds(277, 225, 139, 20);
		t5.setColumns(10);
		contentPane.add(t5);
		
		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setFont(new Font("Calibri", Font.BOLD, 11));
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		b1.setBounds(420, 83, 80, 29);
		contentPane.add(b1);
		
		b2 = new JButton("Retrieve");
		b2.addActionListener(this);
		b2.setFont(new Font("Calibri", Font.BOLD, 11));
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		b2.setBounds(420, 186, 85, 29);
		contentPane.add(b2);
		
		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setFont(new Font("Calibri", Font.BOLD, 11));
		b3.setBackground(new Color(0, 88, 133));
		b3.setForeground(Color.WHITE);
		b3.setBounds(233, 270, 101, 29);
		contentPane.add(b3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder((new Color(0, 88, 133)), 2), "Get Your Password", TitledBorder.LEADING, TitledBorder.TOP, null, (new Color(0, 88, 133))));
		panel.setBounds(47, 45, 500,281);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			if(ae.getSource() == b1) {
				String sql = "Select * from account where username = ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1, t1.getText());
				ResultSet resultset = statement.executeQuery();
				
				while(resultset.next()) {
					t2.setText(resultset.getString("name"));
					t3.setText(resultset.getString("sec_que"));
				}
			}
			
			if(ae.getSource() == b2) {
				String sql = "Select * from account where sec_ans = ?";
				String tempString = "";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1, t4.getText());
				ResultSet resultset = statement.executeQuery();
				
				while (resultset.next()) {
					t5.setText(resultset.getString("password"));
					tempString = resultset.getString("sec_ans");
				}
				
				if(!t4.getText().equals(tempString)) {
					JOptionPane.showMessageDialog(null, "Incorrect Answer");
				}
	
			}
			
			if(ae.getSource() == b3) {
				this.setVisible(false);
				new LoginUser().setVisible(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
