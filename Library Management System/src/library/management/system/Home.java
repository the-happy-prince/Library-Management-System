/*

	This java file is responsible for providing users with
	a menu, from which they can perform different operations.

*/

package library.management.system;

import javax.swing.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener, Runnable{
	final private JPanel contentPane;
	final private JButton b1, b2, b3, b4, b5, b6;
	final private JButton timeButton, dateButton;
	final private JPanel panel1;
	final private JMenuBar menuBar;
	int hours = 0, minutes = 0, seconds = 0;
	String timeString = "", timeString2 = "";
	Thread thread = null;
	public static void main(String[] args) {
		new Home().setVisible(true);
	}
	
	// This method is responsible for setting device time and date to buttons
	public void printTime() {
		timeButton.setText(timeString);
		dateButton.setText(timeString2);
	}

	// Thread for displaying time and date 
	@Override
	public void run() {	
		try {
			while(true) {
				Calendar calendar = Calendar.getInstance();
				hours = calendar.get(Calendar.HOUR_OF_DAY);
				if(hours > 12)
					hours -= 12;
				minutes = calendar.get(Calendar.MINUTE);
				seconds = calendar.get(Calendar.SECOND);
				
				SimpleDateFormat formatter = new SimpleDateFormat("hh.mm.ss");
				SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-YYYY");
				Date date = calendar.getTime();
				timeString = formatter.format(date);
				timeString2 = formatter2.format(date);
				
				printTime();	//Invoking printTime method
				thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public Home() {
		super("Home - Library Management System");
		setBounds(0, 0, 1376, 762);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 88, 133), new Color(229, 229, 229)));
		menuBar.setBounds(0, 10, 1366, 35);
		menuBar.setBackground(new Color(0, 88, 133));
		contentPane.add(menuBar);
		
		JMenu recordMenu = new JMenu("Record");
		recordMenu.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 17));
		recordMenu.setForeground(Color.WHITE);
		menuBar.add(recordMenu);
		
		JMenuItem bookDetails = new JMenuItem("Book Details");
		bookDetails.setFont(new Font("Calibri", Font.PLAIN, 17));
		bookDetails.setBackground(Color.WHITE);
		bookDetails.setForeground(Color.DARK_GRAY);
		bookDetails.addActionListener(this);
		recordMenu.add(bookDetails);
		
		JMenuItem studentDetails = new JMenuItem("Student Details");
		studentDetails.setFont(new Font("Calibri", Font.PLAIN, 17));
		studentDetails.setBackground(Color.WHITE);
		studentDetails.setForeground(Color.DARK_GRAY);
		studentDetails.addActionListener(this);
		recordMenu.add(studentDetails);
		
		JMenuItem exportItem = new JMenuItem("Export to Pdf");
		exportItem.setFont(new Font("Calibri", Font.PLAIN, 17));
		exportItem.setBackground(Color.WHITE);
		exportItem.setForeground(Color.DARK_GRAY);
		exportItem.addActionListener(this);
		recordMenu.add(exportItem);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 17));
		helpMenu.setForeground(Color.WHITE);
		menuBar.add(helpMenu);
		
		JMenuItem readme = new JMenuItem("Read Me");
		readme.setFont(new Font("Calibri", Font.PLAIN, 17));
		readme.setBackground(Color.WHITE);
		readme.setForeground(Color.DARK_GRAY);
		readme.addActionListener(this);
		helpMenu.add(readme);
                
                JMenuItem howtoItem = new JMenuItem("Help Contents");
		howtoItem.setFont(new Font("Calibri", Font.PLAIN, 17));
		howtoItem.setBackground(Color.WHITE);
		howtoItem.setForeground(Color.DARK_GRAY);
		howtoItem.addActionListener(this);
		helpMenu.add(howtoItem);
		
		JMenuItem aboutUs = new JMenuItem("About Us");
		aboutUs.setFont(new Font("Calibri", Font.PLAIN, 17));
		aboutUs.setBackground(Color.WHITE);
		aboutUs.setForeground(Color.DARK_GRAY);
		aboutUs.addActionListener(this);
		helpMenu.add(aboutUs);

		JMenu exitM = new JMenu("Exit");
		exitM.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 17));
		exitM.setForeground(Color.WHITE);
		menuBar.add(exitM);
		
		JMenuItem exitLogout = new JMenuItem("Log Out");
		exitLogout.setFont(new Font("Calibri", Font.PLAIN, 17));
		exitLogout.setBackground(Color.WHITE);
		exitLogout.setForeground(Color.DARK_GRAY);
		exitLogout.addActionListener(this);
		exitM.add(exitLogout);
		
		JMenuItem exitExit = new JMenuItem("Quit");
		exitExit.setFont(new Font("Calibri", Font.PLAIN, 17));
		exitExit.setBackground(Color.WHITE);
		exitExit.setForeground(Color.DARK_GRAY);
		exitExit.addActionListener(this);
		exitM.add(exitExit);
		
		JLabel l1 = new JLabel("Library Management System");
		l1.setForeground(new Color(0, 88, 133));
		l1.setFont(new Font("Calibri", Font.BOLD, 40));
		l1.setBounds(500, 40, 701, 80);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/addBook.png"));
		Image i11 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i111 = new ImageIcon(i11);  
		l2 = new JLabel(i111);
		l2.setBounds(360, 140, 200, 200);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/statistics.png"));
		Image i21 = i2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i211 = new ImageIcon(i21);  
		l3 = new JLabel(i211);
		l3.setBounds(610, 140, 200, 200);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/addStudent.png"));
		Image i31 = i3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i311 = new ImageIcon(i31);  
		l4 = new JLabel(i311);
		l4.setBounds(875, 140, 200, 200);
		contentPane.add(l4);

		JLabel l5 = new JLabel("");
		l5.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/iBook.png"));
		Image i41 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i411 = new ImageIcon(i41);  
		l5 = new JLabel(i411);
		l5.setBounds(360, 440, 200, 200);
		contentPane.add(l5);

		JLabel l6 = new JLabel("");
		l6.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/rBook.png"));
		Image i51 = i5.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i511 = new ImageIcon(i51);  
		l6 = new JLabel(i511);
		l6.setBounds(625, 440, 200, 200);
		contentPane.add(l6);
	
		JLabel l7 = new JLabel("");
		l2.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aboutme.png"));
		Image i61 = i6.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i611 = new ImageIcon(i61);  
		l7 = new JLabel(i611);
		l7.setBounds(870, 440, 200, 200);
		contentPane.add(l7);

		b1 = new JButton("Add Books");
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(0, 88, 133));
		b1.setBounds(390, 320, 160, 40);
		contentPane.add(b1);
		
		b2 = new JButton("Statistics");
		b2.addActionListener(this);
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(0, 88, 133));
		b2.setBounds(645, 320, 160, 40);
		contentPane.add(b2);
				
		b3 = new JButton("Add Students");
		b3.addActionListener(this);
		b3.setForeground(Color.WHITE);
		b3.setBackground(new Color(0, 88, 133));
		b3.setBounds(900, 320, 160, 40);
		contentPane.add(b3);

		b4 = new JButton("Issue Book");
		b4.addActionListener(this);
		b4.setForeground(Color.WHITE);
		b4.setBackground(new Color(0, 88, 133));
		b4.setBounds(390, 622, 160, 40);
		contentPane.add(b4);
		
		b5 = new JButton("Return Book");
		b5.addActionListener(this);
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(0, 88, 133));
		b5.setBounds(645, 622, 160, 40);
		contentPane.add(b5);
				
		b6 = new JButton("About Us");
		b6.addActionListener(this);
		b6.setForeground(Color.WHITE);
		b6.setBackground(new Color(0, 88, 133));
		b6.setBounds(900, 622, 160, 40);
		contentPane.add(b6);
                
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 133), 2), "Dashboard", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 88, 133)));
		panel1.setBounds(350, 120, 750, 580);
		panel1.setBackground(Color.WHITE);
		contentPane.add(panel1);
		
		JLabel timeLabel = new JLabel("Time and Date");
		timeLabel.setBounds(105, 125, 150, 30);
		contentPane.add(timeLabel);
		timeLabel.setForeground(new Color(0, 88, 133));
		
		// Creating new thread
		thread = new Thread(this);

		// Button for displaying time
		timeButton = new JButton("");
		timeButton.setBounds(70, 155, 150, 30);
		timeButton.setBorder(new LineBorder(new Color(0, 88, 133)));
		timeButton.setForeground(Color.white);
		timeButton.setBackground(new Color(0, 88, 133));
		contentPane.add(timeButton);
		
		// Button for displaying date
		dateButton = new JButton("");
		dateButton.setBounds(70, 175, 150, 30);
		dateButton.setBorder(new LineBorder(new Color(0, 88, 133)));
		dateButton.setForeground(Color.white);
		dateButton.setBackground(new Color(0, 88, 133));
		contentPane.add(dateButton);

		thread.start();
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// For menu and menu items
		String msgString = e.getActionCommand();
		
		if(msgString.equals("Book Details")) {
			new BookDetails().setVisible(true);
		}
		if(msgString.equals("Student Details")) {
			new StudentDetails().setVisible(true);
		}
		if(msgString.equals("Export to Pdf")) {
			new ExportToPdf().setVisible(true);
		}

		if(msgString.equals("Read Me")) {
			new ReadMe().setVisible(true);
		}
                if(msgString.equals("Help Contents")) {
			new HowToUse().setVisible(true);
		}
		if(msgString.equals("About Us")) {
			new AboutUs().setVisible(true);
		}
		if(msgString.equals("Log Out")) {
			setVisible(false);
			new LoginUser().setVisible(true);
		}
		if(msgString.equals("Quit")) {
			System.exit(ABORT);
		}
		
		// For buttons
		if(e.getSource() == b1) {
			new AddBooks().setVisible(true);
		}
		if(e.getSource() == b2) {
			new Statistics().setVisible(true);
		}
		if(e.getSource() == b3) {
			new AddStudents().setVisible(true);
		}
		if(e.getSource() == b4) {
			new IssueBook().setVisible(true);
		}
		if(e.getSource() == b5) {
			new ReturnBook().setVisible(true);
		}
		if(e.getSource() == b6) {
			new AboutUs().setVisible(true);
		}
	}
}
