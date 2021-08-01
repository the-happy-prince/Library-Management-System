/*

	This java file is responsible for storing books
	into the database.

*/

package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.*;

public class AddBooks extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5, t6;
	private JComboBox comboBox;
	private JButton b1, b2;
	
	public static void main(String[] args) {
		new AddBooks().setVisible(true);
	}
	
	// This method generates a random number that can be used as the book_id
	public void random() {
		Random random = new Random();
		t1.setText("" + random.nextInt(1000 + 1));
	}
	
	public AddBooks() {
		super("Add Books");
		setBounds(450, 200, 480, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Book id");
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibri", Font.BOLD, 14));
		l1.setBounds(73, 51, 90, 22);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setForeground(new Color(0, 88, 133));
		l2.setFont(new Font("Calibri", Font.BOLD, 14));
		l2.setBounds(73, 84, 90, 22);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("ISBN");
		l3.setForeground(new Color(0, 88, 133));
		l3.setFont(new Font("Calibri", Font.BOLD, 14));
		l3.setBounds(73, 117, 90, 22);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Publisher");
		l4.setForeground(new Color(0, 88, 133));
		l4.setFont(new Font("Calibri", Font.BOLD, 14));
		l4.setBounds(73, 150, 90, 22);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Edition");
		l5.setForeground(new Color(0, 88, 133));
		l5.setFont(new Font("Calibri", Font.BOLD, 14));
		l5.setBounds(73, 183, 90, 22);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setForeground(new Color(0, 88, 133));
		l6.setFont(new Font("Calibri", Font.BOLD, 14));
		l6.setBounds(73, 216, 90, 22);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Pages");
		l7.setForeground(new Color(0, 88, 133));
		l7.setFont(new Font("Calibri", Font.BOLD, 14));
		l7.setBounds(73, 249, 90, 22);
		contentPane.add(l7);
		
		b1 = new JButton("ADD");
		b1.addActionListener(this);
		b1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 88, 133)), null));
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Calibri", Font.BOLD, 15));
		b1.setBounds(102, 300, 100, 33);
		contentPane.add(b1);
		
		b2 = new JButton("BACK");
		b2.addActionListener(this);
		b2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 88, 133), 2), null));
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Calibri", Font.BOLD, 15));
		b2.setBounds(232, 300, 100, 33);
		contentPane.add(b2);
		
		t1 = new JTextField();
		t1.setFont(new Font("Calibri", Font.BOLD, 14));
		t1.setEditable(false);
		t1.setBackground(Color.WHITE);
		t1.setForeground(new Color(3, 69, 183));
		t1.setColumns(10);
		t1.setBounds(169, 54, 198, 20);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Calibri", Font.BOLD, 14));
		t2.setColumns(10);
		t2.setBounds(169, 87, 198, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(Color.BLACK);
		t3.setFont(new Font("Calibri", Font.BOLD, 14));
		t3.setColumns(10);
		t3.setBounds(169, 120, 198, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setForeground(Color.BLACK);
		t4.setFont(new Font("Calibri", Font.BOLD, 14));
		t4.setColumns(10);
		t4.setBounds(169, 153, 198, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setForeground(Color.BLACK);
		t5.setFont(new Font("Calibri", Font.BOLD, 14));
		t5.setColumns(10);
		t5.setBounds(169, 219, 198, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setForeground(Color.BLACK);
		t6.setFont(new Font("Calibri", Font.BOLD, 14));
		t6.setColumns(10);
		t6.setBounds(169, 252, 198, 20);
		contentPane.add(t6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(169, 186, 198, 20);
		comboBox.setBackground(Color.white);
		comboBox.setForeground(Color.BLACK);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(19, 116, 185), 2), "Add Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(19, 116, 185)));
		panel.setBounds(27, 19, 390, 344);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		// Invoking random method
		random();
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			
			if(ae.getSource() == b1) {
				String sql = "insert into book (book_id, name, isbn, publisher, edition, price, pages) values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1, t1.getText());
				statement.setString(2, t2.getText());
				statement.setString(3, t3.getText());
				statement.setString(4, t4.getText());
				statement.setString(5, (String)comboBox.getSelectedItem());
				statement.setString(6, t5.getText());
				statement.setString(7, t6.getText());
				
				int i = statement.executeUpdate();
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "Successfully Added");
				}
				else {
					JOptionPane.showMessageDialog(null, "Something Went Wrong!");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					statement.close();
				}
				
			}
			
			if(ae.getSource() == b2) {
				setVisible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
