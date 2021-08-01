/*

	This java file is responsible for displaying
	statistics of issued books as well as returned books.

*/

package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Statistics extends JFrame{
	
	private JPanel contentPane;
	private JTable table1, table2;
	
	public static void main(String[] args) {
		new Statistics().setVisible(true);
	}
	
	// This method prints the rows from the issue_book table
	public void issueBook() {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			String sql = "SELECT * FROM issue_book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(resultSet));
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method prints the rows from the return_book table
	public void returnBook() {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			String sql = "SELECT * FROM return_book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(resultSet));
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public Statistics() {
		super("Statistics Window");
		setBounds(270,  100,  810,  594);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 51, 708, 217);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setBackground(Color.WHITE);
		table1.setForeground(new Color(0, 88, 133));
		table1.setFont(new Font("Calibre", Font.BOLD, 14));
		scrollPane.setViewportView(table1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2, true), "Issued Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel.setForeground(new Color(0, 88, 133));
		panel.setBounds(26,  36,  737,  240);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel l1 = new JLabel("BACK");
		l1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibre", Font.BOLD, 16));
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/back.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		l1.setIcon(i3);
		l1.setBounds(690,  5,  200, 30);
		contentPane.add(l1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(40, 316, 708, 217);
		contentPane.add(scrollPane2);
		
		table2 = new JTable();
		table2.setBackground(Color.WHITE);
		table2.setForeground(new Color(0, 88, 133));
		table2.setFont(new Font("Calibre", Font.BOLD, 14));
		scrollPane2.setViewportView(table2);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2, true), "Returned Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel2.setForeground(new Color(0, 88, 133));
		panel2.setBounds(26,  299,  737,  240);
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2);

		issueBook();	// Invoking issueBook method
		returnBook();	// Invoking returnBook method
	}

}
