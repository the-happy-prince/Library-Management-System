/*

	This java file is responsible for displaying book-details
	from the database. It also gives an option to remove a book.

*/

package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class BookDetails extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTable table;
	private JTextField searchField;
	private JButton b1, b2, b3;
	
	public static void main(String[] args) {
		new BookDetails().setVisible(true);
	}
	
	// This method selects book from the database and sets to the table
	public void book() {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			String sql = "select * from book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(resultset));
			resultset.close();
			statement.close();
			establishConnection.connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BookDetails() {
		super("Book Details - Library Management System");
		setBounds(250, 200, 860, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 133, 772, 282);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				searchField.setText(table.getModel().getValueAt(row, 1).toString());
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
		
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Calibri", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		b1 = new JButton("SEARCH");
		b1.addActionListener(this);
		b1.setBorder(new LineBorder(new Color(0, 88, 133), 2, false));
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/search.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		b1.setIcon(i3);
		b1.setBackground(Color.WHITE);
		b1.setForeground(new Color(0, 88, 133));
		b1.setFont(new Font("Calibri", Font.BOLD, 14));
		b1.setBounds(530, 89, 130, 33);
		contentPane.add(b1);
		
		b2 = new JButton("DELETE");
		b2.addActionListener(this);
		b2.setBorder(new LineBorder(new Color(0, 88, 133), 2, false));
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/delete.png"));
		Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon i6 = new ImageIcon(i5);
		b2.setIcon(i6);
		b2.setBackground(Color.WHITE);
		b2.setForeground(new Color(0, 88, 133));
		b2.setFont(new Font("Calibri", Font.BOLD, 14));
		b2.setBounds(680, 89, 130, 33);
		contentPane.add(b2);
		
		searchField = new JTextField();
		searchField.setBackground(Color.BLUE);
		searchField.setBorder(new LineBorder(new Color(0, 88, 133), 2, false));
		searchField.setForeground(new Color(0, 88, 133));
		searchField.setBackground(Color.WHITE);
		searchField.setFont(new Font("Calibri", Font.PLAIN, 16));
		searchField.setColumns(10);
		searchField.setBounds(135, 89, 357, 33);
		contentPane.add(searchField);
		
		JLabel l1 = new JLabel("BOOK DETAILS");
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibri", Font.BOLD, 30));
		l1.setBounds(320, 15, 400, 47);
		contentPane.add(l1);

		JLabel l2 = new JLabel("BACK");
		l2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

		l2.setFont(new Font("Calibri", Font.BOLD, 14));
		l2.setForeground(new Color(0, 88, 133));
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/back.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon i9 = new ImageIcon(i8);
		l2.setIcon(i9);
		l2.setBounds(45, 89, 72, 33);
		add(l2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2, true), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(28, 54, 793, 368);
		contentPane.add(panel);

		// Invoking book method
		book();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			EstablishConnection establishConnection = new EstablishConnection();
			
			if(e.getSource() == b1) {
				String sql = "select * from book where concat (name, book_id) like ?";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				statement.setString(1,  "%" + searchField.getText() + "%");
				ResultSet resultset = statement.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(resultset));
				resultset.close();
				statement.close();
			}
			
			if(e.getSource() == b2) {
				String sql = "delete from book where name = '" + searchField.getText() + "'";
				PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.NO_OPTION) {
					
				}else if (response == JOptionPane.YES_OPTION) {
					int i = statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted!");
					new BookDetails().setVisible(true);
					setVisible(false);
				}else if (response == JOptionPane.CLOSED_OPTION) {
					
				}
				statement.close();
			}
			establishConnection.connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
