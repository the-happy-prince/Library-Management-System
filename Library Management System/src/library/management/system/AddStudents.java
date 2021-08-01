/*

	This java file is responsible for storing student-details
	into the database.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;


public class AddStudents extends JFrame implements ActionListener{
	private JLabel contentPane;
	private JTextField t1, t2, t3;
	private JComboBox cb1, cb2, cb3, cb4;
	JButton b1, b2;
	
	public static void main(String[] args) {
		new AddStudents().setVisible(true);
	}
	
	// This method generates a random number that can be used as a student_id
	public void random() {
		Random random = new Random();
		t1.setText("" + random.nextInt(1000 + 1));
	}
	
	public AddStudents() {
		super("Add Students");
		setBounds(400, 200, 420, 450);
		setBackground(Color.white);

		contentPane = new JLabel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Student ID");
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibri", Font.BOLD, 14));
		l1.setBounds(64, 63, 102, 22);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setForeground(new Color(0, 88, 133));
		l2.setFont(new Font("Calibri", Font.BOLD, 14));
		l2.setBounds(64, 97, 102, 22);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Father's Name");
		l3.setForeground(new Color(0, 88, 133));
		l3.setFont(new Font("Calibri", Font.BOLD, 14));
		l3.setBounds(64, 130, 102, 22);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Course");
		l4.setForeground(new Color(0, 88, 133));
		l4.setFont(new Font("Calibri", Font.BOLD, 14));
		l4.setBounds(64, 173, 102, 22);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Branch");
		l5.setForeground(new Color(0, 88, 133));
		l5.setFont(new Font("Calibri", Font.BOLD, 14));
		l5.setBounds(64, 209, 102, 22);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Year");
		l6.setForeground(new Color(0, 88, 133));
		l6.setFont(new Font("Calibri", Font.BOLD, 14));
		l6.setBounds(64, 242, 102, 22);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Semester");
		l7.setForeground(new Color(0, 88, 133));
		l7.setFont(new Font("Calibri", Font.BOLD, 14));
		l7.setBounds(64, 275, 102, 22);
		contentPane.add(l7);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBackground(Color.WHITE);
		t1.setForeground(new Color(47, 79, 79));
		t1.setFont(new Font("Calibri", Font.BOLD, 14));
		t1.setColumns(10);
		t1.setBounds(184, 64, 154, 20);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(new Color(47, 79, 79));
		t2.setFont(new Font("Calibri", Font.BOLD, 14));
		t2.setColumns(10);
		t2.setBounds(184, 100, 154, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(new Color(47, 79, 79));
		t3.setFont(new Font("Calibri", Font.BOLD, 14));
		t3.setColumns(10);
		t3.setBounds(184, 133, 154, 20);
		contentPane.add(t3);
		
		cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"B.A.", "B.Sc.", "B.Com.", "B.C.A.", "B.B.A."}));
		cb1.setForeground(new Color(47, 79, 79));
		cb1.setFont(new Font("Calibri", Font.BOLD, 14));
		cb1.setBounds(186, 173, 154, 20);
		contentPane.add(cb1);
		
		cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"Art", "Science", "Technology", "Finance", "Social Science"}));
		cb2.setForeground(new Color(47, 79, 79));
		cb2.setFont(new Font("Calibri", Font.BOLD, 14));
		cb2.setBounds(186, 211, 154, 20);
		contentPane.add(cb2);
		
		cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"NA", "First", "Second", "Third", "Fourth"}));
		cb3.setForeground(new Color(47, 79, 79));
		cb3.setFont(new Font("Calibri", Font.BOLD, 14));
		cb3.setBounds(186, 244, 154, 20);
		contentPane.add(cb3);
		
		cb4 = new JComboBox();
		cb4.setModel(new DefaultComboBoxModel(new String[] {"NA", "First", "Second", "Third", "Fourth", "Fifth", "Sixth"}));
		cb4.setForeground(new Color(47, 79, 79));
		cb4.setFont(new Font("Calibri", Font.BOLD, 14));
		cb4.setBounds(186, 277, 154, 20);
		contentPane.add(cb4);
		
		b1 = new JButton("ADD");
		b1.addActionListener(this);
		b1.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		b1.setBackground(new Color(0, 88, 133));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Calibri", Font.BOLD, 15));
		b1.setBounds(64, 321, 111, 33);
		contentPane.add(b1);
		
		b2 = new JButton("BACK");
		b2.addActionListener(this);
		b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		b2.setBackground(new Color(0, 88, 133));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Calibri", Font.BOLD, 15));
		b2.setBounds(218, 321, 111, 33);
		contentPane.add(b2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(19, 116, 185), 2), "Add Students", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(19, 116, 185)));
		panel.setBounds(27, 19, 350, 360);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);

		// Invoking random method
		random();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			if(e.getSource() == b1) {
				String sql = "insert into student (student_id, name, father, course, branch, year, semester) values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1, t1.getText());
				statement.setString(2, t2.getText());
				statement.setString(3, t3.getText());
				statement.setString(4, (String)cb1.getSelectedItem());
				statement.setString(5, (String)cb2.getSelectedItem());
				statement.setString(6, (String)cb3.getSelectedItem());
				statement.setString(7, (String)cb4.getSelectedItem());
				
				int i = statement.executeUpdate();
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "Successfully Added");
					this.setVisible(false);
					new Home().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Something Went Wrong!");
					t1.setText("");
					t2.setText("");
					t3.setText("");
				}
			}
			
			if(e.getSource() == b2) {
				setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
