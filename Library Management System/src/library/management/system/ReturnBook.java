/*

	This java file is responsible for storing relevant information
	while returning a book.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class ReturnBook extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton b1, b2, b3;
	private JDateChooser dateChooser;
	
	public static void main(String[] args) {
		new ReturnBook().setVisible(true);
	}
	
	public ReturnBook() {
		super("Return Book - Library Management System");
		setBounds(350, 200, 617, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Book ID");
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibri", Font.BOLD, 14));
		l1.setBounds(30, 52, 87, 24);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Student ID");
		l2.setForeground(new Color(0, 88, 133));
		l2.setFont(new Font("Calibri", Font.BOLD, 14));
		l2.setBounds(243, 52, 87, 24);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Title");
		l3.setForeground(new Color(0, 88, 133));
		l3.setFont(new Font("Calibri", Font.BOLD, 14));
		l3.setBounds(30, 98, 71, 24);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Name");
		l4.setForeground(new Color(0, 88, 133));
		l4.setFont(new Font("Calibri", Font.BOLD, 14));
		l4.setBounds(300, 98, 71, 24);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Course");
		l5.setForeground(new Color(0, 88, 133));
		l5.setFont(new Font("Calibri", Font.BOLD, 14));
		l5.setBounds(30, 143, 87, 24);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Branch");
		l6.setForeground(new Color(0, 88, 133));
		l6.setFont(new Font("Calibri", Font.BOLD, 14));
		l6.setBounds(303, 143, 68, 24);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Date of Issue");
		l7.setForeground(new Color(0, 88, 133));
		l7.setFont(new Font("Calibri", Font.BOLD, 14));
		l7.setBounds(30, 188, 105, 29);
		contentPane.add(l7);
		
		JLabel l8 = new JLabel("Date of Return");
		l8.setForeground(new Color(0, 88, 133));
		l8.setFont(new Font("Calibri", Font.BOLD, 14));
		l8.setBounds(30, 234, 118, 29);
		contentPane.add(l8);

		tf1 = new JTextField();
		tf1.setForeground(new Color(0, 88, 133));
		tf1.setFont(new Font("Calibri", Font.BOLD, 14));
		tf1.setBounds(100, 56, 105, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
	
		tf2 = new JTextField();
		tf2.setForeground(new Color(0, 88, 133));
		tf2.setFont(new Font("Calibri", Font.BOLD, 14));
		tf2.setBounds(340, 56, 93, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
	
		b1 = new JButton("SEARCH");
		b1.addActionListener(this);
		b1.setBounds(443, 52, 105, 29);
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);
	
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setForeground(new Color(0, 100, 0));
		tf3.setBackground(Color.WHITE);
		tf3.setFont(new Font("Calibri", Font.BOLD, 13));
		tf3.setBounds(100, 102, 162, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
	
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBackground(Color.WHITE);
		tf4.setForeground(new Color(0, 100, 0));
		tf4.setFont(new Font("Calibri", Font.BOLD, 13));
		tf4.setColumns(10);
		tf4.setBounds(369, 102, 179, 20);
		contentPane.add(tf4);
	
		tf5 = new JTextField();
		tf5.setEditable(false);
		tf5.setBackground(Color.WHITE);
		tf5.setForeground(new Color(0, 100, 0));
		tf5.setFont(new Font("Calibri", Font.BOLD, 13));
		tf5.setColumns(10);
		tf5.setBounds(100, 147, 162, 20);
		contentPane.add(tf5);
	
		tf6 = new JTextField();
		tf6.setForeground(new Color(0, 100, 0));
		tf6.setFont(new Font("Calibri", Font.BOLD, 13));
		tf6.setEditable(false);
		tf6.setBackground(Color.WHITE);
		tf6.setColumns(10);
		tf6.setBounds(369, 147, 179, 20);
		contentPane.add(tf6);
	
		tf7 = new JTextField();
		tf7.setForeground(new Color(0, 100, 0));
		tf7.setFont(new Font("Calibri", Font.BOLD, 13));
		tf7.setEditable(false);
		tf7.setBackground(Color.WHITE);
		tf7.setColumns(10);
		tf7.setBounds(145, 194, 137, 20);
		contentPane.add(tf7);
	
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		dateChooser.setBounds(145, 234, 137, 29);
		Date date = new Date();
		dateChooser.setDate(date);
		contentPane.add(dateChooser);
	
		b2 = new JButton("RETURN");
		b2.addActionListener(this);
		b2.setFont(new Font("Calibri", Font.BOLD, 15));
		b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		b2.setBounds(369, 200, 149, 30);
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		contentPane.add(b2);
	
		b3 = new JButton("BACK");
		b3.addActionListener(this);
		b3.setFont(new Font("Calibri", Font.BOLD, 15));
		b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		b3.setBounds(369, 240, 149, 30);
		b3.setBackground(new Color(0, 88, 133));
		b3.setForeground(Color.WHITE);
		contentPane.add(b3);
	
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(19, 116, 185), 2, true), "Return-Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(19, 116, 185)));
		panel.setBounds(10, 24, 569, 269);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
	}
	
	public void deleteRecord() {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			String sql = "delete from issue_book where book_id = ?";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			statement.setString(1, tf1.getText());
			
			int i = statement.executeUpdate();
			if(i > 0) {
				JOptionPane.showMessageDialog(null, "Book has been returned!");
			}else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong!");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			
			if(e.getSource() == b1) {
				String sql = "select * from issue_book where book_id = ? and student_id = ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1, tf1.getText());
				statement.setString(2, tf2.getText());
				
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					tf3.setText(resultSet.getString("bname"));
					tf4.setText(resultSet.getString("sname"));
					tf5.setText(resultSet.getString("course"));
					tf6.setText(resultSet.getString("branch"));
					tf7.setText(resultSet.getString("date_of_issue"));
				}
			}
			
			if(e.getSource() == b2) {
				
				String sql = "insert into return_book (book_id, student_id, bname, sname, course, branch, date_of_issue, date_of_return) values (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, tf1.getText());
				statement.setString(2, tf2.getText());
				statement.setString(3, tf3.getText());
				statement.setString(4, tf4.getText());
				statement.setString(5, tf5.getText());
				statement.setString(6, tf6.getText());
				statement.setString(7, tf7.getText());
				statement.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
				
				int i = statement.executeUpdate();
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "Procesing");
					deleteRecord();
				}
				else {
					JOptionPane.showMessageDialog(null, "Something Went Wrong!");
				}
			}
			if(e.getSource() == b3) {
				new Home().setVisible(true);
				setVisible(false);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
