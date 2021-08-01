/*

	This java file is responsible for storing relevant information
	while issuing a book.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.*;

public class IssueBook extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JTextField  t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
	private JButton b1, b2, b3, b4;
	
	public static void main(String[] args) {
		new IssueBook().setVisible(true);
	}
	
	public IssueBook() {
		super("Issue Book - Library Management System");
		setBounds(300, 130, 770, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		JLabel l1 = new JLabel("Book ID");
		l1.setFont(new Font("Calibre", Font.BOLD, 14));
		l1.setForeground(new Color(0, 88, 133));
		l1.setBounds(47, 63, 100, 23);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Calibre", Font.BOLD, 14));
		l2.setForeground(new Color(0, 88, 133));
		l2.setBounds(47, 99, 100, 23);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("ISBN");
		l3.setFont(new Font("Calibre", Font.BOLD, 14));
		l3.setForeground(new Color(0, 88, 133));
		l3.setBounds(47, 131, 100, 23);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Publisher");
		l4.setFont(new Font("Calibre", Font.BOLD, 14));
		l4.setForeground(new Color(0, 88, 133));
		l4.setBounds(47, 165, 100, 23);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Edition");
		l5.setFont(new Font("Calibre", Font.BOLD, 14));
		l5.setForeground(new Color(0, 88, 133));
		l5.setBounds(47, 199, 100, 23);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setFont(new Font("Calibre", Font.BOLD, 14));
		l6.setForeground(new Color(0, 88, 133));
		l6.setBounds(47, 233, 100, 23);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Pages");
		l7.setFont(new Font("Calibre", Font.BOLD, 14));
		l7.setForeground(new Color(0, 88, 133));
		l7.setBounds(47, 267, 100, 23);
		contentPane.add(l7);
		
		t1 = new JTextField();
		t1.setForeground(new Color(49, 79, 79));
		t1.setFont(new Font("Calibre", Font.BOLD, 14));
		t1.setBounds(126, 66, 86, 20);
		contentPane.add(t1);
		
		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		b1.setBounds(234, 59, 100, 30);
		contentPane.add(b1);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setForeground(new Color(49, 79, 79));
		t2.setFont(new Font("Calibre", Font.BOLD, 14));
		t2.setBounds(126, 100, 208, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setForeground(new Color(49, 79, 79));
		t3.setFont(new Font("Calibre", Font.BOLD, 14));
		t3.setBounds(126, 131, 208, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setForeground(new Color(49, 79, 79));
		t4.setFont(new Font("Calibre", Font.BOLD, 14));
		t4.setBounds(126, 168, 208, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setEditable(false);
		t5.setForeground(new Color(49, 79, 79));
		t5.setFont(new Font("Calibre", Font.BOLD, 14));
		t5.setBounds(126, 202, 208, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setForeground(new Color(49, 79, 79));
		t6.setFont(new Font("Calibre", Font.BOLD, 14));
		t6.setBounds(126, 236, 208, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setEditable(false);
		t7.setForeground(new Color(49, 79, 79));
		t7.setFont(new Font("Calibre", Font.BOLD, 14));
		t7.setBounds(126, 270, 208, 20);
		contentPane.add(t7);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2, true), "Fill Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel.setBackground(Color.WHITE);
		panel.setFont(new Font("Calibre", Font.BOLD, 14));
		panel.setBounds(10, 38, 345, 288);
		contentPane.add(panel);
		
		JLabel l8 = new JLabel("Student ID");
		l8.setFont(new Font("Calibre", Font.BOLD, 14));
		l8.setForeground(new Color(0, 88, 133));
		l8.setBounds(384, 64, 100, 23);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("Name");
		l9.setFont(new Font("Calibre", Font.BOLD, 14));
		l9.setForeground(new Color(0, 88, 133));
		l9.setBounds(384, 103, 100, 23);
		contentPane.add(l9);
		
		JLabel l10 = new JLabel("Father's Name");
		l10.setFont(new Font("Calibre", Font.BOLD, 14));
		l10.setForeground(new Color(0, 88, 133));
		l10.setBounds(384, 147, 120, 23);
		contentPane.add(l10);
		
		JLabel l11 = new JLabel("Course");
		l11.setFont(new Font("Calibre", Font.BOLD, 14));
		l11.setForeground(new Color(0, 88, 133));
		l11.setBounds(384, 187, 100, 23);
		contentPane.add(l11);
		
		JLabel l12 = new JLabel("Branch");
		l12.setFont(new Font("Calibre", Font.BOLD, 14));
		l12.setForeground(new Color(0, 88, 133));
		l12.setBounds(384, 233, 100, 23);
		contentPane.add(l12);
		
		JLabel l13 = new JLabel("Year");
		l13.setFont(new Font("Calibre", Font.BOLD, 14));
		l13.setForeground(new Color(0, 88, 133));
		l13.setBounds(384, 284, 100, 23);
		contentPane.add(l13);
		
		JLabel l14 = new JLabel("Semester");
		l14.setFont(new Font("Calibre", Font.BOLD, 14));
		l14.setForeground(new Color(0, 88, 133));
		l14.setBounds(384, 326, 100, 23);
		contentPane.add(l14);
				
		b2 = new JButton("Search");
		b2.addActionListener(this);
		b2.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		b2.setBounds(606, 59, 100, 30);
		contentPane.add(b2);
		
		t8 = new JTextField();
		t8.setForeground(new Color(49, 79, 79));
		t8.setFont(new Font("Calibre", Font.BOLD, 14));
		t8.setBounds(508, 64, 86, 20);
		contentPane.add(t8);
		
		t9 = new JTextField();
		t9.setEditable(false);
		t9.setForeground(new Color(49, 79, 79));
		t9.setFont(new Font("Calibre", Font.BOLD, 14));
		t9.setBounds(508, 106, 208, 20);
		contentPane.add(t9);
		
		t10 = new JTextField();
		t10.setEditable(false);
		t10.setForeground(new Color(49, 79, 79));
		t10.setFont(new Font("Calibre", Font.BOLD, 14));
		t10.setBounds(508, 150, 208, 20);
		contentPane.add(t10);
		
		t11 = new JTextField();
		t11.setEditable(false);
		t11.setForeground(new Color(49, 79, 79));
		t11.setFont(new Font("Calibre", Font.BOLD, 14));
		t11.setBounds(508, 190, 208, 20);
		contentPane.add(t11);
		
		t12 = new JTextField();
		t12.setEditable(false);
		t12.setForeground(new Color(49, 79, 79));
		t12.setFont(new Font("Calibre", Font.BOLD, 14));
		t12.setBounds(508, 236, 208, 20);
		contentPane.add(t12);
		
		t13 = new JTextField();
		t13.setEditable(false);
		t13.setForeground(new Color(49, 79, 79));
		t13.setFont(new Font("Calibre", Font.BOLD, 14));
		t13.setBounds(508, 286, 208, 20);
		contentPane.add(t13);
		
		t14 = new JTextField();
		t14.setEditable(false);
		t14.setForeground(new Color(49, 79, 79));
		t14.setFont(new Font("Calibre", Font.BOLD, 14));
		t14.setBounds(508, 328, 208, 20);
		contentPane.add(t14);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2, true), "Fill Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel2.setBackground(Color.WHITE);
		panel2.setFont(new Font("Calibre", Font.BOLD, 14));
		panel2.setBounds(360, 38, 378, 372);
		contentPane.add(panel2);
		
		JLabel l15 = new JLabel("Date of Issue : ");
		l15.setFont(new Font("Calibre", Font.BOLD, 14));
		l15.setForeground(new Color(0, 88, 133));
		l15.setBounds(20, 340, 120, 24);
		contentPane.add(l15);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(137, 337, 200, 29);
		Date date = new Date();
		dateChooser.setDate(date);
		contentPane.add(dateChooser);
		
		b3 = new JButton("Issue");
		b3.addActionListener(this);
		b3.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		b3.setBackground(new Color(0, 88, 133));
		b3.setForeground(Color.WHITE);
		b3.setBounds(47, 377, 118, 33);
		contentPane.add(b3);
		
		b4 = new JButton("Back");
		b4.addActionListener(this);
		b4.setBorder(new LineBorder(new Color(0, 88, 133), 2, true));
		b4.setBackground(new Color(0, 88, 133));
		b4.setForeground(Color.WHITE);
		b4.setBounds(199, 377, 118, 33);
		contentPane.add(b4);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			
			if(e.getSource() == b1) {
				String sql = "select * from book where book_id = ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, t1.getText());
				ResultSet resultset = statement.executeQuery();
				
				while(resultset.next()) {
					t2.setText(resultset.getString("name"));
					t3.setText(resultset.getString("isbn"));
					t4.setText(resultset.getString("publisher"));
					t5.setText(resultset.getString("edition"));
					t6.setText(resultset.getString("price"));
					t7.setText(resultset.getString("pages"));
				}
				statement.close();
				resultset.close();
			}
			if(e.getSource() == b2) {
				String sql = "select * from student where student_id = ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, t8.getText());
				ResultSet resultset = statement.executeQuery();
				
				while(resultset.next()) {
					t9.setText(resultset.getString("name"));
					t10.setText(resultset.getString("father"));
					t11.setText(resultset.getString("course"));
					t12.setText(resultset.getString("branch"));
					t13.setText(resultset.getString("year"));
					t14.setText(resultset.getString("semester"));
				}
				statement.close();
				resultset.close();
			}

			if(e.getSource() == b3) {
				String sql = "insert into issue_book (book_id, student_id, bname, sname, course, branch, date_of_issue) values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				statement.setString(1, t1.getText());
				statement.setString(2, t8.getText());
				statement.setString(3, t2.getText());
				statement.setString(4, t9.getText());
				statement.setString(5, t11.getText());
				statement.setString(6, t12.getText());
				statement.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
				
				int i = statement.executeUpdate();
				if(i  > 0) {
					JOptionPane.showMessageDialog(null, "Book Issued Successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "Something Went Wrong!");
				}
			}
			
			if(e.getSource() == b4) {
				new Home().setVisible(true);
				setVisible(false);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
